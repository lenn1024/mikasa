package ai.code.mikasa.spring.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lenn on 17/2/21.
 */
public class IocMain {
    private static Logger logger = LoggerFactory.getLogger(IocMain.class);

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/ioc/ioc-main.xml");

        BeanLifeCycle beanLifeCycle = (BeanLifeCycle) context.getBean("beanLifeCycle");
        logger.info("{}", beanLifeCycle);

        TestClass testClass = (TestClass) context.getBean("testClass");
        logger.info("{}", testClass);
    }
}
