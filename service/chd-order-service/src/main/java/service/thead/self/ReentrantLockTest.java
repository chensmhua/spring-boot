package service.thead.self;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead$
 * @ClassName: ReentrantLockTest$
 * @date ：Created in 2020-08-13 19:39
 * @description：可重入锁
 * @modified By：
 * @version: 1.01
 */
public class ReentrantLockTest   {

     Lock lock =  new ReentrantLock();


     void lockOne(){
         try{
             lock.lock();
             for (int i = 0; i < 1000; i++) {
                 TimeUnit.SECONDS.sleep(1);
             }
         }catch (Exception e){
             e.printStackTrace();
         }finally {
             //sycn自动释放lock
             lock.unlock();
         }
     }

    public static void main(String[] args) {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        new Thread(reentrantLockTest::lockOne).start();
    }

}