package ai.code.mikasa.spring.aop.example3;

/**
 * Created by lenn on 16/9/10.
 */
public class Magician implements MindReader {
    private String thoughts;
    @Override
    public void interceptThoughts(String thoughts) {
        System.out.println("Intercepting volunteer's thoughts");
        this.thoughts = thoughts;
    }

    @Override
    public String getThoughts() {
        return thoughts;
    }
}
