package ai.code.mikasa.ds.algorithm;

/**
 * Top K 问题
 */
public class TopK {

    public static void main(String[] args){
        int[] array = new int[]{2, 13, 4, 3, 1, 5, 8, 9, 7, 6, 10, 12};
        int index = topK(array, 0, array.length - 1, 5);

        for(int i = 0; i <= index; i++){
            System.out.println(array[i]);
        }
    }

    public static int topK(int[] array, int startIndex, int endIndex, int k){

        if(startIndex == endIndex){
            return startIndex;
        }

        int pivotIndex = partition(array, startIndex, endIndex);

        if(pivotIndex - startIndex + 1 == k){
            return pivotIndex;
        }else if(pivotIndex - startIndex + 1 > k){
            return topK(array, startIndex, pivotIndex - 1, k);
        } else {
            return topK(array, pivotIndex + 1, endIndex, k - pivotIndex - 1);
        }
    }


    public static int partition(int[] array, int startIndex, int endIndex){
        int left = startIndex, right = endIndex;
        int pivot = array[startIndex];
        while (left < right){
            while (left < right && array[right] < pivot){
                right--;
            }

            while (left < right && array[left] >= pivot){
                left++;
            }

            if(left < right){
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }

        array[startIndex] = array[left];
        array[left] = pivot;

        return left;
    }
}
