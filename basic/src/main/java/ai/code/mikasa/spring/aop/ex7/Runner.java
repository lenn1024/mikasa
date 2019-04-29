package ai.code.mikasa.spring.aop.ex7;

public class Runner implements Run {

    @Override
    public void run() {
        System.out.println("run----");
    }

    @Override
    public void kRun() {
        System.out.println("kRun+++");
    }
}
