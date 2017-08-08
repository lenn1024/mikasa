package ai.code.mikasa.advanced.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/**
 * Created by lenn on 17/5/5.
 */
public class FilesDemo {
    public static void main(String[] args){
        try {
            Path logPath = Paths.get("/Users/lenn/log", "log.log");
            Path testPath = Paths.get("/Users/lenn/log", "test.log");
            // 1. 读取所有文件的所有内容
            byte[] bytes = Files.readAllBytes(logPath);
            System.out.println(bytes);

            // 2. 将文件当作行序列读入
            List<String> lines = Files.readAllLines(logPath);
            lines.stream()
                    .forEach(line -> System.out.println(line));

            // 3 写出一个字符串到文件
            Files.write(testPath, "南无阿弥陀佛".getBytes());

            // 4 追加内容到文件
            Files.write(testPath, "妈咪妈咪哄".getBytes(), StandardOpenOption.APPEND);

            // 5 复制 移动 删除
            Path toPath = testPath.resolveSibling("copy.log");
            Files.copy(testPath, toPath, StandardCopyOption.REPLACE_EXISTING);
            Files.move(toPath, toPath.resolveSibling("move.log"));
            Files.delete(testPath.resolveSibling("move.log"));
            Files.deleteIfExists(testPath.resolveSibling("move.log"));

            // 6 创建文件和目录
            Files.createDirectories(logPath.resolveSibling("test_dir"));
            //Files.createFile(logPath.resolveSibling("create_file"), StandardOpenOption);

            // 7 获取文件信息
            /**
             * exists
             * isHidden
             * isReadable isWritable isExecutable
             * isRegularFile isDirectory isSymbolicLink
             */
            // 读取文件属性
            Files.readAttributes(logPath, BasicFileAttributes.class);

            // 8 迭代目录中的文件
            try(DirectoryStream<Path> entries = Files.newDirectoryStream(logPath.getParent())){
                entries.forEach(entry -> System.out.println(entry.toString()));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
