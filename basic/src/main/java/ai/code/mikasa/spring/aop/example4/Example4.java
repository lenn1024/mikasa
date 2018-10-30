package ai.code.mikasa.spring.aop.example4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lenn on 16/9/10.
 */
public class Example4 {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/aop/example4.xml");
        Performer performer = (Performer) applicationContext.getBean("performer");
        performer.perform();
    }
}
