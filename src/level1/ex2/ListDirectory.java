package level1.ex2;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ListDirectory {
        public static void showSortedDirectory(int level, Path path) {
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
                    System.out.println(indent + "(D) " + file.getName() + " " + formatterData);
                    showSortedDirectory(level++, Paths.get(path + File.separator + file.getName()));
                }
                else
                    System.out.println(indent + "(F) " + file.getName() + " "  + formatterData);
            }
        }

        public static void main(String []args) {
            if (args.length == 0) {
                System.out.println("Put a path, to list.");
                return ;
            }
            ListDirectory.showSortedDirectory(0, Paths.get(args[0]));
        }
}