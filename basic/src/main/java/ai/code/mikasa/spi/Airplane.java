package ai.code.mikasa.spi;

import java.util.ServiceLoader;

public class Airplane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Airplane is flying.");
    }

    public static void main(String[] args){
        ServiceLoader<Flyable> serviceLoader = ServiceLoader.load(Flyable.class);
        System.out.println("Java SPI.");
        serviceLoader.forEach(Flyable::fly);
    }
}
