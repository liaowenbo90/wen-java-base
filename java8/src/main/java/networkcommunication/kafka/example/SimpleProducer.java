package networkcommunication.kafka.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * 简单生产者示例
 *
 * @author liaowb
 */
public class SimpleProducer {

    public static void main(String[] args) {
        //参数设置
        Properties props = new Properties();
        //设置访问ip 端口
        props.put("bootstrap.servers", "192.168.20.76:9092");
        //确认生产者请求
        props.put("acks", "all");
        //生产者请求失败将重复请求
        props.put("retries", 5);
        //缓冲区大小
        props.put("batch.size", 16384);
        //访问请求数
        props.put("linger.ms", 1);
        //缓冲区的缓存总量
        props.put("buffer.memory", 33554432);

        props.put("key.serializer", StringSerializer.class.getName());
        //值
        props.put("value.serializer", StringSerializer.class.getName());



//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.20.76:9092");
//        props.put(ProducerConfig.ACKS_CONFIG, "all");//等待分区的所有副本应答，才表示此消息发送成功
//        props.put(ProducerConfig.RETRIES_CONFIG, 5); // 生产者从服务器收到临时性错误时，生产者重发消息的次数
//        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);// 一批消息处理大小
//        props.put(ProducerConfig.LINGER_MS_CONFIG, 1); // 请求延时
//        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432); // 发送缓存区内存大小
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName()); // key序列化
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName()); // value序列化


        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        try {
            for (int i = 0; i < 10; i++) {
                String msg = "Message" + i;
                producer.send(new ProducerRecord("test1", msg));
                System.out.println("sent:" + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }

    }
}
