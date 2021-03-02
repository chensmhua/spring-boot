package service.thead.executor;

import java.util.concurrent.*;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.thead.executor$
 * @ClassName: CallableFuture$
 * @date ：Created in 3/1/21 8:19 PM
 * @description：callable和future
 * @modified By：
 * @version: 1.01
 */
public class CallableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> c =new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello world";
            }
        };

        //创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        //获取返回结果
        Future<String> submit = executorService.submit(c);

        //阻塞等待返回结果
        System.out.println(submit.get());

    }
}