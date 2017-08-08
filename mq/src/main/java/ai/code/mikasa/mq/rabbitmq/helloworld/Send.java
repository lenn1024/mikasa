package ai.code.mikasa.mq.rabbitmq.helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import waw.sakura.rabbitmq.MyRabbit;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by lenn on 16/10/9.
 */
public class Send {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args){
        // 构建connection工厂
        ConnectionFactory factory = MyRabbit.getConnectionFactory();

        Connection connection = null;
        Channel channel = null;
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();

            // create queue
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

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
