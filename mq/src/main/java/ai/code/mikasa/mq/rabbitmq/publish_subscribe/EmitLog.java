package ai.code.mikasa.mq.rabbitmq.publish_subscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import waw.sakura.rabbitmq.MyRabbit;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * Created by lenn on 16/10/9.
 */
public class EmitLog {
    private final static String EXCHANGE_NAME = "logs";

    public static void main(String[] args){
        // 构建connection工厂
        ConnectionFactory factory = MyRabbit.getConnectionFactory();

        Connection connection = null;
        Channel channel = null;
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();
            // 创建一个fanout类型当交换器
            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

            String message = null;
            Scanner scanner = new Scanner(System.in);

            System.out.println("请输入要发送的消息(输入[!q]结束):");
            while (!(message = scanner.nextLine()).equals("!q")){
                channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
                System.out.println(" [x] Sent '" + message + "'");
                System.out.println("请输入要发送的消息:");
            }

            scanner.close();
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }finally {

        }
    }
}
