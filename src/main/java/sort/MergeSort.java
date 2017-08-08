package sort;

/**
 * Created by lenn on 17/2/20.
 * 归并排序
 */
public class MergeSort {
    private static int[] aux = null;
    public static void main(String[] args){
        int[] array = new int[]{3, 2, 5, 7, 9, 8, 3};
        aux = new int[array.length];

        sort(array, 0, array.length - 1);

        for (int value : array){
            System.out.println(value);
        }
    }

    static void sort(int[] array, int low, int high){
        if(low < high){
            int mid = low + (high - low)/2;
            sort(array, low, mid);
            sort(array, mid+1, high);

            merge(array, low, mid, high);
        }
    }

    static void merge(int[] array, int low, int mid, int high){
        int i = low;
        int j = mid+1;

        for(int k = low; k<= high; k++){
            aux[k] = array[k];
        }

        for(int k = low; k<=high; k++){
            if(i > mid) array[k] = aux[j++];
            else if (j > high) array[k] = aux[i++];
            else if (aux[i] > aux[j]) array[k] = aux[j++];
            else array[k] = aux[i++];
        }
    }
}
