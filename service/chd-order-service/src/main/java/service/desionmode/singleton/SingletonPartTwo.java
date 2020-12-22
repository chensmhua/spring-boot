package service.desionmode.singleton;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.singleton$
 * @ClassName: SingletonPartTwo$
 * @date ：Created in 2020-09-25 15:33
 * @description：饱汉式--线程非安全
 * @modified By：
 * @version: 1.01
 */
public class SingletonPartTwo {

    private SingletonPartTwo(){}

    private static SingletonPartTwo INSTANCE;

    public static SingletonPartTwo getInstance(){
        if (INSTANCE == null){
            //先判断
            INSTANCE = new SingletonPartTwo();
        }
        return INSTANCE;
    }
}