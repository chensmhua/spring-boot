package service.desionmode.proxy.proxy1;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.proxy.proxy1$
 * @ClassName: CarRuntimeProxy$
 * @date ：Created in 2/21/21 3:04 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class CarRuntimeProxy implements MoveAble {

    private MoveAble moveAble;

    public CarRuntimeProxy(MoveAble moveAble) {
        this.moveAble = moveAble;
    }

    /**
     * 记录时间
     */
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        moveAble.move();
        long end = System.currentTimeMillis();
        System.out.println(start - end);
    }
}