package ai.code.mikasa.ds.algorithm;

import java.util.*;

/**
 * Created by lenn on 17/2/27.
 */
public class ThreeSum {
    public static void main(String[] args){
        threeSum(new int[]{1, 2, 3, 4, 5}, 10);
    }

    public static void threeSum(int[] array, int sum){
        // 1. 先排序
        Arrays.sort(array);

        int len = array.length;
        // 2. 二分查找
        for (int i = 0; i < len - 1; i++){
            for(int j = i + 1; j < len -1; j++){
                if(j + 1 >= len){
                    break;
                }
                int result = Arrays.binarySearch(array, j + 1, len, sum - array[i] - array[j]);

                if(result > 0){
                    System.out.println(array[i] + "," + array[j] + "," + array[result]);
                }
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        if(len < 3){
            return list;
        }

        // 1. sort
        Arrays.sort(nums);

        if(0 == nums[0] && 0 == nums[len-1]){
            List<Integer> l = new ArrayList<>(3);
            l.add(0);
            l.add(0);
            l.add(0);

            list.add(l);
            return list;
        }

        Set<String> set = new HashSet<>();

        // 2. binary search
        for (int i = 0; i < len - 1; i++){
            for(int j = i + 1; j < len -1; j++){
                if(j + 1 >= len){
                    break;
                }
                int index = Arrays.binarySearch(nums, j + 1, len, -(nums[i] + nums[j]));
                if(index > 0){
                    String group = "" + nums[i] + nums[j] + nums[index];
                    if(!set.contains(group)){
                        set.add(group);
                        List<Integer> l = new ArrayList<>(3);
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[index]);
                        list.add(l);
                    }
                }
            }
        }

        return list;
    }

}
