package com.chenhuadong.serializer;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

/**
 * @author ：huadong.chen
 * @ProjectName: demo$
 * @Package: com.chenhuadong.serializer$
 * @ClassName: UserDefineDeseralizer$
 * @date ：Created in 2021/4/29 11:07
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class UserDefineDeserializer implements Deserializer<Object> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public Object deserialize(String s, byte[] bytes) {
        return null;
    }

    @Override
    public Object deserialize(String topic, Headers headers, byte[] data) {
        return SerializationUtils.deserialize(data);
    }

    @Override
    public void close() {

    }
}
