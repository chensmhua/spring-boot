package task.thead.self;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead$
 * @ClassName: ThreadPool$
 * @date ：Created in 2020-07-14 20:05
 * @description：线程池
 * @modified By：
 * @version: 1.01
 */
public class ThreadPool implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName()+":::"+i);
        }
    }
}