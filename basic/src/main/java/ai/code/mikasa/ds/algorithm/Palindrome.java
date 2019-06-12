package ai.code.mikasa.ds.algorithm;

/**
 * 判断是否为回文
 */
public class Palindrome {

    public static void main(String[] args){
        Palindrome instance = new Palindrome();
        System.out.println(instance.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(instance.isPalindrome("race a car"));
        System.out.println(instance.isPalindrome("0P"));
    }

    public boolean isPalindrome(String s) {
        if(s == null || s.equals("")){
            return true;
        }
        char[] chs = s.toCharArray();
        int left = 0;
        int right = chs.length - 1;
        while (left < right){
            while (left < chs.length && !isAlphanumeric(chs[left])){
                left++;
            }
            while (right > 0 && !isAlphanumeric(chs[right])){
                right--;
            }
            if(left < right
                    && Character.toLowerCase(chs[left]) != Character.toLowerCase(chs[right])){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isAlphanumeric(char ch){
        return Character.isAlphabetic(ch) || Character.isDigit(ch);
    }
}
