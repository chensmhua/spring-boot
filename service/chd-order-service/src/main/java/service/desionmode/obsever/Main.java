package service.desionmode.obsever;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.obsever$
 * @ClassName: Main$
 * @date ：Created in 2/19/21 4:00 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class Main {

    public static void main(String[] args) {
        Child child = new Child();
        child.setCry(Boolean.TRUE);
        child.wakeUp();
    }
}