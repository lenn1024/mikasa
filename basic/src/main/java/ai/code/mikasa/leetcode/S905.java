package ai.code.mikasa.leetcode;

public class S905 {

    public static void main(String[] args){
        S905 instance = new S905();
        int[] A = instance.sortArrayByParity(new int[]{1, 2, 3, 4});
        System.out.println(A);
        System.out.println(A);
        System.out.println(A);
        System.out.println(A);
    }

    public int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left < right){
            while (left < right && A[left] % 2 == 0){
                left++;
            }

            while (right > left && A[right] % 2 != 0){
                right--;
            }
            // 交换left 和 right值
            if(left != right){
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
            }
        }

        return A;
    }
}
