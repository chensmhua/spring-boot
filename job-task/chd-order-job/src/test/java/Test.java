import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import task.JobApplication;
import task.email.EmailService;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: PACKAGE_NAME$
 * @ClassName: Test$
 * @date ：Created in 12/24/20 3:01 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = JobApplication.class)
public class Test {

    @Autowired
    private EmailService emailService;

    @org.junit.Test
    public void send(){
        emailService.send();
    }
}