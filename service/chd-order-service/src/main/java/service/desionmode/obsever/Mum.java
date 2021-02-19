package service.desionmode.obsever;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.obsever$
 * @ClassName: Mum$
 * @date ：Created in 2/19/21 3:54 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class Mum implements Observer {

    public void feed(){
        System.out.println("mum feeding....");
    }

    @Override
    public void actionBabyWakeUp() {
        feed();
    }
}