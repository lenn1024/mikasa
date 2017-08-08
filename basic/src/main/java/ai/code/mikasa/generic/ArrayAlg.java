package ai.code.mikasa.generic;

/**
 * Created by lenn on 16/10/20.
 * 定义泛型方法
 */
public class ArrayAlg {
    //
    public static <T> T getMiddle(T...a){
        return a[a.length/2];
    }
}
