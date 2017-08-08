package ai.code.mikasa.mq.rabbitmq.workqueues;

import com.rabbitmq.client.*;
import waw.sakura.rabbitmq.MyRabbit;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by lenn on 16/10/9.
 */
public class Worker {
    private final static String QUEUE_NAME = "work-queue";

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

                    try {
                        doWork(message);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println(" [x] Done");
                    }
                }
            };

            /**
             * 如果autoAck设置为false, 则consumer会在处理消息成功后向rabbitmq发送一个确认消息,
             * 如果consumer处理消息失败了, 则rabbitmq会重新deliver这条消息到另一个consumer
             */
            boolean autoAck = true;
            channel.basicConsume(QUEUE_NAME, autoAck, consumer);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    private static void doWork(String task) throws InterruptedException {
        for (char ch: task.toCharArray()) {
            if (ch == '.') Thread.sleep(1000);
        }
    }
}
