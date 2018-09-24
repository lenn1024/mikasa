package leetcode;


import java.util.HashSet;
import java.util.Set;

public class S771 {
    public int numJewelsInStones(String J, String S) {
        if("".equals(J) || "".equals(S)){
            return 0;
        }

        int num = 0;
        Set<Character> jset = new HashSet<>();
        for(int i = 0; i < J.length(); i++){
            jset.add(J.charAt(i));
        }

        for(int i = 0; i < S.length(); i++){
            if(jset.contains(S.charAt(i))){
                num++;
            }
        }

        return num;
    }
}
