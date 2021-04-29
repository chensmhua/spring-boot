package com.chenhuadong.quickstart;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.util.CollectionUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Properties;

/**
 * @author ：huadong.chen
 * @ProjectName: demo$
 * @Package: com.chenhuadong.quickstart$
 * @ClassName: KafkaQuickStart$
 * @date ：Created in 2021/4/19 10:55
 * @description：kafka quick
 * @modified By：
 * @version: 1.01
 */
public class KafkaQuickStart {

    public static void main(String[] args) {
        //1 create kafkaConsumer
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"PC-HZ20190104:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class.getName());

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        TopicPartition partition = new TopicPartition("topic03", 1);

        consumer.assign(Arrays.asList(partition));

        //指定分区消费数据
        consumer.seek(new TopicPartition("topic03",1),1);

        //遍历消费消息
        while (true){
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofSeconds(1));
            if (!consumerRecords.isEmpty()){
                Iterator<ConsumerRecord<String, String>> iterator = consumerRecords.iterator();
                while (iterator.hasNext()){
                    //获取第一个消息进行消费
                    ConsumerRecord<String, String> next = iterator.next();

                    String topic = next.topic();
                    int partition1 = next.partition();
                    long offset = next.offset();

                    String key = next.key();
                    String value = next.value();
                    long timestamp = next.timestamp();

                    System.out.println(topic+"=="+partition1+"=="+offset+"=="+key+"=="+value+"=="+timestamp);
                }
            }
        }


    }
}
