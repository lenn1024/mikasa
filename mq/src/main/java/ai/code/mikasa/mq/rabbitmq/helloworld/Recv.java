package ai.code.mikasa.mq.rabbitmq.helloworld;

import com.rabbitmq.client.*;
import waw.sakura.rabbitmq.MyRabbit;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by lenn on 16/10/9.
 */
public class Recv {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) {

        ConnectionFactory factory = MyRabbit.getConnectionFactory();
        Connection connection = null;
        Channel channel = null;
        try {
            connection = factory.newConnection();
            channel = connection.createChannel();

            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                        throws IOException {
                    String message = new String(body, "UTF-8");
                    System.out.println(" [x] Received '" + message + "'");
                }
            };
            channel.basicConsume(QUEUE_NAME, true, consumer);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
