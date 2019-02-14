package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

public class Person {
    private static Logger logger = LoggerFactory.getLogger(Person.class);

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareByPerson(Person person){
        return this.age - person.age;
    }

    public void say(String[] words){
        for(String word: words){
            System.out.println(word);
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Constructor constructor = Test4.class.getConstructor(String.class);
        logger.info(constructor.toGenericString());

        List<Person> list = Arrays.asList(new Person("jim", 18), new Person("tom", 16));
        list.sort(Person::compareByPerson);

        System.exit(0);
    }
}
