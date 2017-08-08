package ai.code.mikasa.prototype;

/**
 * Created by lenn on 16/4/15.
 * 原型模式, java中只要实现Cloneable接口, 复写clone方法即可
 * 注意:原型对象中有引用类型的域时,注意一下浅拷贝和深拷贝的问题
 */
public class MyPrototype implements Cloneable {

    private int filedOne;

    private String filedTwo;

    private String filedThree;

    public MyPrototype(int filedOne, String filedTwo, String filedThree) {
        this.filedOne = filedOne;
        this.filedTwo = filedTwo;
        this.filedThree = filedThree;
    }

    public int getFiledOne() {
        return filedOne;
    }

    public void setFiledOne(int filedOne) {
        this.filedOne = filedOne;
    }

    public String getFiledTwo() {
        return filedTwo;
    }

    public void setFiledTwo(String filedTwo) {
        this.filedTwo = filedTwo;
    }

    public String getFiledThree() {
        return filedThree;
    }

    public void setFiledThree(String filedThree) {
        this.filedThree = filedThree;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "MyPrototype{" +
                "filedOne=" + filedOne +
                ", filedTwo='" + filedTwo + '\'' +
                ", filedThree='" + filedThree + '\'' +
                '}';
    }
}
