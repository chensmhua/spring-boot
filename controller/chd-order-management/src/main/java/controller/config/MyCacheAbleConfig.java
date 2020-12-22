package controller.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: controller.config$
 * @ClassName: MyCacheableConfig$
 * @date ：Created in 11/23/20 2:26 PM
 * @description：缓存生成key
 * @modified By：
 * @version: 1.01
 */
@Configuration
public class MyCacheAbleConfig {


    /**
     * 自定义生成缓存key
     *
     * @return
     */
    @Bean("myKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                //返回格式为方法名+参数
                return method.getName() + "{" + Arrays.asList(objects) + "}";
            }
        };
    }
}