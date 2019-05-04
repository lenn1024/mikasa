package ai.code.mikasa.ds.algorithm;

/**
 * 对于给定无序数组，找出排序后任意相邻两个元素的差值的最大值
 *
 * 利用计数排序，时间复杂度为O(n)
 */
public class NoSortArrayMaxDiffValue {

    public static void main(String[] args){
        int[] array = new int[]{2, 6, 3, 4, 5, 10};
        System.out.println("排序后任意相邻两个元素的差值的最大值为：" + getMaxDiffVal(array));
    }

    public static int getMaxDiffVal(int[] array){
        if(array == null || array.length == 0){
            throw new IllegalArgumentException("array can not be empty.");
        }

        // 找出最大值和最小值
        int max = array[0], min = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }

            if(array[i] < min){
                min = array[i];
            }
        }

        // 申请的数组长度
        int len = max - min + 1;
        int offset = min;
        int[] countArray = new int[len];

        // 计数
        for (int i = 0; i < array.length; i++){
            int index = array[i] - offset;
            countArray[index]++;
        }

        // 若都是相同的元素，则差值为0
        if(countArray.length == 1){
            return 0;
        }

        // 找出连续出现0的最大次数
        int maxDiffVal = 1;
        int diffVal = 1;
        for(int i = 0; i < len; i++){
            if(countArray[i] == 0){
                diffVal++;
            }else {
                maxDiffVal = diffVal > maxDiffVal ? diffVal : maxDiffVal;
                diffVal = 1;
            }
        }

        return maxDiffVal;
    }
}
