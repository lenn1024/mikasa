package ai.code.mikasa.prototype;

/**
 * Created by lenn on 16/4/15.
 */
public class PrototypeClient {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyPrototype myPrototype = new MyPrototype(1, "hello world", "hello time");

        System.out.println(myPrototype);

        MyPrototype cloneByPrototype = (MyPrototype)myPrototype.clone();

        System.out.println(cloneByPrototype);

    }
}
