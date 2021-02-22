package task.thead.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead.juc$
 * @ClassName: ReentrantCyclicBarrier$
 * @date ：Created in 2020-08-18 14:56
 * @description：满人，发车
 * @modified By：
 * @version: 1.01
 */
public class ReentrantCyclicBarrier {



    public static void main(String[] args) {


        CyclicBarrier cyclicBarrier =  new CyclicBarrier(10,() -> System.out.println("满人，发车"));


        for (int i = 0; i < 30; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            };
            new Thread(runnable).start();
        }
    }
}