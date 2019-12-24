package networkcommunication.kafka.example;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.Properties;

public class SimpleConsumer {

    public static void main(String[] args) {

        Properties props = new Properties();

        props.put("bootstrap.servers", "192.168.20.76:9092");
        //设置加入分组  Consumer分组ID
        props.put("group.id", "group.id-1");

        props.put("enable.auto.commit", "true");

        props.put("auto.commit.interval.ms", "1000");

        props.put("auto.offset.reset", "earliest");
        //设置会话超时时间
        props.put("session.timeout.ms", "30000");
        //反序列化为指定的类型
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.20.76:9092");
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-consumer-group");
//        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true); // 是否自动确认offset
//        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 1000); // 自动确认offset的时间间隔
////        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 30000);
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());


        KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer(props);
        //订阅主题
        kafkaConsumer.subscribe(Arrays.asList("test2"));

        while (true) {
            //Consumer调用poll方法来轮循Kafka集群的消息
            ConsumerRecords<String, String> records = kafkaConsumer.poll(100);

            for (ConsumerRecord<String, String> record : records) {

                System.out.println("offset = %d ,value = %c" + record.offset() + record.value());
            }

        }

    }


}
