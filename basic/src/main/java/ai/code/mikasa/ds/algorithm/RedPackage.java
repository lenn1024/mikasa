package ai.code.mikasa.ds.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 随机红包算法: 二倍均值法
 */
public class RedPackage {

    public static void main(String[] args){
        List<Integer> redPackages = divideRedPackage(100, 5);
        System.out.println(redPackages);
    }

    public static List<Integer> divideRedPackage(int amount, int peopleNum){
        List<Integer> redPackages = new ArrayList<>();

        Random random = new Random();

        int restAmount = amount;
        int restPeople = peopleNum;
        for(int i = 0; i < peopleNum; i++){
            int redpackage = random.nextInt(restAmount/restPeople * 2 - 2) + 1;
            redPackages.add(redpackage);
            restAmount = restAmount - redpackage;
            restPeople--;
        }

        return redPackages;
    }
}
