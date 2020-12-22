package controller.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: controller.config$
 * @ClassName: RabbitMqConfig$
 * @date ：Created in 12/2/20 4:37 PM
 * @description：配置
 * @modified By：
 * @version: 1.01
 */
@Configuration
public class RabbitMqConfig {

    /**
     * 更改mq传输序列规则
     * @return
     */
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}