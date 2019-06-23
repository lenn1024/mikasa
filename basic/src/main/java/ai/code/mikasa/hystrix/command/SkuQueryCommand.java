package ai.code.mikasa.hystrix.command;

import com.netflix.hystrix.*;

import java.util.Random;

public class SkuQueryCommand extends HystrixCommand<Integer> {

    public static void main(String[] args){
        for(int i = 0; i < 100; i++){
            System.out.println("第" + i + "次执行.");
            SkuQueryCommand skuQueryCommand = new SkuQueryCommand();
            Integer result = skuQueryCommand.execute();
            System.out.println("result: " + result);
            delay(100);
        }
    }

    /**
     * 熔断器构造器
     */
    protected SkuQueryCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("skuQueryService"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("querySku"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        // 至少有10个请求，熔断器才会进行错误率的计算
                        .withCircuitBreakerRequestVolumeThreshold(10)
                        // 熔断器熔断5秒后会进入半打开状态，放部分流量进来进行重试
                        .withCircuitBreakerSleepWindowInMilliseconds(5000)
                        // 错误率达到50%会开启熔断保护
                        .withCircuitBreakerErrorThresholdPercentage(40)
                        .withFallbackEnabled(true)
                        .withExecutionTimeoutEnabled(true))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(10))
        );
    }

    @Override
    protected Integer run() throws Exception {
        int num = new Random().nextInt(10);
        if(num > 5){
            System.out.println("num:" + num);
            throw new RuntimeException("异常啦。");
        }
        System.out.println("num:" + num);
        return num;
    }

    @Override
    protected Integer getFallback() {
        return -1;
    }

    /**
     * 延迟milliseconds毫秒
     * @param milliseconds
     */
    private static void delay(long milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
