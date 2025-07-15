package level1.ex5;

public class Main {
    public static void main(String []args) {
        Person person1 = new Person("Marcelo", 18);

        SerializePerson.serializePerson(person1, "PersonOne.ser");

        Person person2 = DeserializePerson.deserializePerson("PersonOne.ser");
        if (person2 != null)
            System.out.println(person2.toString());
    }
}
