package service.thead.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead.juc$
 * @ClassName: LockException$
 * @date ：Created in 2020-08-17 11:04
 * @description：锁出现异常的处理
 * 结论：当两个线程共同访问一个资源时，第一个线程出现异常，会主动释放锁，那么第二个线程会在第一个线程执行过程中开始获取锁并执行
 *      如果必须要求第一个线程执行完才执行第二个线程，可以加上catch捕获异常不让他释放锁
 * @modified By：
 * @version: 1.01
 */
public class LockException {

    int count;

    public synchronized void methodOne(String name) throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"开始！");
        while (true){
            count++;
            System.out.println(Thread.currentThread().getName()+"："+count);
            TimeUnit.SECONDS.sleep(1);
            //主动抛出异常
            if (count == 5){
                //此处抛出异常，锁将被释放，要想不被释放，可以在这里进行catch，然后让循环继续
                int i = 0;
                int result = count/i;
//                try {
//                    int result = count/i;
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {

        LockException lockException = new LockException();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    lockException.methodOne("");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(runnable,"t1").start();
        TimeUnit.SECONDS.sleep(2);
        new Thread(runnable,"t2").start();
    }
}