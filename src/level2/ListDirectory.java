package level2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

public class ListDirectory {
    public static void readFileFromProperties(String pathProperties) {
        Properties properties = new Properties();
        File propertiesFile = new File(pathProperties);
        if (!propertiesFile.exists() || !propertiesFile.isFile()){
            System.out.println("Invalid file."); return;
        }

        try (FileInputStream fileInputStream = new FileInputStream(propertiesFile)) {
            properties.load(fileInputStream);
            String inputDir = properties.getProperty("inputDir");
            String outputFile = properties.getProperty("output");

            if (inputDir == null || inputDir.isEmpty() ||
                    outputFile == null || outputFile.isEmpty()) {
                System.out.println("Missing key."); return;
            }
            try (FileWriter fileWriter = new FileWriter(outputFile)){
                showSortedDirectoryInFile(0, inputDir, fileWriter);
            }
        } catch (IOException e) {
            System.out.println("Error while reading the file: " + e.getMessage());
        }
    }
    public static void showSortedDirectoryInFile(int level, String path, FileWriter fileToWrite) throws IOException {
        File dir = new File(path);
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
                showSortedDirectoryInFile(level + 1, path + File.separator + file.getName(), fileToWrite);
            }
            else
                fileToWrite.write(indent + "(F) " + file.getName() + " "  + formatterData + "\n");
        }
    }
    public static void main(String []args) {
        if (args.length != 1) {
            System.out.println("Put the path for the properties.");
            return;
        }
        readFileFromProperties(args[0]);
    }
}
