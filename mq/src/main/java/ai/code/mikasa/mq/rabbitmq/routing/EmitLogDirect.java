package ai.code.mikasa.mq.rabbitmq.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import waw.sakura.rabbitmq.MyRabbit;

import java.util.Scanner;

/**
 * Created by lenn on 16/10/10.
 */
public class EmitLogDirect {

    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] argv){

        ConnectionFactory factory = MyRabbit.getConnectionFactory();
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.exchangeDeclare(EXCHANGE_NAME, "direct");

            Scanner scanner = new Scanner(System.in);

            String routingKey = "error";
            String message = null;
            System.out.println("请输入要发送的消息(输入[!q]结束):");
            while (!(message = scanner.nextLine()).equals("!q")){
                channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
                System.out.println(" [x] Sent message:'" + message + "'");

                System.out.println("请输入要发送的消息:");
            }

            scanner.close();
            channel.close();
            connection.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
