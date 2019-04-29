package ai.code.mikasa.net;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    private static final String host = "127.0.0.1";
    private static final int serverPort = 9000;
    private static final int backLog = 1;

    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(serverPort, backLog, InetAddress.getByName(host));

            Socket socket = serverSocket.accept();

            BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = bis.read(buffer)) != -1){
                System.out.println("read byte nums:" + len);
                String content = new String(buffer, 0, len);
                System.out.println(content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
