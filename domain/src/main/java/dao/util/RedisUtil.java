package dao.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.dao.util$
 * @ClassName: RedisUtil$
 * @date ：Created in 2020-07-12 10:18
 * @description：redis工具类
 * @modified By：
 * @version: 1.01
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key,支持通配符
     *
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0) {
            redisTemplate.delete(keys);
        }
    }

    /**
     * @param keys
     * @return java.util.Set<java.io.Serializable>
     * @describe: 匹配所有的key
     * @version: v1.0
     * @date 2017/09/21 下午 6:25
     */
    public Set<Serializable> keys(final String keys) {
        Set<Serializable> keySet = redisTemplate.keys(keys);
        return keySet;
    }

    /**
     * @param keys
     * @return java.util.List<java.lang.Object>
     * @describe: 根据匹配规则得到数据，只适用于单实例，多实例慎用
     * @version: v1.0
     * @date 2017/09/21 下午 6:29
     */
    public Map<Serializable, Object> getByKeys(final String keys) {
        Set<Serializable> set = keys(keys);
        if (CollectionUtils.isEmpty(set)) {
            return null;
        }
        Map<Serializable, Object> map = new HashMap<Serializable, Object>();
        for (Serializable ser : set) {
            map.put(ser, get((String) ser));
        }
        return map;
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    //清空数据，慎用
    public synchronized void flushall() {
        if (null != redisTemplate) {
            RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();

            connection.flushDb();
            connection.flushAll();

        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();

            result = operations.get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * @param key   键
     * @param value 值
     * @return boolean
     * @describe: 写入缓存
     * @version: v1.0
     * @date 2017/7/27 15:38
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param key        键
     * @param value      值
     * @param expireTime 超时时间，秒
     * @return boolean
     * @describe: 写入缓存, key为set名称（编号），value为该set下的值，set不允许重复
     * @version: v1.0
     * @date 2018/8/20/020 14:44
     */
    public boolean addSet(final String key, final Object value, Long expireTime) {
        if (StringUtils.isEmpty(key) || null == value) {
            return false;
        }
        boolean result = false;
        try {
            SetOperations<Serializable, Object> setOperations = redisTemplate.opsForSet();
            Long longs = setOperations.add(key, value);
            //表示添加成功
            if (longs > 0) {
                redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param key        键
     * @param value      值
     * @param expireTime 超时时间，秒
     * @return boolean
     * @describe: 写入缓存
     * @version: v1.0
     * @date 2017/7/27 15:38
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setExpire(final String key, Long expireTime) {
        try {
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @describe: 获取缓存, key为set名称（编号），或者
     * @version: v1.0
     * @date 2018/8/20/020 15:03
     */
    public Object getSet(final String key) {
        Object result = null;
        try {
            SetOperations<Serializable, Object> setOperations = redisTemplate.opsForSet();
            result = setOperations.members(key);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    //在redisList里面添加一个值，添加值在左边添加，弹出的时候可以在右边弹出(先进先出)，适用于秒杀场景
    public boolean addList(final String key, final String value, Long expireTime) {

        if (StringUtils.isEmpty(key) || null == value) {
            return false;
        }
        boolean result = false;
        try {
            Long longs = redisTemplate.opsForList().rightPush(key, value);
            //表示添加成功
            if (longs > 0) {
                redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //在redisList里面弹出一个值，默认弹出的是右弹出，先进先出
    public Object rightPopList(final String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        Object object = null;
        try {
            ListOperations<Serializable, Object> listOperations = redisTemplate.opsForList();
            object = listOperations.rightPop(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    //在redisList获取长度
    public Long sizeList(final String key) {
        Long count = -1L;
        if (StringUtils.isEmpty(key)) {
            return count;
        }
        try {
            ListOperations<Serializable, Object> listOperations = redisTemplate.opsForList();
            count = listOperations.size(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }


    //在redisList获取列表
    public List getList(final String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        List list = new ArrayList();
        try {
            ListOperations<Serializable, Object> listOperations = redisTemplate.opsForList();
            list = listOperations.range(key, 0, sizeList(key));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //移除set里面的一个值
    public void removeSet(final String key, final String value) {
        if (exists(key)) {
            try {
                SetOperations<Serializable, Object> setOperations = redisTemplate.opsForSet();
                setOperations.remove(key, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    //获取剩余时间
    public Long getTime(String key) {
        if (StringUtils.isEmpty(key)) {
            return (long) -1;
        }
        Long time = redisTemplate.getExpire(key);
        return time;
    }

    //获得分布式锁
    public boolean getLock(final String lockName, Long lockTime) {
        //得到锁，暂时不做等待处理
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        boolean isok = connection.setNX(lockName.getBytes(), lockName.getBytes());
        if (isok) {
            connection.expire(lockName.getBytes(), lockTime);
        }
        return isok;
    }

    //解锁
    public void unLock(String lockName) {
        if (StringUtils.isEmpty(lockName)) {
            return;
        }
        redisTemplate.getConnectionFactory().getConnection().del(lockName.getBytes());

    }

    /**
     * 根据hash key取值
     *
     * @param hashName
     * @param key
     * @return
     */
    public Object hget(String hashName, String key) {
        Object object = null;
        try {
            object = redisTemplate.opsForHash().get(hashName, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 判断key是否存在
     *
     * @param hashName
     * @param key
     * @return
     */
    public Boolean hexists(String hashName, String key) {
        Boolean flag = false;
        try {
            flag = redisTemplate.opsForHash().hasKey(hashName, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}