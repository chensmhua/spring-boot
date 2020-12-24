package task;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


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

@ComponentScan({"task","dao"})
@EnableJpaRepositories("dao.repository")
@MapperScan("dao.mapper")
@EntityScan("dao.entity")
@SpringBootApplication()
@EnableScheduling()
public class JobApplication {
    public static void main(String[] args) {
        //程序启动
        SpringApplication.run(JobApplication.class,args);
    }
}
