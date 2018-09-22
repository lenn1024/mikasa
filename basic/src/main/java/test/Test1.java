package test;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Test1 {

    public BigDecimal getValue(){
        BigDecimal v = new BigDecimal(0.01);
        System.out.println(v);
        return v;
    }

    public static void main(String[] args){
        List<String> fruits =  Arrays.asList("apple", "banana", "pear");
        fruits.stream().forEach(item -> System.out.println(item));

        List<String> set = fruits.stream()
//                .filter(item -> item.equals("apple"))
//                .map(item -> item.split(""))
                .map(item -> StringUtils.split(item, ""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());

        System.out.println(set);

        Arrays.stream("apple".split(""))
                .forEach(str -> System.out.println(str));
        Arrays.stream(StringUtils.split("apple", ""))
                .forEach(str -> System.out.println(str));

        System.out.println(fruits.stream().allMatch(item -> item.length() > 2));
        System.out.println(fruits.stream().anyMatch(item -> item.equals("apple")));
        System.out.println(fruits.stream().max((a, b) -> a.length() - b.length()).get());
        System.out.println(fruits.stream().min((a, b) -> a.length() - b.length()).get());

        System.out.println(fruits.stream().reduce((a, b) -> a + ", " + b).orElse("dudu"));


        IntSummaryStatistics statistics = fruits.stream().mapToInt(String::length).summaryStatistics();
        System.out.println(statistics);

        Optional<String> optional = null;
        Optional.ofNullable(null);
    }

}
