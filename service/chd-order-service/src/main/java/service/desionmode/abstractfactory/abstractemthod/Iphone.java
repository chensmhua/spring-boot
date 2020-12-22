package service.desionmode.abstractfactory.abstractemthod;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.abstractfactory.abstractemthod$
 * @ClassName: Iphone$
 * @date ：Created in 2020-11-05 14:18
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class Iphone extends Phone {

    public Iphone(String name) {
        super(name);
    }

    public void printName(){
        System.out.println("iphone:"+getName());
    }
}