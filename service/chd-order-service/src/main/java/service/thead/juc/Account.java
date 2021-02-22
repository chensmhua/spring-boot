package service.thead.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead.juc$
 * @ClassName: Account$
 * @date ：Created in 2020-08-17 10:30
 * @description：
 *  * 面试题：模拟银行账户
 *  * 对业务写方法加锁
 *  * 对业务读方法不加锁
 *  * 这样行不行？
 *  结论：不行，会出现脏读数据,必须写入和读取都需要加上锁
 * @modified By：
 * @version: 1.01
 */
public class Account {

    //名称
    private String name;
    //金额
    private double balance;

    //定义业务方法写入金额，加锁
    public synchronized void set(String name,double balance) throws InterruptedException {
        this.name = name;
        //延迟2秒

        Thread.sleep(2000);
        this.balance = balance;
    }

    //定义方法读取金额,不加锁
    public synchronized double getBalance(String name){
        return this.balance;
    }

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        new Thread(() -> {
            try {
                account.set("张三",100.0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println(account.getBalance("张三"));
        TimeUnit.SECONDS.sleep(3);
        System.out.println(account.getBalance("张三"));
    }

}