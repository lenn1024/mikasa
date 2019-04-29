package ai.code.mikasa.spring.aop.ex7;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class TestAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("before ....");
    }
}
