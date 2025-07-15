package level1.ex1;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class ListDirectory {
    private Path path;

    public ListDirectory(Path path) {
        this.path = path;
    }

    public void showSortedDirectory() {
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
        for (File file : files) {
            if (file.isDirectory())
                System.out.println("[DIR]  " + file.getName());
            else
                System.out.println("       " + file.getName());
        }
    }

    public Path getPath() {return path;}
    public void setPath(Path path) {this.path = path;}

    public static void main(String []args) {
        if (args.length == 0) {
            System.out.println("Put a path, to list.");
            return ;
        }
        ListDirectory listDirectory = new ListDirectory(Paths.get(args[0]));
        listDirectory.showSortedDirectory();
    }
}
