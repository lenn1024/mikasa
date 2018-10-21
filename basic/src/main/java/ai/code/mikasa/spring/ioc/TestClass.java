package ai.code.mikasa.spring.ioc;

public class TestClass {
    private String name;

    private TestClass(){
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "name='" + name + '\'' +
                '}';
    }
}
