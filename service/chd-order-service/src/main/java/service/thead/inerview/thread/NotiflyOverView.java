package service.thead.inerview.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.thead.inerview.thread$
 * @ClassName: NotiflyOverView$
 * @date ：Created in 2/23/21 10:33 AM
 * @description：两个线程
 * @modified By：
 * @version: 1.01
 */
public class NotiflyOverView {

    //声明一个可见性的线程安全的集合
    volatile List list = Collections.synchronizedList(new ArrayList<>());

    public void add(Object o){
        list.add(o);
    }

    public int size(){
        return this.list.size();
    }

    public static void main(String[] args) {
        NotiflyOverView volatileOverView = new NotiflyOverView();

        final Object lock = new Object();

        //线程一
        new Thread(() -> {
            System.out.println("t1线程启动!!!!!!    ");
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    volatileOverView.add(new Object());
                    System.out.println("add"+i);
                    if (i == 4){
                        //主动唤醒线程二的锁
                        lock.notify();
                        try {
                            //同时调用wait释放锁
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }



        },"t1").start();

        //线程二，根据线程一状态
        new Thread(() -> {
            System.out.println("t2线程启动～～～～～");
            synchronized (lock){
                if(volatileOverView.size() !=5){
                    try {
                        //释放锁
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("t2结束~");
                lock.notify();
            }

        }).start();
    }
}