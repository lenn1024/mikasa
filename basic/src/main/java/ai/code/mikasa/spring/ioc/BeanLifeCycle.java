package ai.code.mikasa.spring.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanLifeCycle implements BeanNameAware, BeanFactoryAware, ApplicationContextAware,
        BeanPostProcessor, InitializingBean, DisposableBean {
    private static Logger logger = LoggerFactory.getLogger(BeanLifeCycle.class);

    private String name;

    private BeanLifeCycle(){
        logger.info("Call method 构造函数.");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BeanLifeCycle{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void setBeanName(String name) {
        logger.info("bean({}) Call method setBeanName.", name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info("Call method setBeanFactory.");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("Call method setApplicationContext.");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.info("Bean name: {}, call method postProcessBeforeInitialization.", beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.info("Bean name: {}, Call method postProcessAfterInitialization.", beanName);
        return bean;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("Call method afterPropertiesSet.");
    }


    @Override
    public void destroy() throws Exception {
        logger.info("Call method destroy.");
    }
}
