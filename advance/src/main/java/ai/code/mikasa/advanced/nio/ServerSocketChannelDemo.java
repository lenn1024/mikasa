package ai.code.mikasa.advanced.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

/**
 * Created by lenn on 17/1/11.
 */
public class ServerSocketChannelDemo {
    private static int timeOut = 3000;

    public static void main(String[] args) throws IOException {
        // 创建selector
        Selector selector = Selector.open();

        // 创建serverSocketChannel
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(8080));
        // 设置为非阻塞
        ssc.configureBlocking(false);
        // 注册selector
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        while(true){
            if(selector.select(timeOut) == 0){
                // System.out.println("waiting...");
                continue;
            }

            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()){
                SelectionKey key = it.next();
                if (key.isAcceptable()){
                    System.out.println("accepted.");
                }
            }
        }
    }
}
