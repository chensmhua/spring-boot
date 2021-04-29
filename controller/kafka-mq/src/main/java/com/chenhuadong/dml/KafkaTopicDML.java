package com.chenhuadong.dml;

import org.apache.kafka.clients.admin.*;

import java.util.Arrays;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * @author ：huadong.chen
 * @ProjectName: demo$
 * @Package: com.chenhuadong.dml$
 * @ClassName: KafkaTopicDML$
 * @date ：Created in 2021/4/19 10:21
 * @description：kafka连接参数 需要本地启动zookeeper 和 kafka
 * @modified By：
 * @version: 1.01
 */
public class KafkaTopicDML {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建配置信息
        Properties properties = new Properties();
        //添加配置
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "PC-HZ20190104:9092");
        //申请连接
        AdminClient adminClient = KafkaAdminClient.create(properties);
        //异步创建topic
        CreateTopicsResult createTopicsResult = adminClient.createTopics(Arrays.asList(new NewTopic("topic04", 1, (short) 1)));
        //获取异步执行结果，可以作为同步机制
        createTopicsResult.all().get();

        ListTopicsResult listTopicsResult = adminClient.listTopics();

        Set<String> topics = listTopicsResult.names().get();

        topics.stream().forEach(c -> {
            System.out.println("kafka name-----》" + c);
        });
        //关闭连接
        adminClient.close();
    }
}
