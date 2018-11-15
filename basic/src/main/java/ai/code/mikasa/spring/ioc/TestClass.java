package ai.code.mikasa.spring.ioc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

public class TestClass implements InitializingBean {
    private static Logger logger = LoggerFactory.getLogger(TestClass.class);

    private String name;

    private TestClass(){
    }

    public void setName(String name) {
        this.name = name;
    }

    public void initMethod(){
        logger.info("TestClass call init method.");
    }

    @PostConstruct
    public void postConstruct(){
        logger.info("TestClass call post construct method.");
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("TestClass call method after properties set.");
    }
}
