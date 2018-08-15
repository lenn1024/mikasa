package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;

public class Person {
    private static Logger logger = LoggerFactory.getLogger(Person.class);

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Object object = null;
        logger.info("sdsdfdsf{}");
        Constructor constructor = Test4.class.getConstructor(String.class);
        System.out.println(constructor.toGenericString());
    }
}
