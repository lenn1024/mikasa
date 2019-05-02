package ai.code.mikasa.ds.sort;

/**
 * 单边循环快排序
 */
public class OneWayQuickSort {

    public static void main(String[] args){
        OneWayQuickSort instance = new OneWayQuickSort();

        int[] array = new int[]{2, 4, 1, 3, 7, 6, 5, 8, 9};
        instance.quickSort(array, 0, array.length -1);
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
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

    public int partition(int[] array, int startIndex, int endIndex){
        int pivot = array[startIndex];
        int mark = startIndex;

        for(int i = startIndex + 1; i <= endIndex; i++){
            if(array[i] < pivot){
                mark++;
                int temp = array[i];
                array[i] = array[mark];
                array[mark] = temp;
            }
        }

        array[startIndex] = array[mark];
        array[mark] = pivot;

        return mark;
    }
}
