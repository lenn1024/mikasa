package ai.code.mikasa.ds.algorithm;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 将一个正整数删掉K位，使其最大或最小
 * K不能大于num的位数
 */
public class DelK {

    public static void main(String[] args){
        DelK instance = new DelK();
        System.out.println(instance.minByDelK(92345, 3));
        System.out.println(instance.maxByDelK(92345, 3));
    }

    /**
     * 删除k个数使整数最大
     * @param num
     * @param k
     * @return
     */
    public int maxByDelK(int num, int k){
        List<Integer> digits = getDigits(num);
        if(k > digits.size()){
            throw new IllegalArgumentException("不合法的入参。");
        }

        // 贪心删除位数高的数字
        for(int i = 0; i < k; i++){
            int j = 0;
            for(; j < digits.size() - 1; j++){
                if(digits.get(j) < digits.get(j + 1)){
                    break;
                }
            }
            digits.remove(j);
        }

        return digits2num(digits);
    }

    public int minByDelK(int num, int k){
        List<Integer> digits = getDigits(num);
        if(k > digits.size()){
            throw new IllegalArgumentException("不合法的入参。");
        }

        // 贪心删除位数高的数字
        for(int i = 0; i < k; i++){
            int j = 0;
            for(; j < digits.size() - 1; j++){
                if(digits.get(j) > digits.get(j + 1)){
                    break;
                }
            }
            digits.remove(j);
        }

        return digits2num(digits);
    }


    private int digits2num(List<Integer> digits){
        if(digits.size() == 0){
            return 0;
        }

        int num = 0;
        for(int i = 0; i < digits.size(); i++){
            num = num * 10 + digits.get(i);
        }

        return num;
    }

    private List<Integer> getDigits(int num){
        List<Integer> list = new ArrayList<>();
        while (num != 0){
            list.add(num % 10);
            num /= 10;
        }
        Collections.reverse(list);
        return list;
    }

}
