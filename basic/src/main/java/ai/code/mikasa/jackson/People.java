package ai.code.mikasa.jackson;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class People {
    private String name;
    private int age;
    private boolean female;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isFemale() {
        return female;
    }

    public void setFemale(boolean female) {
        this.female = female;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", female=" + female +
                '}';
    }
}
