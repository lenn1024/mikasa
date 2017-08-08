package ai.code.mikasa.advanced.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * Created by Lenn on 2017/6/3.
 */
public class SelectorDemo {
    public static void main(String[] args){
        try {
            // FileChannel不能配置为阻塞状态，所以不能与Selector一起使用
            //            RandomAccessFile randomAccessFile = new RandomAccessFile("data/nio.txt", "rw");
            //            FileChannel channel = randomAccessFile.getChannel();

            // 套接字通道
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress(8080));

            ssc.configureBlocking(false);
            Selector selector = Selector.open();
            // 定义感兴趣的集合
            int interestSet = SelectionKey.OP_CONNECT;
            SelectionKey selectionKey = ssc.register(selector, SelectionKey.OP_ACCEPT);

            while (true){
                int  readyChannels = selector.select();
                if(readyChannels == 0) continue;

                if(selectionKey.isConnectable()){
                    System.out.println("connectable.");
                }

                if(selectionKey.isAcceptable()){
                    System.out.println("acceptable.");
                }

                if(selectionKey.isReadable()){
                    System.out.println("readable.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }
    }
}
