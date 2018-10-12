package leetcode;

public class S745 {

    public static void main(String[] args){
        WordFilter wordFilter = new WordFilter(new String[]{"abbbababbb","baaabbabbb","abababbaaa","abbbbbbbba","bbbaabbbaa","ababbaabaa","baaaaabbbb","babbabbabb","ababaababb","bbabbababa"});
        int index = wordFilter.f("babbab", "");
//        index = wordFilter.f("b", "");
    }

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

                for(int j = 0; j < prefixLength; j++){
                    if(words[i].charAt(j) != prefix.charAt(j)){
                        return -1;
                    }
                }

                for(int k = 0; k < suffixLength; k++){
                    if(words[i].charAt(length - k - 1) != suffix.charAt(suffixLength - k -1)){
                        return -1;
                    }
                }
                return i;
            }

            return -1;
        }
    }
}
