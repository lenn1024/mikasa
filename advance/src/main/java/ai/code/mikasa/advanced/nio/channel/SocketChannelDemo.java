package ai.code.mikasa.advanced.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * Created by Lenn on 2017/6/3.
 */
public class SocketChannelDemo {
    public static void main(String[] args){
        try(SocketChannel channel = SocketChannel.open()) {
            channel.configureBlocking(false);
            channel.connect(new InetSocketAddress("localhost", 8080));

            // 注册selector
            Selector selector = Selector.open();
            channel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ | SelectionKey.OP_WRITE);

            //
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            while (true){
                for(SelectionKey selectionKey: selectionKeys){
                    if(selectionKey.isConnectable()){
                        System.out.println("111111");
                    }
                    if(selectionKey.isReadable()){
                        System.out.println("222222");
                    }
                    if(selectionKey.isWritable()){
                        System.out.println("333333");
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
