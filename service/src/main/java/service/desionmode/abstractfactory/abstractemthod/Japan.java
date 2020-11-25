package service.desionmode.abstractfactory.abstractemthod;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.abstractfactory.abstractemthod$
 * @ClassName: Japan$
 * @date ：Created in 2020-11-05 14:27
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class Japan extends Person {
    public Japan(String name) {
        super(name);
    }
    public void printName(){
        System.out.println("日本人"+getName());
    }
}