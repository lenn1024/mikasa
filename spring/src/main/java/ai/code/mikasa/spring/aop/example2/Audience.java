package ai.code.mikasa.spring.aop.example2;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by lenn on 16/9/10.
 */
public class Audience {
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
