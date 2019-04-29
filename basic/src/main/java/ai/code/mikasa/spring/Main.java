package ai.code.mikasa.spring;

import ai.code.mikasa.spring.beans.BusinessMan;
import ai.code.mikasa.spring.config.BeanConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-config.xml");
//        Mstone mstone = context.getBean(Mstone.class);
//        System.out.println(mstone);

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        BusinessMan businessMan = context.getBean(BusinessMan.class);

        businessMan.goForBusiness("罗马路");
    }
}
