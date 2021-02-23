package service.thead.inerview.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.thead.inerview.thread$
 * @ClassName: NotiflyOverView$
 * @date ：Created in 2/23/21 10:33 AM
 * @description：两个线程,通过LockSupport来确保两个线程之间的通信
 * @modified By：
 * @version: 1.01
 */
public class LockSupportNoSleep {

    //声明一个可见性的线程安全的集合
    volatile List list = Collections.synchronizedList(new ArrayList<>());

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return this.list.size();
    }

    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        LockSupportNoSleep volatileOverView = new LockSupportNoSleep();

        //线程一
        t1 = new Thread(() -> {
            System.out.println("t1线程启动!!!!!!    ");

            for (int i = 0; i < 10; i++) {
                volatileOverView.add(new Object());
                System.out.println("add" + i);
                if (i == 4) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }


            }


        }, "t1");


        //线程二，根据线程一状态
        t2 = new Thread(() -> {
            System.out.println("t2线程启动～～～～～");
            LockSupport.park();
            System.out.println("t2结束~");
            LockSupport.unpark(t1);
        });

        t1.start();
        t2.start();
    }
}