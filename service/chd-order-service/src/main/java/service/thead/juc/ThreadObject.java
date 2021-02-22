package service.thead.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead.juc$
 * @ClassName: ThreadObject$
 * @date ：Created in 2020-08-17 14:25
 * @description：锁对象
 * 锁是锁的对象，一个对象head上有两位来标识对象锁，因此当锁对象发生变化，那么锁也跟着变化，所以t2得已执行
 * @modified By：
 * @version: 1.01
 */
public class ThreadObject {

    final Object o = new Object();

    void m() {
        synchronized(o) {
            while(true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());


            }
        }
    }

    public static void main(String[] args) {
        ThreadObject t = new ThreadObject();
        //启动第一个线程
        new Thread(t::m, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //创建第二个线程
        Thread t2 = new Thread(t::m, "t2");

        //t.o = new Object(); //锁对象发生改变，所以t2线程得以执行，如果注释掉这句话，线程2将永远得不到执行机会

        t2.start();

    }

}