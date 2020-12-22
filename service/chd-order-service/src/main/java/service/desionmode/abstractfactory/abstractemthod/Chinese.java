package service.desionmode.abstractfactory.abstractemthod;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.abstractfactory.abstractemthod$
 * @ClassName: Chinese$
 * @date ：Created in 2020-11-05 14:25
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class Chinese extends Person {
    public Chinese(String name) {
        super(name);
    }
    public void printName(){
        System.out.println("中国人"+getName());
    }
}