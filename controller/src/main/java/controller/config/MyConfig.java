package controller.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.controller.config$
 * @ClassName: MyConfig$
 * @date ：Created in 2020-07-26 21:52
 * @description：
 * @modified By：
 * @version: 1.01
 */
@Configuration
public class MyConfig {

    @Bean
    public MyBeanService myBeanService(){
        System.out.println("已经注入service");
        return null;
    }
}