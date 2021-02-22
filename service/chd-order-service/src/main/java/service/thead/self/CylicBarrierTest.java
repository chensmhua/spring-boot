package service.thead.self;

import java.util.concurrent.CyclicBarrier;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test$
 * @ClassName: CylicBarrierTest$
 * @date ：Created in 2020-08-13 20:14
 * @description：满人发车
 * @modified By：
 * @version: 1.01
 */
public class CylicBarrierTest {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(50, () -> System.out.println("满人发车！"));

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    //调用wait等待当前线程满
                    cyclicBarrier.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }).start();
        }
    }
}