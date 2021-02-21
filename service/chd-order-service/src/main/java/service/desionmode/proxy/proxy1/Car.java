package service.desionmode.proxy.proxy1;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.proxy.proxy1$
 * @ClassName: Car$
 * @date ：Created in 2/21/21 3:04 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class Car implements MoveAble {
    @Override
    public void move() {
        System.out.println("car going.....");
    }
}