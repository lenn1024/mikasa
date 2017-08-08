package ai.code.mikasa.mq.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by lenn on 16/10/9.
 */

/**
 *
 */
public class MyRabbit {

    public final static String HOST = "10.1.1.55";
    public final static String USERNAME = "rabbitmq";
    public final static String PASSWORD = "rabbitmq";

    /**
     * create connection factory
     * @return
     */
    public static ConnectionFactory getConnectionFactory(){
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setUsername(USERNAME);
        factory.setPassword(PASSWORD);
        return factory;
    }
}
