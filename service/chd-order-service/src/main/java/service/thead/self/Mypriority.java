package service.thead.self;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead$
 * @ClassName: Mypriority$
 * @date ：Created in 2020-07-14 15:27
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class Mypriority implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"优先级："+Thread.currentThread().getPriority());
    }
}