package service.thead.self;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test$
 * @ClassName: ImplementsRunnable$
 * @date ：Created in 2020-07-13 18:48
 * @description：实现runnanble
 * @modified By：
 * @version: 1.01
 */
public class ImplementsRunnable implements Runnable {
    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            System.out.println("run-------"+i);
        }
    }

    public static void main(String[] args) {
        //main线程，主线程
        ImplementsRunnable implementsRunnable = new ImplementsRunnable();

        new Thread(implementsRunnable).start();
        for (int i = 0; i < 2000; i++) {
            System.out.println("main======"+i);
        }

    }
}