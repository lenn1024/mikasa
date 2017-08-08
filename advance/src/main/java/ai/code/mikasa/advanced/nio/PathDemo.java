package ai.code.mikasa.advanced.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by lenn on 17/5/5.
 * Path 表示的是一个目录名序列.
 */
public class PathDemo {
    public static void main(String[] args){
        /**
         * 1. 创建绝对路径和相对路径
         */
        Path absolute = Paths.get("/home", "op");
        Path relative = Paths.get("home", "op");

//        System.out.println(relative.getFileName());

        // 2. 组合或解析路径
        /**
         * resolveSibling
         * relativize
         * normalize
         * toAbsolutepath
         */
        Path basePath = Paths.get("/home");
        Path workPath = basePath.resolve(Paths.get("work"));
        // or
        Path workPath1 = basePath.resolve("work");


        // System.out.println(path.toString());
    }
}
