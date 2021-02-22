package task.thead.self;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead$
 * @ClassName: ThreadTicks$
 * @date ：Created in 2020-07-14 14:41
 * @description：模拟抢票
 * @modified By：
 * @version: 1.01
 */
public class ThreadTicks implements Runnable {


    private volatile int tickNumbers = 10;

    @Override
    public synchronized void run() {

        while (true){
            if (tickNumbers <= 0 ){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"》》》获取第"+tickNumbers--+"张票");

        }
    }

    public static void main(String[] args) {
        ThreadTicks threadTicks = new ThreadTicks();

        new Thread(threadTicks,"小明").start();
        new Thread(threadTicks,"张三").start();
        new Thread(threadTicks,"黄牛").start();
    }


}