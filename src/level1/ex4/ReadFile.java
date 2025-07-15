package level1.ex4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class ReadFile {
    public static void readFile(String path) {
        try (FileReader file = new FileReader(path)) {
            BufferedReader br = new BufferedReader(file);
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
    public static void main(String []args) {
        if (args.length == 0) {
            System.out.println("Put a file."); return;
        }
        readFile(args[0]);
    }
}
