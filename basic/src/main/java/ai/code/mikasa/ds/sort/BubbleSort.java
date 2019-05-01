package ai.code.mikasa.ds.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args){
        int[] array = new int[]{2, 1, 3, 5, 4, 6, 8, 7, 10, 9};
        bubbleSort(array);
        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }

    public static void bubbleSort(int[] array){
        if(array == null){
            throw new IllegalArgumentException("array can not be null.");
        }

        for(int i = 0; i < array.length - 1; i++){
            boolean flag = true;
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }
}
