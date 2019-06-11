package networkcommunication.rabbitMQ.code;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.20.130");
        connectionFactory.setUsername("mq");
        connectionFactory.setPassword("123456");
        connectionFactory.setPort(5672);
        //获取连接
        Connection connection = connectionFactory.newConnection();
        System.out.println("*****************获取mq连接成功*****************");
        //获得通道
        Channel channel = connection.createChannel();
        //声明交换器
        String exchangName = "amq.direct";
        //声明队列
        String queue = channel.queueDeclare().getQueue();
        //声明路由键
        String routingKey = "hola";
        //绑定队列 通过路由键 绑定 队列和交换器
        channel.queueBind(queue, exchangName, routingKey);
        System.out.println("*****************绑定成功*****************");
//        while (true) {
        //消费消息
        System.out.println("*****************开始消费消息*****************");
            boolean autoAck = false;
            String comsumerTag = "";

        //DefaultConsumer类实现了Consumer接口，通过传入一个频道，
        // 告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("Customer Received '" + message + "'");
            }
        };

        //自动回复队列应答 -- RabbitMQ中的消息确认机制
        channel.basicConsume(queue, true, consumer);

//            channel.basicConsume(queue, autoAck, comsumerTag, new DefaultConsumer(channel) {
//                @Override
//                public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
//                    String exchange = envelope.getExchange();
//                    String routingKey1 = envelope.getRoutingKey();
//                    long deliveryTag = envelope.getDeliveryTag();
//                    System.out.println("exchange:" + exchange + "routingKey1:" + routingKey1 + ",deliverTag:" + deliveryTag);
//                    //消息确认
//                    channel.basicAck(deliveryTag,false);
//                    //消息内容
//                    String bodyStr = new String(bytes, "UTF-8");
//                    System.out.println("消息内容：" + bodyStr);
//                    System.out.println("*****************结束消费消息*****************");
//                }
//
//            });


//        boolean autoAck = false;
//        channel.basicConsume(queue, autoAck, "myConsumerTag",
//                new DefaultConsumer(channel) {
//                    @Override
//                    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
//                            throws IOException {
//                        String routingKey = envelope.getRoutingKey();
//                        String contentType = properties.getContentType();
//                        long deliveryTag = envelope.getDeliveryTag();
//                        // (process the message components here ...)
//                        channel.basicAck(deliveryTag, false);
//                        //消息内容
//                        String bodyStr = new String(body, "UTF-8");
//                        System.out.println("消息内容：" + bodyStr);
//                        System.out.println("*****************结束消费消息*****************");
//                    }
//                });


//        }
    }
}
