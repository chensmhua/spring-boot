package task.thead.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead.juc$
 * @ClassName: ReentrantLockOne$
 * @date ：Created in 2020-08-17 15:05
 * @description：juc可重入锁
 * 结论：同步锁方法可以调用非同步锁方法
 * @modified By：
 * @version: 1.01
 */
public class ReentrantLockOne {

    Lock lock =  new ReentrantLock();

    //定义一个方法调用另外一个非锁方法
    synchronized void m()  {
        for (int i = 0; i < 10000; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(i);
            if (i==12){
                m2();
            }
        }
    }

    void m2(){
        System.out.println("m2  start....");
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockOne reentrantLockOne = new ReentrantLockOne();
        Thread thread = new Thread(reentrantLockOne::m);
        thread.start();
        TimeUnit.SECONDS.sleep(1);
    }
}