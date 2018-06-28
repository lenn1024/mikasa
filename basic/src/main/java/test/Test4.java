package test;

import java.io.Serializable;
import java.lang.reflect.Constructor;

public class Test4 implements Serializable, Cloneable {
    private String value;

//    public void Test4(){
//        System.out.println("1111");
//    }

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

        Constructor constructor = Person.class.getConstructor(String.class, int.class);
        System.out.println(constructor.toGenericString());
    }
}
