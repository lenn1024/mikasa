package ai.code.mikasa.ds.algorithm;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 两个Thread按顺序打印字母序列
 * 1. 一个只打印元音字母
 * 2. 另一个只打印其他的字母
 */
public class PrintChar {
    private static int offset = 0;
    public static void main(String[] args){
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        List<Character> chs = new ArrayList<>(26);
        for(Character ch = 'a'; ch <= 'z'; ch++){
            chs.add(ch);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> printChar(true, set, chs));
        executorService.submit(() -> printChar(false, set, chs));
        executorService.shutdown();
    }

    private synchronized static void printChar(boolean isFirst, Set<Character> set, List<Character> chs){
        while (offset < 26){
            if(isFirst && set.contains(chs.get(offset))){
                displayChar(chs.get(offset++));
            } else if(!isFirst && !set.contains(chs.get(offset))){
                displayChar(chs.get(offset++));
            } else {
                PrintChar.class.notify();
                try {
                    PrintChar.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        PrintChar.class.notify();
    }

    private static void displayChar(Character ch){
        String name = Thread.currentThread().getName();
        System.out.println(name + " print [" + ch + "]");
    }
}
