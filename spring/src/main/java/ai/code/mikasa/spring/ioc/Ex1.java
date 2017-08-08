package ai.code.mikasa.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lenn on 17/2/21.
 */
public class Ex1 {
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/ioc/ex1.xml");

        Lenn lenn = (Lenn)context.getBean("lenn");

        System.out.println(lenn.getLike());
    }
}
