package ai.code.mikasa.ds.algorithm;

/**
 * Excel Sheet Column Number
 */
public class ExcelSheetColumnNumber {

    public static void main(String[] args){
        ExcelSheetColumnNumber instance = new ExcelSheetColumnNumber();
        System.out.println(instance.titleToNumber("AB"));
        System.out.println(instance.titleToNumber("ZY"));
    }

    public int titleToNumber(String s) {
        char[] chs = s.toCharArray();
        int sum = 0;
        for(int i = 0; i < chs.length; i++){
            sum = (chs[i] - 'A' + 1) + sum * 26;
        }
        return sum;
    }
}
