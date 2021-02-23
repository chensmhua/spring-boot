package service.thead.inerview.thread;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.thead.inerview.thread$
 * @ClassName: VolatileOverView$
 * @date ：Created in 2/23/21 10:13 AM
 * @description：Volatile 实现两个线程的可见性
 * @modified By：
 * @version: 1.01
 */
public class VolatileOverView {

    //声明一个可见性的线程安全的集合
    volatile List list = Collections.synchronizedList(new ArrayList<>());

    public void add(Object o){
        list.add(o);
    }

    public int size(){
        return this.list.size();
    }

    public static void main(String[] args) {
        VolatileOverView volatileOverView = new VolatileOverView();

        //线程一
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                volatileOverView.add(new Object());
                System.out.println("add"+i);
                //必须加上sleep才可以达到效果，因为在睡眠期间，线程二才会去执行，如果去掉，这样就有问题,可以通过notify和wait的方式，见NotiflyOverView
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        //线程二，根据线程一状态
        new Thread(() -> {

            while (true){
                if (volatileOverView.size() == 5){
                    break;
                }
            }
            System.out.println("t2 end!");

        }).start();
    }
}