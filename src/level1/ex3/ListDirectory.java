package level1.ex3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ListDirectory {
    public static void showSortedDirectoryInFile(int level, Path path, FileWriter fileToWrite) throws IOException {
        File dir = path.toFile();
        if (!dir.exists()){
            System.out.println("The directory does not exist.");
            return;
        }
        if (!dir.isDirectory()) {
            System.out.println("Is not a directory.");
            return;
        }
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("The directory is empty");
            return ;
        }
        Arrays.sort(files, (f1, f2) -> f1.getName().compareToIgnoreCase(f2.getName()));
        String indent = " ".repeat(level);

        for (File file : files) {
            Date lastModified = new Date(file.lastModified());
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String formatterData = formatter.format(lastModified);
            if (file.isDirectory()) {
                fileToWrite.write(indent + "(D) " + file.getName() + " " + formatterData + "\n");
                showSortedDirectoryInFile(level++, Paths.get(path + File.separator + file.getName()), fileToWrite);
            }
            else
                fileToWrite.write(indent + "(F) " + file.getName() + " "  + formatterData + "\n");
        }
    }
    public static void main(String []args) {
        if (args.length == 0) {
            System.out.println("Put a path, to list.");
            return ;
        }
        try (FileWriter fileToWrite = new FileWriter("ListDirectory.txt", false);){
            ListDirectory.showSortedDirectoryInFile(0, Paths.get(args[0]), fileToWrite);
            System.out.println("File created successfully.");
        }
        catch (IOException e) {
            System.out.println("Error while we are crating the file: " + e.getMessage());
        }
    }
}