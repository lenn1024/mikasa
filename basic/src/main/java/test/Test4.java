package test;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test4 implements Serializable, Cloneable {
    private String value;
    public Test4(String value){
        this.value = value;
        System.out.println("2222");
    }

    public static void main(String[] args) throws NoSuchMethodException {
//        Constructor[] constructors = Test4.class.getConstructors();
//        for (Constructor constructor: constructors){
//            System.out.println(constructor.toGenericString());
//        }
//
//        Constructor constructor = Test4.class.getConstructor(String.class);
//        System.out.println(constructor.toGenericString());

//        Constructor constructor = Person.class.getConstructor(String.class, int.class);
//        System.out.println(constructor.toGenericString());
        try {
            Class<Person> personClass = (Class<Person>) Test4.class.getClassLoader().loadClass("test.Person");
            Person person = personClass.newInstance();

            Method method = personClass.getMethod("say", new Class[]{String[].class});
            method.invoke(person, new Object[]{new String[]{"aa", "bb"}});
            Array.newInstance(String.class, 2).getClass();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
