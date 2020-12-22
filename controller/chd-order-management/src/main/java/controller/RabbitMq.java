package controller;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: controller$
 * @ClassName: RabbitMq$
 * @date ：Created in 12/14/20 8:27 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
@Service
public class RabbitMq {

    /**
     * 消息接收
     */
    @RabbitListener(queues = "chenhuadong.test")
    public void receive(String msg){
        System.out.println(msg);
    }
}