package ai.code.mikasa.spring.aop.example3;

/**
 * Created by lenn on 16/9/10.
 */
public class Volunteer implements Thinker {
    private String thoughts;
    @Override
    public void thinkOfSomething(String thoughts) {
        this.thoughts = thoughts;
    }

    public String getThoughts(){
        return this.thoughts;
    }
}
