package ai.code.mikasa.spring.beans;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class GovermentMan {

    @Before("execution(* ai.code.mikasa.spring.beans.BusinessMan.goForBusiness(..))")
    public void tax(){
        System.out.println("政府人员收税。");
    }


    @After("execution(* ai.code.mikasa.spring.beans.BusinessMan.goForBusiness(String)) && args(road)")
    public void postTax(String road){

        System.out.println("有商人过路了，政府人员再收一次税。 路：" + road);
    }

    @AfterReturning("execution(* ai.code.mikasa.spring.beans.BusinessMan.goForBusiness(String))")
    public void postReturnTax(){
        System.out.println("政府人员最后收一次税。");
    }
}
