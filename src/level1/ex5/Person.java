package level1.ex5;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persona{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}