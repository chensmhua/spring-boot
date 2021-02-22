package service.thead.self;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead$
 * @ClassName: ThreadJoin$
 * @date ：Created in 2020-07-14 15:11
 * @description：线程加入
 * @modified By：
 * @version: 1.01
 */
public class ThreadJoin implements Runnable {
    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            System.out.println("thread join！！！！"+i);
        }

    }

    public static void main(String[] args) throws InterruptedException {

        ThreadJoin threadJoin = new ThreadJoin();
        Thread thread = new Thread(threadJoin);
        thread.start();

        for (int i = 0; i < 500; i++) {
            if (i == 200){
                thread.join();
            }
            System.out.println("main:"+i);
        }


    }
}