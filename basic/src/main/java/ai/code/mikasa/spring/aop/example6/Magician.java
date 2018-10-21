package ai.code.mikasa.spring.aop.example6;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by lenn on 16/9/10.
 */
@Aspect
public class Magician implements MindReader {
    private String thoughts;

    @Pointcut("execution(* waw.sakura.spring.aop.example6.Thinker.thinkOfSomething(java.lang.String)) && args(thoughts)")
    void thinkOfSomething(String thoughts){
    }

    @Override
    @Before("thinkOfSomething(thoughts)")
    public void interceptThoughts(String thoughts) {
        System.out.println("Intercepting volunteer's thoughts");
        this.thoughts = thoughts;
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }
}
