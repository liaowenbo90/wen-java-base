package networkcommunication.rabbitMQ.code;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {

    public static void main (String [] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //设置mq
        connectionFactory.setHost("192.168.20.130");
        connectionFactory.setUsername("mq");
        connectionFactory.setPassword("123456");
        connectionFactory.setPort(5672);
        //获取代理连接
        Connection connection = connectionFactory.newConnection();
        System.out.println("*****************获取mq连接成功*****************");
        //获取渠道
        Channel channel = connection.createChannel();
        //设置交换器
        String exchangeName = "amq.direct";
        channel.exchangeDeclare(exchangeName,"direct",true);

        String routingKey = "hola";
        //发布消息
        byte[] messageBodyBytes = "holleword".getBytes();
        channel.basicPublish(exchangeName, routingKey, null, messageBodyBytes);
        System.out.println("*****************发送成功*****************");

        channel.close();
        connection.close();

    }
}
