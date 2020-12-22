package service.desionmode.singleton;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.singleton$
 * @ClassName: SingletonPartOne$
 * @date ：Created in 2020-09-25 15:05
 * @description：单例设计模式一  饿汉式
 * 类加载到内存后就实例化一个单例，JVM来保证线程安全
 * 唯一缺点：不管是否用到都会被实例化
 * @modified By：
 * @version: 1.01
 */
public class SingletonPartOne {

    //私有构造方法不允许实例化
    private SingletonPartOne(){}

    private static final SingletonPartOne INSTANCE = new SingletonPartOne();

    public static void main(String[] args) {
        SingletonPartOne instance = SingletonPartOne.INSTANCE;
        SingletonPartOne instance2 = SingletonPartOne.INSTANCE;
        System.out.println(instance ==instance2);
    }
}