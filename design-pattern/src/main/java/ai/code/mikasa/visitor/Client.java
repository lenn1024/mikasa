package ai.code.mikasa.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenn on 16/10/21.
 */
public class Client {
    public static void main(String[] args){
        // 待访问队列
        List<Element> elements = new ArrayList<>();
        elements.add(new ElementA());
        elements.add(new ElementB());

        // 使用visitor1
        for (Element element : elements){
            element.accept(new Visitor1());
        }

        // 使用visitor2
        for (Element element : elements){
            element.accept(new Visitor2());
        }
    }
}
