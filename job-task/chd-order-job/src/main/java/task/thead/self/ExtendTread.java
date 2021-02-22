package task.thead.self;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test$
 * @ClassName: ExtendTread$
 * @date ：Created in 2020-07-13 17:18
 * @description ：继承Thread类
 * @modified By：
 * @version: 1.01
 */
//继承thread类，重写run()方法，调用start开启线程
    //总结：线程开启不一定立即执行，由cpu调度执行
public class ExtendTread extends Thread{

    @Override
    public void run(){
        for (int i = 0; i < 20; i++) {
            System.out.println("run-------"+i);
        }
    }

    public static void main(String[] args) {
        //main线程，主线程
        ExtendTread extendTread = new ExtendTread();
        //跑复写run方法，先跑run方法里面，然后再走主线程的方法
        extendTread.run();
        //start方法会开辟新的线程，同时调用run和main的方法
        extendTread.start();
        for (int i = 0; i < 2000; i++) {
            System.out.println("main======"+i);
        }

    }
}