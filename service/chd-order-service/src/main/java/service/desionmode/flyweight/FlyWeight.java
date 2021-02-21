package service.desionmode.flyweight;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.flyweight$
 * @ClassName: FlyWeight$
 * @date ：Created in 2/20/21 3:13 PM
 * @description：享元模式
 * @modified By：
 * @version: 1.01
 */
public class FlyWeight {

    public static void main(String[] args) {
        //经典案例，String就是享元模式的一种体现，共享已经有的对象，不需要再进行创建，比如线程池等
        //根据常量池中判断是否存在，如果存在那么就用常量次池中的对象
        String s1 = "abc";
        String s2 = "abc";

        String s3 = new String("abc");
        String s4 = new String("abc");

        //常量次中有，一定相等
        System.out.println(s1 == s2);
        //new String在栈中开辟新对象，因此不一样
        System.out.println(s1 == s3);
        //new String在栈中开辟新对象，因此不一样
        System.out.println(s3 == s4);
        //intern指向常量池中的对象，因此一样
        System.out.println(s1 == s3.intern());
        System.out.println(s4.intern() == s3.intern());
    }


}