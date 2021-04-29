package com.chenhuadong.interceptors;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @author ：huadong.chen
 * @ProjectName: demo$
 * @Package: com.chenhuadong.interceptors$
 * @ClassName: UserDefineInterceptor$
 * @date ：Created in 2021/4/29 11:10
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class UserProducerDefineInterceptor implements ProducerInterceptor {
    @Override
    public ProducerRecord onSend(ProducerRecord producerRecord) {
        return new ProducerRecord(producerRecord.topic(),producerRecord.key(),producerRecord.value()+"---producer ");
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception e) {
        boolean b = recordMetadata.hasOffset();
        System.out.println("offset:"+b);
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }
}
