package task.thead.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead.juc$
 * @ClassName: AtomicIntegerTest$
 * @date ：Created in 2020-08-17 14:42
 * @description：无锁自旋转
 * 结论：AtomicInteger 跟 volatile 一样无法保证输出结果达到预期
 * @modified By：
 * @version: 1.01
 */
public class AtomicIntegerTest {

    AtomicInteger atomicInteger = new AtomicInteger(0);

    void method() {
        for (int i = 0; i < 10000; i++) {
            atomicInteger.incrementAndGet();
        }
    }

    public static void main(String[] args) {
        AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(atomicIntegerTest::method,"t"+i));
        }

        threads.forEach(c -> c.start());

        System.out.println(atomicIntegerTest.atomicInteger);

    }
}