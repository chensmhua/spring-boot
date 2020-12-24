package task.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: task.job$
 * @ClassName: JobService$
 * @date ：Created in 12/24/20 11:40 AM
 * @description：
 * @modified By：
 * @version: 1.01
 */
@Service
public class JobService {

    @Scheduled(cron = "0 * * * * *")
    public void test(){
        System.out.println("定时：task job running..........");
    }
}