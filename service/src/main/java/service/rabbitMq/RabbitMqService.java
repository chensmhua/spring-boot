package service.rabbitMq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.rabbitMq$
 * @ClassName: RabbitMqService$
 * @date ：Created in 12/14/20 8:19 PM
 * @description：消息中间件
 * @modified By：
 * @version: 1.01
 */
@Service
public class RabbitMqService {

    /**
     * 消息接收
     */
    @RabbitListener(queues = "chenhuadong.test")
    public void receive(String msg){
        System.out.println(msg);
    }
}