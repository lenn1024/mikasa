package ai.code.mikasa.advanced.nio.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Lenn on 2017/6/3.
 */
public class FileChannelDemo {
    public static void main(String[] args){
        //
        writeToFileChannel();
    }

    /**
     * 从FileChannel中读取数据
     */
    public static void readFromFileChannel(){
        FileChannel channel = null;
        try {
            RandomAccessFile file = new RandomAccessFile("data/nio.txt", "rw");
            /**
             *    无法直接打开一个FileChannel，需要通过使用一个InputStream、
             *    OutputStream或RandomAccessFile来获取一个FileChannel实例
             */
            channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(24);

            int readBytes = channel.read(buffer);

            String str = new String(buffer.array(), "utf8") ;
            System.out.println("读了" + readBytes + "个字节。");
            System.out.println(str);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeToFileChannel(){
        try(FileChannel channel = new RandomAccessFile("data/nio/FileChannel.txt", "rw").getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(50);
            buffer.put("我是牛逼的大管哥.".getBytes());
            //  翻转缓冲区
            buffer.flip();
            channel.write(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
