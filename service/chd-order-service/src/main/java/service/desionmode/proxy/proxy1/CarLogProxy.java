package service.desionmode.proxy.proxy1;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.proxy.proxy1$
 * @ClassName: CarLogProxy$
 * @date ：Created in 2/21/21 3:05 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class CarLogProxy implements MoveAble {

    private MoveAble moveAble;

    public CarLogProxy(MoveAble moveAble) {
        this.moveAble = moveAble;
    }


    /**
     * 记录日志
     */
    @Override
    public void move() {
        System.out.println("汽车开始工作");
        moveAble.move();
        System.out.println("汽车结束工作");
    }
}