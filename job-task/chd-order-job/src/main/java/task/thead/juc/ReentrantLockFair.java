package task.thead.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead.juc$
 * @ClassName: ReentrantLockFair$
 * @date ：Created in 2020-08-18 14:38
 * @description：公平锁
 * @modified By：
 * @version: 1.01
 */
public class ReentrantLockFair extends Thread {

    Lock lock = new ReentrantLock(true);


    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            try {
                lock.lock();
                System.out.println(i+"获取锁");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }


    public static void main(String[] args) {
        //开启两个线程获取锁
        ReentrantLockFair reentrantLockFair1 = new ReentrantLockFair();
        ReentrantLockFair reentrantLockFair2 = new ReentrantLockFair();
        reentrantLockFair1.start();
        reentrantLockFair2.start();
    }

}