package service.desionmode.obsever;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.obsever$
 * @ClassName: Dad$
 * @date ：Created in 2/19/21 3:54 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class Dad implements Observer {

    public void hug(){
        System.out.println("dad hug.....");
    }

    @Override
    public void actionBabyWakeUp() {
        hug();
    }
}