package ai.code.mikasa.reflection;


import java.lang.reflect.Method;

public class Person extends Animal implements Swimable{

    private String name;

    private int age;

    @Override
    public void breathe() {
        System.out.println("Person breathe.");
    }

    @Override
    public void swim() {
        System.out.println("Person swim.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class<Person> personClass = Person.class;
        Method swimMethod =  personClass.getMethod("swim");
        System.out.println(swimMethod.getModifiers());
    }
}
