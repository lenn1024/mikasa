package ai.code.mikasa;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

@RunWith(BlockJUnit4ClassRunner.class)
public class JunitTest {

    @BeforeClass
    public static void testBeforeClass1(){
        System.out.println("testBeforeClass1");
    }

    @BeforeClass
    public static void testBeforeClass2(){
        System.out.println("testBeforeClass2");
    }

    @Before
    public void testBefore1(){
        System.out.println("testBefore1");
    }

    @Before
    public void testBefore2(){
        System.out.println("testBefore2");
    }

    @Test
    public void testMethod1(){
        System.out.println("testMethod1");
    }

    @Test
    public void testMethod2(){
        System.out.println("testMethod2");
    }

    @After
    public void testAfter1(){
        System.out.println("testAfter1");
    }

    @After
    public void testAfter2(){
        System.out.println("testAfter2");
    }


    @AfterClass
    public static void testAfterClass1(){
        System.out.println("testAfterClass1");
    }

    @AfterClass
    public static void testAfterClass2(){
        System.out.println("testAfterClass2");
    }

    @Ignore
    @Test
    public void ignoreMethod(){
        System.out.println("ignoreMethod");
    }

    @Test
    public void testFailed(){
        System.out.println("testFailed");
        throw new RuntimeException("testFailed");
    }

    @Test
    public void testAssumptionFailed(){
        System.out.println("testAssumptionFailed");
        Assume.assumeTrue(1 == 2);
    }

    @Test
    public void testFilteredOut(){
        System.out.println("testFilteredOut");
    }
}
