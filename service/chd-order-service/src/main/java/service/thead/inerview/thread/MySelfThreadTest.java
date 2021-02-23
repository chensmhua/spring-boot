package service.thead.inerview.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.thead.inerview.thread$
 * @ClassName: MySelfThreadTest$
 * @date ：Created in 2/23/21 7:58 PM
 * @description：两个线程交叉打印A1B2C3-----G7
 * @modified By：
 * @version: 1.01
 */
public class MySelfThreadTest {


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

    static List<String> letters = new ArrayList<>();


    public static void main(String[] args) {

        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");
        letters.add("F");
        letters.add("G");

        //线程一
        t1 = new Thread(() -> {
            System.out.println("t1线程启动!!!!!!    ");

            for (int i = 0; i < letters.size(); i++) {
                System.out.println(letters.get(i));
                //释放第二线程
                LockSupport.unpark(t2);
                //暂停当前线程
                LockSupport.park();

            }
        }, "t1");


        //线程二，根据线程一状态
        t2 = new Thread(() -> {

            for (int i = 1; i < 8; i++) {
                System.out.println(i);
                LockSupport.unpark(t1);
                LockSupport.park();

            }


        });

        t1.start();
        t2.start();
    }
}