package ai.code.mikasa.leetcode;

import java.util.HashSet;
import java.util.Set;

public class S929 {
    public static void main(String[] args){
        S929 instance = new S929();
        instance.numUniqueEmails(new String[]{"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"});
    }


    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();

        for(String email: emails){
            boolean ignore = false;
            int len = email.length();
            int index = 0;
            StringBuilder emailBuilder = new StringBuilder();
            for(int i = 0; i < len; i++){
                char ch = email.charAt(i);
                if('@' == ch){
                    // 找到@的index值
                    index = i;
                    break;
                }else if(ignore || '.' == ch){
                    continue;
                }else if('+' == ch){
                    ignore = true;
                }else {
                    emailBuilder.append(ch);
                }
            }

            emailSet.add(emailBuilder.append(email.substring(index)).toString());
        }

        return emailSet.size();
    }
}
