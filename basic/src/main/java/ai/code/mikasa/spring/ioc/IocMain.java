package ai.code.mikasa.spring.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenn on 17/2/21.
 */
public class IocMain {
    private static Logger logger = LoggerFactory.getLogger(IocMain.class);

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/ioc/ioc-main.xml");

        logger.info("=========================================================");
        logger.info("context id: {}.", context.getId());
        logger.info("application name: {}.", context.getApplicationName());
        logger.info("display name: {}.", context.getDisplayName());
        logger.info("startup date: {}.", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(context.getStartupDate())));
        logger.info("parent: {}.", context.getParent());

        BeanLifeCycle beanLifeCycle = context.getBean("beanLifeCycle", BeanLifeCycle.class);
        logger.info("{}", beanLifeCycle);

        TestClass testClass = context.getBean("testClass", TestClass.class);
        logger.info("{}", testClass);

        String[] alias = context.getAliases("testClass");
        logger.info("alias: {}", alias);

        // 软引用
        SoftReference<Object> softReference = new SoftReference<>(new Object());
        Object object = softReference.get();
        logger.info("object: {}.", object);

        // 弱引用
        WeakReference<Object> weakReference = new WeakReference<>(new Object());
        object = weakReference.get();
        logger.info("object: {}, isEnqueued: {}.", object, weakReference.isEnqueued());

        // 虚引用
        PhantomReference<Object> phantomReference = new PhantomReference<>(new Object(), null);
        object = phantomReference.get();
        logger.info("object: {}, isEnqueued: {}.", object, phantomReference.isEnqueued());
    }
}
