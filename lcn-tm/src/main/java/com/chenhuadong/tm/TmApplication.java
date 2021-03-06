package com.chenhuadong.tm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot$
 * @ClassName: controller.ApplicationSpringBoot$
 * @date ：Created in 2020-06-19 11:25
 * @description：
 * @modified By：启动类
 * @version: 1.01
 */

@SpringBootApplication()
@EnableTransactionManagement
public class TmApplication {
    public static void main(String[] args) {
        //程序启动
        SpringApplication.run(TmApplication.class,args);
    }
}
