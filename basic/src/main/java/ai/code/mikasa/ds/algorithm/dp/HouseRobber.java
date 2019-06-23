package ai.code.mikasa.ds.algorithm.dp;

/**
 * leetcode 198
 * 采用动态规划的思想
 * 递归的话，会出现time limited exceed
 *
 */
public class HouseRobber {

    public static void main(String[] args){
        HouseRobber instance = new HouseRobber();
        System.out.println(instance.rob(new int[]{2,7,9,3,1}));
    }

    public int rob(int[] nums) {
        return rob(nums, 0, nums.length - 1);
    }

    private int rob(int[] nums, int start, int end){
        if(start > end){
            return 0;
        }
        if(end - start == 0){
            return nums[start];
        }
        if(end - start == 1){
            return max(nums[start], nums[end]);
        }

        return max(nums[start] + rob(nums, start + 2, end), rob(nums, start + 1, end));
    }

    private int max(int a, int b){
        return a > b ? a : b;
    }
}
