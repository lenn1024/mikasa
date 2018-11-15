package ai.code.mikasa.leetcode;

import java.util.HashMap;
import java.util.Map;

public class S745 {

    public static void main(String[] args){
        WordFilterV1 wordFilter = new WordFilterV1(new String[]{"abbbababbb","baaabbabbb","abababbaaa","abbbbbbbba","bbbaabbbaa","ababbaabaa","baaaaabbbb","babbabbabb","ababaababb","bbabbababa"});
        int index = wordFilter.f("babbab", "");
//        index = wordFilter.f("b", "");
    }

    /**
     * 执行时间过长
     */
    static class WordFilter {

        private String[] words;

        public WordFilter(String[] words) {
            this.words = words;
        }

        public int f(String prefix, String suffix) {
            for(int i = words.length - 1; i >= 0; i--){
                int length = words[i].length();
                int prefixLength = prefix.length();
                int suffixLength = suffix.length();

                // 子串长度大于搜索串长度
                if(length < prefixLength || length < suffixLength){
                    return -1;
                }

                // 前缀匹配
                boolean prefixHit = true;
                boolean suffixHit = true;

                for(int j = 0; j < prefixLength; j++){
                    if(words[i].charAt(j) != prefix.charAt(j)){
                        prefixHit = false;
                        break;
                    }
                }

                if(prefixHit){
                    for(int k = 0; k < suffixLength; k++){
                        if(words[i].charAt(length - k - 1) != suffix.charAt(suffixLength - k -1)){
                            suffixHit = false;
                            break;
                        }
                    }
                }
                if(prefixHit && suffixHit){
                    return i;
                }
            }

            return -1;
        }
    }

    static class WordFilterV1{
        private String[] words;
        private Map<String, Integer> map = new HashMap<>();

        public WordFilterV1(String[] words) {
            int index = 0;
            for(String word: words){
                int len = word.length();
                for(int i = 0; i <= len; i++){
                    for(int j = 0; j <= len; j++){
                        String prefix = word.substring(0, i);
                        String suffix = word.substring(len - j, len);
                        String key = prefix + "#" + suffix;
                        map.put(key, index);
                    }
                }
                index++;
            }
        }

        public int f(String prefix, String suffix) {
            Integer index = map.get(prefix + "#" + suffix);
            if(index != null){
                return index;
            }

            return -1;
        }
    }
}
