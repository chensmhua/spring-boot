package task.thead.self;

import java.util.ArrayList;
import java.util.List;

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
public class ValidateTest {

    volatile Integer count  = 0;

    void number(){
        for (int i = 0; i < 10000000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        ValidateTest validateTest = new ValidateTest();


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