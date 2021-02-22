package task.thead.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead.juc$
 * @ClassName: Volatile$
 * @date ：Created in 2020-08-17 11:27
 * @description：volatile
 * 结论： Volatile 关键字使全局变量达到线程可读性,通过总线当MESI消息缓存一致性
 * @modified By：
 * @version: 1.01
 */
public class Volatile {

    volatile Boolean flag = true;

    //此方法读取数据
    public void read(){
        System.out.println("thread start!");
        //判断条件
        while (flag){
            System.out.println(Thread.currentThread().getName());
        }
        System.out.println("thread end!");
    }


    public static void main(String[] args) throws InterruptedException {
        Volatile aVolatile = new Volatile();
        for (int i = 0; i < 1000; i++) {
            String name  = "t1"+i;
            new Thread(aVolatile::read,name).start();
        }
        TimeUnit.SECONDS.sleep(1);
        aVolatile.flag = false;
    }

}