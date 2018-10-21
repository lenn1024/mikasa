package ai.code.mikasa.spring.aop.example3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lenn on 16/9/11.
 */
public class Example3 {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/example3.xml");
        Thinker thinker= (Thinker)applicationContext.getBean("thinker");
        thinker.thinkOfSomething("Queen of Hearts!");

        MindReader mindReader = (MindReader) applicationContext.getBean("mindReader");
        System.out.println(mindReader.getThoughts());
    }
}
