package service.thead.juc;

import java.util.concurrent.TimeUnit;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead.juc$
 * @ClassName: LockReentrantExtend$
 * @date ：Created in 2020-08-17 10:52
 * @description：可重入锁继承
 *  * 一个同步方法可以调用另外一个同步方法，一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁.
 *  * 也就是说synchronized获得的锁是可重入的
 *  * 这里是继承中有可能发生的情形，子类调用父类的同步方法
 *  结论：可重入锁保证子父类继承关系里面，当子类调用父类的方法时，由于锁的可重入性，不会导致锁的资源竞争造成死锁,此时子类
 *       调用时，已经是判断获取的父类的锁
 * @modified By：
 * @version: 1.01
 */
public class LockReentrantExtend {
    synchronized void m() {
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args) {
        new LockReentrantChild().m();
    }

}

//重入锁校验
class LockReentrantChild extends LockReentrantExtend{

    @Override
    public synchronized void m(){
        System.out.println("child m start");
        super.m();
        System.out.println("child m end");
    }
}