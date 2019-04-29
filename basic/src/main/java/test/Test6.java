package test;

import java.util.*;
import java.util.stream.Collectors;

public class Test6 {
    public static void main(String[] args){
        // System.out.println(Arrays.asList(1, 2, 3, 4).stream().limit(10).collect(Collectors.toList()));
        //System.out.println(Test6.class.getClassLoader().getResource("/"));
        System.out.println(Test6.class.getResource(""));
    }


    /**
     * 构造一个数列，相邻的两个数只能有一个bit不一样
     * @param n
     * @return
     */
    public static List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        if(n == 0){
            list.add(0);
            return list;
        }

        // 计算结果总个数
        int size = 1;
        for(int i = 0; i < n; i++){
            size *= 2;
        }

        // 构造code集合
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i < size; i++){
            set.add(i);
        }

        // 构造gray code
        list.add(0);
        int preValue = 0;
        for(int i = 1; i < size; i++){
            int code = getDiffCode(preValue, n, set);
            list.add(code);
            set.remove(code);
            preValue = code;
        }

        return list;
    }

    public static Integer getDiffCode(int value, int n, Set<Integer> set){
        // 循环从低位到高位做异或
        for(int i = 0; i < n; i++){
            int code = (1 << i) ^ value;
            if(set.contains(code)){
                return code;
            }
        }
        throw new RuntimeException("构造异常.");
    }
}
