package ai.code.mikasa.leetcode;

public class S11 {

    public static void main(String[] args){
        S11 instance = new S11();
        System.out.println(instance.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(instance.maxArea(new int[]{1,1}));
    }

    public int maxArea(int[] height) {
        int maxArea = 0;

        int left = 0;
        int right = height.length - 1;
        while (left < right){
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }

        return maxArea;
    }
}
