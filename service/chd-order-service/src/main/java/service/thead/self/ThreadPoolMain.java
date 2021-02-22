package service.thead.self;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead$
 * @ClassName: ThreadPoolMain$
 * @date ：Created in 2020-07-14 20:06
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class ThreadPoolMain {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(new ThreadPool());
        executorService.execute(new ThreadPool());
        executorService.execute(new ThreadPool());

    }
}