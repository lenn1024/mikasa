package ai.code.mikasa.ds.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args){
        Subsets instance = new Subsets();
        List<List<Integer>> result = instance.subsets(new int[]{1, 2, 3});
        System.out.println(result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i <= nums.length; i++){
            List<List<Integer>> subResult = subsets(nums, 0, i);
            result.addAll(subResult);
        }

        return result;
    }

    public List<List<Integer>> subsets(int[] nums, int startIndex, int k){
        // 返回结果
        List<List<Integer>> result = new ArrayList<>();

        // 处理边界case
        if(k == 0){
            List<Integer> list = new ArrayList<>();
            result.add(list);
            return result;
        }
        // 获取数组的长度
        int len = nums.length;
        if(len - startIndex == k){
            List<Integer> list = new ArrayList<>();
            for(int i = startIndex; i < len; i++){
                list.add(nums[i]);
            }
            result.add(list);
            return result;
        }

        // 递归计算子集
        List<List<Integer>> result1 = subsets(nums, startIndex + 1, k - 1);
        for(List<Integer> list: result1){
            list.add(nums[startIndex]);
        }

        List<List<Integer>> result2 = subsets(nums, startIndex + 1, k);

        result.addAll(result1);
        result.addAll(result2);
        return result;
    }
}
