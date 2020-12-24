package task.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: task.email$
 * @ClassName: EmailService$
 * @date ：Created in 12/24/20 2:47 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
@Service
public class EmailService {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public void send(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("测试发邮件");
        simpleMailMessage.setText("测试发油腻");
        simpleMailMessage.setFrom("1135031422@qq.com");
        simpleMailMessage.setTo("1178511272@qq.com");
        javaMailSender.send(simpleMailMessage);
    }
}