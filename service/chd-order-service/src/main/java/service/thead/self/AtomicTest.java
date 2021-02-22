package service.thead.self;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead$
 * @ClassName: ValidateTest$
 * @date ：Created in 2020-08-12 19:52
 * @description：Validate
 * @modified By：
 * @version: 1.01
 */
public class AtomicTest {

    //引入无锁atomic
    AtomicInteger count = new AtomicInteger(0);

    void number(){
        for (int i = 0; i < 10000; i++) {
            count.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        AtomicTest validateTest = new AtomicTest();


        List<Thread> threads = new ArrayList<Thread>();

        for (int i = 0; i < 1; i++) {
            threads.add(new Thread(validateTest::number,"thread"+i));
        }

        threads.forEach(c -> c.start());

        threads.forEach(c -> {
            try {
                c.join();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(validateTest.count);
    }
}