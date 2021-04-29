package com.chenhuadong.serializer;



import org.apache.commons.lang3.SerializationUtils;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Map;

/**
 * @author ：huadong.chen
 * @ProjectName: demo$
 * @Package: com.chenhuadong.serializer$
 * @ClassName: UserDefineSeriliazer$
 * @date ：Created in 2021/4/29 11:02
 * @description：自定义序列化
 * @modified By：
 * @version: 1.01
 */
public class UserDefineSerializer implements Serializer<Object> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String s, Object o) {
        return new byte[0];
    }

    @Override
    public byte[] serialize(String topic, Headers headers, Object data) {
        return SerializationUtils.serialize((Serializable) data);
    }

    @Override
    public void close() {

    }
}
