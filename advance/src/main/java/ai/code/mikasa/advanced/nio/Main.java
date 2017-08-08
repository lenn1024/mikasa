package ai.code.mikasa.advanced.nio;

/**
 * Created by lenn on 16/6/8.
 */

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 *  标准的IO基于字节流和字符流进行操作的,而NIO是基于通道(Channel)和缓冲区(Buffer)进行操作的.
 *  数据总是从通道读取到缓冲区,或者从缓冲区写入到通道中.
 *  java NIO 核心组成部分: Channels, Buffers, Selectors
 *
 *  1. Channel
 *
 *    既可以从通道中读取数据，又可以写数据到通道。但流的读写通常是单向的。
 *    通道可以异步地读写。
 *    通道中的数据总是要先读到一个Buffer，或者总是要从一个Buffer中写入。
 *
 *  2. Buffer
 *    缓冲区本质上是一块可以写入数据,然后可以从中读取数据的内存.
 *    这块内存被包装成NIO Buffer对象,并提供一组方法,用来方便的访问该块内存
 *
 *    写入buffer一般遵循以下四个步骤:
 *    1. 写入数据到buffer
 *    2. 调用flip()方法
 *    3. 从Buffer中读取数据
 *    4. 调用clear()方法或者compact()方法
 *
 *    当向buffer写入数据时，buffer会记录下写了多少数据。一旦要读取数据，需要通过flip()方法将Buffer从写模式切换到读模式。
 *    在读模式下，可以读取之前写入到buffer的所有数据。
 *
 *    一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入。有两种方式能清空缓冲区：调用clear()或compact()方法。
 *    clear()方法会清空整个缓冲区。
 *    compact()方法只会清除已经读过的数据。
 *    任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。
 *
 *    Buffer有三个属性: capacity, position, limit
 *
 *    position和limit的含义取决于Buffer处在读模式还是写模式.不管读模式还是写模式,capacity的含义总是一样的.
 *
 *    从Buffer中读数据:
 *
 *      1. 从Buffer读取数据到Channel。
 *      2. 使用get()方法从Buffer中读取数据。
 *
 *    rewind()方法
 *      Buffer.rewind将position设回0,所以你可以重读Buffer中的所有数据.limit保持不变.
 *
 *    3. Scatter/Gather
 *         scatter(分散): 从Channel中读取的数据写入到多个buffer中.
 *         gather(聚集): 写入Channel
 *
 *
 */
public class Main {

    public static void main(String[] args) {
//        Runnable r1 =()->{System.out.println("dfds");};
//
//        List<String> l = new ArrayList<>();

//        CharBuffer charBuffer = CharBuffer.allocate(1);
//        charBuffer.put('好');
//        // flip方法将Buffer从写模式切换到读模式。(buffer好像默认为写模式)
//        charBuffer.flip();
//
//        System.out.println(charBuffer.get());

        try {
            channelDemo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 1. channel
    public static void channelDemo() throws IOException{
        RandomAccessFile aFile = new RandomAccessFile("data/nio.txt", "rw");
        FileChannel channel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(20);

        int byteRead = channel.read(buf);
        while (byteRead != -1){
            // System.out.println(byteRead);
            buf.flip();

            while (buf.hasRemaining()){
                System.out.println((char)buf.get());
            }

            buf.clear();
            byteRead = channel.read(buf);
        }

        aFile.close();
    }
}
