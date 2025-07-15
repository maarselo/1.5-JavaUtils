package level1.ex5;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializePerson {
    public static Person deserializePerson(String file) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (Person) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error deserializing: " + e.getMessage());
            return null;
        }
    }
}
