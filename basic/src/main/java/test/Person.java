package test;

import java.lang.reflect.Constructor;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Constructor constructor = Test4.class.getConstructor(String.class);
        System.out.println(constructor.toGenericString());
    }
}
