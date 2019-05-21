package ai.code.mikasa.ds.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class MaxAndMinTime {

    public static int[] getMaxAndMinTime(int n){
        if(n < 6){
            throw new IllegalArgumentException("n must bigger than 6.");
        }
        // 申请数组
        int[] nums = new int[n];

        // 初始化数组
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (i < n){
            System.out.println("请输入0~9的数字：");
            int inNum =  scanner.nextInt();
            if(inNum > 10 || inNum < 0){
                throw new RuntimeException("不合法的数字:" + inNum);
            }
            nums[i++] = inNum;
        }

        // 排序
        Arrays.sort(nums);

        return null;
    }

    private static String getMinTime(int n, int[] nums){
        int[] useflags = new int[n];
        StringBuilder minTime = new StringBuilder();
        for(int i = 0; i < 6; i++){
            int j = 0;
            while (j < n){
                if(useflags[j] != 1){
                    if(i == 0){
                        // 时
                        if(0 <= nums[j] && nums[j] <= 2){
                            minTime.append(nums[i]);
                            useflags[j] = 1;
                        }else {
                            System.out.println("时间无效");
                            return null;
                        }
                    }

                    if(i == 1){
                        // 分
                    }
                }
                j++;
            }
        }

        return minTime.toString();
    }

    private static int getMaxTime(int n, int[] nums){

        return 0;
    }
}
