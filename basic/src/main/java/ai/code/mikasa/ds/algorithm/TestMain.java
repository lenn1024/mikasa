package ai.code.mikasa.ds.algorithm;


import java.util.HashMap;
import java.util.Map;

public class TestMain {

    public static void main(String[] args){
        TestMain instance = new TestMain();
        System.out.println(instance.isIsomorphic("egg", "add"));
        System.out.println(instance.isIsomorphic("paper", "title"));
        System.out.println(instance.isIsomorphic("foo", "bar"));

    }

    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null){
            return true;
        } else if(s != null && t == null){
            return false;
        }else if(s == null && t != null){
            return false;
        }else if(s.length() != t.length()){
            return false;
        }

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();

        for(int i = 0; i < ch1.length; i++){
            if(map1.containsKey(ch1[i])){
                if(!map1.get(ch1[i]).equals(ch2[i])){
                    return false;
                }
            }else if(map2.containsKey(ch2[i])){
                return false;
            }else {
                map1.put(ch1[i], ch2[i]);
                map2.put(ch2[i], ch1[i]);
            }
        }

        return true;
    }
}
