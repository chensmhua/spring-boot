package task.thead.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead.juc$
 * @ClassName: ReentrantLockTwo$
 * @date ：Created in 2020-08-18 10:48
 * @description：可重入锁
 * @modified By：
 * @version: 1.01
 */
public class ReentrantLockTwo {

    Lock lock =  new ReentrantLock();

    void m1(){
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(i);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }

    void m2(){
        try {
            lock.lock();
            System.out.println("m2.....");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTwo reentrantLockTwo = new ReentrantLockTwo();
        new Thread(reentrantLockTwo::m1).start();

        TimeUnit.SECONDS.sleep(1);
        new Thread(reentrantLockTwo::m2).start();
    }
}