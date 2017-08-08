package ai.code.mikasa.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lenn on 16/9/27.
 */

/**
 *  1. 正则表达式定义了字符串的模式。
    2. 正则表达式可以用来搜索、编辑或处理文本。
    3. 正则表达式并不仅限于某一种语言，但是在每种语言中有细微的差别。
 */
public class RegexDemo {
    public static void main(String[] args){
        demo3();

    }

    // 1. 直接判断某个字符串整体是否符合正则表达式
    private static void demo1(){
        Boolean isMatch = Pattern.matches("\\d+", "123");
    }

    // 2. 通过Matcher引擎判断字符串整体是否复合正则表达式
    private static void demo2(){
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher("123");
        Boolean isMatch = matcher.matches();
    }

    // 3. 查找模式字符串
    private static void demo3(){
        Pattern pattern = Pattern.compile("(\\d+(\\d+))");
        Matcher matcher = pattern.matcher("abcd111abcd222abcd333abcd666abcd");

        while (matcher.find()) {
            System.out.println("++++++++++++++++++");
            int groupCount = matcher.groupCount();
            for (int i = 1; i <= groupCount; i++) {
                System.out.println(matcher.group(i));
            }
        }
    }
}
