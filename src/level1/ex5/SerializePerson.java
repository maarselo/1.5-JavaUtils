package level1.ex5;

import java.io.*;

public class SerializePerson {
    public static void serializePerson(Person person, String file) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(person);
            System.out.println("Object Serialized successfully.");
        } catch (IOException e) {
            System.out.println("Error serializing: " + e.getMessage());
        }
    }
}
