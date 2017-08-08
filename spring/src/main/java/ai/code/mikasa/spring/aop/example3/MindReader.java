package ai.code.mikasa.spring.aop.example3;

/**
 * Created by lenn on 16/9/10.
 */
public interface MindReader {
    void interceptThoughts(String thoughts);

    String getThoughts();
}
