package ai.code.mikasa.ds.algorithm;

import java.util.Arrays;

/**
 * Created by lenn on 17/2/27.
 */
public class TwoSum {

    public static void main(String[] args){
        twoSum(new int[]{1, 2, 3, 4, 5}, 10);
    }

    public static void twoSum(int[] array, int sum){
        // 1. 先排序
        Arrays.sort(array);

        // 2.
        for(int i = 0; i < array.length; i++){
            if(i + 1 < array.length){
                break;
            }

            int index = Arrays.binarySearch(array, i + 1, array.length - 1, sum - array[i]);

            if(index > 0){
                System.out.println(array[i] + "  " + array[index]);
            }
        }
    }
}
