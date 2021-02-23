package service.thead.inerview.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.thead.inerview.thread$
 * @ClassName: ContainerTest$
 * @date ：Created in 2/23/21 8:17 PM
 * @description：经典生产者和消费者，一个方法往容器添加，添加满了就阻塞，宁外一个get方法删除元素，容器为空就阻塞
 * @modified By：
 * @version: 1.01
 */
public class ContainerTest {

    static LinkedList<Object> list = new LinkedList<>();

    private int max = 5;

    private int count = 0;

    public synchronized void put(Object o){
        while (list.size() == max){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(o);
        ++count;
        this.notifyAll();
    }

    public synchronized Object get(){
        while (list.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Object o = list.removeFirst();
        count--;
        this.notifyAll();
        return o;
    }

    public static void main(String[] args) {
        ContainerTest containerTest = new ContainerTest();
        //启动消费者
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 5; j++) {
                    System.out.println(containerTest.get());
                }
            }).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //启动生产者
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 25; j++) {
                    containerTest.put(Thread.currentThread().getName()+" === "+j);
                }
            }).start();
        }
    }
}