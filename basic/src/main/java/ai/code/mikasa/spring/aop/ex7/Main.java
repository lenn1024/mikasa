package ai.code.mikasa.spring.aop.ex7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/aop/ex7.xml");
        Run run = (Run) context.getBean("proxyRunner");

        run.run();
        run.kRun();
    }
}
