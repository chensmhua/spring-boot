package service.thead.executor;

import io.netty.util.concurrent.DefaultThreadFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.thead.executor$
 * @ClassName: ThreadRejectConsume$
 * @date ：Created in 3/2/21 7:19 PM
 * @description：拒绝策略
 * @modified By：
 * @version: 1.01
 */
@Slf4j
public class ThreadRejectConsume {

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                4, 8, 60,TimeUnit.SECONDS,  new ArrayBlockingQueue<>(6),
        Executors.defaultThreadFactory(),new MyReject());

    }


}
class MyReject implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        //策略自定义
    }
}