package ai.code.mikasa.leetcode;

import java.util.HashSet;
import java.util.Set;

public class S55 {
    public static void main(String[] args){
        S55 instance = new S55();
        System.out.println(instance.canJump(new int[]{3,2,1,0,4}));
        System.out.println(instance.canJump(new int[]{2,3,1,1,4}));
        System.out.println(instance.canJump(new int[]{2,3,1,1,4}));
        System.out.println(instance.canJump(new int[]{25000,24999,24998,24997,24996,24995,24994,24993,24992,
                24991,24990,24989,24988,24987,24986,24985,24984,24983,24982,24981,24980,24979,24978,24977,24976,
                24975,24974,24973,24972,24971,24970,24969,24968,24967,24966,24965,24964,24963,24962,24961,24960,
                24959,24958,24957,24956,24955,24954,24953,24952,24951,24950,24949,24948,24947,24946,24945,24944,
                24943,24942,24941,24940,24939,24938,24937,24936,24935,24934,24933,24932,24931,24930,24929,24928,
                24927,24926,24925,24924,24923,24922,24921,24920,24919,24918,24917,24916,24915,24914,24913,24912,
                24911,24910,24909,24908,24907,24906,24905,24904,24903,24902,24901,24900,24899,24898,24897,24896}));
    }

    public boolean canJump(int[] nums) {
        int position = 0;
        int lastIndex = nums.length - 1;
        Set<Integer> steps = new HashSet<>();

        while (true){
            // 记录jump的印记
            steps.add(position);
            // 以最大步子向前迈
            position = position + nums[position];
            if(position >= lastIndex){
                return true;
            }

            // 步子为0，则迈不动了，回溯
            if(nums[position] == 0){
                while (steps.contains(position)){
                    // do nothing
                    position--;
                }
            }

            if(position < 0){
                break;
            }
        }

        return false;
    }
}
