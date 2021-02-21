package service.desionmode.proxy.proxy1;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.proxy.proxy1$
 * @ClassName: Main$
 * @date ：Created in 2/21/21 3:09 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class Main {

    public static void main(String[] args) {
        new CarLogProxy(
                new CarRuntimeProxy(
                        new Car()
                )
        ).move();
    }
}