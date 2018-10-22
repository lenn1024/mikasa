package ai.code.mikasa.test;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.concurrent.TimeUnit;

public class CaffeineTest {

    static Cache<String, String> cache = Caffeine.newBuilder()
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .recordStats()
            .maximumSize(1)
            .build();

    public static void main(String[] args){
        putTest();
        cache.put("bala", "hah");
        cache.put("balas", "hah");
        cache.getIfPresent("bal");
        cache.getIfPresent("balas");
        System.out.println(cache.stats());
        cache.cleanUp();
        System.out.println(cache.estimatedSize());
    }

    public static void runThread(){
        for(int i = 0; i < 10; i++){
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(String.format("%s - start - %d .", Thread.currentThread().getName(), System.currentTimeMillis()));
                    String key = "key" + finalI;
                    String value = cache.get(key, key_ -> {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return key_ + "#";
                    });
                    System.out.println(String.format("%s - value: %s, end - %d.", Thread.currentThread().getName(), value, System.currentTimeMillis()));
                }
            }).start();
        }
    }

    public static void putTest(){
        // cache.put("key", null); // NullPointerException
        // cache.put(null, "value"); // NullPointerException
    }
}
