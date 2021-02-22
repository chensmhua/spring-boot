package service.thead.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead.juc$
 * @ClassName: LockReentrant$
 * @date ：Created in 2020-08-17 10:46
 * @description：可重入锁测试
 * 一个同步方法可以调用另外一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁.
 * 结论：事实证明锁是可重入的
 * @modified By：
 * @version: 1.01
 */
public class LockReentrant {

    //定义两个锁

    public synchronized void methodOne() throws InterruptedException {
        System.out.println("methodOne Start!");
        TimeUnit.SECONDS.sleep(1);
        //调用另外一个方法
        methodTwo();
        System.out.println("methodOne end!");

    }

    public synchronized void methodTwo() throws InterruptedException {
        System.out.println("methodTwo start!");
        TimeUnit.SECONDS.sleep(1);
    }

    public static void main(String[] args) throws InterruptedException {
        LockReentrant lockReentrant = new LockReentrant();
        lockReentrant.methodOne();
    }
}