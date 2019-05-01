package ai.code.mikasa.ds.sort;

/**
 * 快排序
 */
public class QuickSort {

    public static void main(String[] args){
        QuickSort instance = new QuickSort();
        int[] array = new int[]{2, 3, 1, 5, 8, 6, 7, 10, 9};
        instance.quickSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++){
            System.out.println(i);
        }
    }

    public void quickSort(int[] array, int startIndex, int endIndex){
        if(startIndex >= endIndex){
            return;
        }

        int pivotIndex = partition(array, startIndex, endIndex);
        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
    }

    /**
     * 分区
     * @param array
     * @param startIndex
     * @param endIndex
     * @return
     */
    public int partition(int[] array, int startIndex, int endIndex){
        int left = startIndex, right = endIndex;
        int pivot = array[startIndex];
        while (left < right){
            while (left < right && array[right] > pivot){
                right--;
            }

            while (left < right && array[left] <= pivot){
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
