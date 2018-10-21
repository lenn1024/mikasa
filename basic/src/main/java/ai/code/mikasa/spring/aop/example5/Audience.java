package ai.code.mikasa.spring.aop.example5;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by lenn on 16/9/10.
 * 注解切面
 * 1. 添加AspectJ注解
 * 2. 添加切点以及标示通知
 * 3. 最后让Spring把该类应用为一个切面(我们需要在Spring上下文中声明一个自动代理Bean,该
 * bean知道如何把@AspectJ注解所标注的Bean转变为代理通知)
 * Spring在aop命名空间中提供了一个自定义的配置元素: <aop:aspectj-autoproxy />
 * <aop:aspectj-autoproxy />将在Spring上下文中创建一个AnnotationAwareAspectJAutoProxyCreator类,
 * 它会自动代理一些bean,这些bean的方法需要与使用@Aspect注解的Bean中定义的切点相匹配.
 */
@Aspect
public class Audience {
    // 定义切点
    @Pointcut( "execution(* waw.sakura.spring.aop.example5.Performer.perform(..))")
    void performance(){
    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint){
        try {
            System.out.println("The audience is taking their seats.");
            System.out.println("The audience is turning off their cellphones.");
            long start = System.currentTimeMillis();
            joinPoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("CLAP CLAP CLAP CLAP.");
            System.out.println("The performance took " + (end - start)
                    + " milliseconds.");

        } catch (Throwable throwable) {
            System.out.println("Boo! We want our money back!");
        }
    }
}
