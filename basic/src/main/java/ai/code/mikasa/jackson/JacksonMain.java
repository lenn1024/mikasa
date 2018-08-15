package ai.code.mikasa.jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * ObjectMapper
 * 1. 序列化为字符串、由字符串反序列化为对象与字段顺序无关
 * 2. 反序列化：多字段，会抛出 UnrecognizedPropertyException，可由下述代码解决
 *      objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
 * 3. 反序列化：少字段的情况无所谓
 */
public class JacksonMain {
    public static void main(String[] args) throws IOException {
        // 对象序列化为字符串
        People people = new People();
        people.setName("Jim");
        people.setAge(12);

        ObjectMapper objectMapper = new ObjectMapper();

        String peopleStr = objectMapper.writeValueAsString(people);
        System.out.println(peopleStr);

        // 字符串反序列化为对象
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        People people1 = objectMapper.readValue("{\"name\": \"tom\", \"female\" :\"true\", \"age\": 13}", People.class);

        System.out.println(people1);
    }
}
