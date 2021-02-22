package service.thead.self;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead$
 * @ClassName: ThreadPriority$
 * @date ：Created in 2020-07-14 15:26
 * @description：测试线程的优先级
 * @modified By：
 * @version: 1.01
 */
public class ThreadPriority {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"优先级："+Thread.currentThread().getPriority());

        Mypriority mypriority = new Mypriority();

        Thread t1 = new Thread(mypriority);
        Thread t2 = new Thread(mypriority);
        Thread t3 = new Thread(mypriority);
        Thread t4 = new Thread(mypriority);
        Thread t5 = new Thread(mypriority);

        //设置优先级
        t1.setPriority(2);
        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(Thread.MAX_PRIORITY);
        t3.start();



    }
}