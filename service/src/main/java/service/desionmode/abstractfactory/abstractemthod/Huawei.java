package service.desionmode.abstractfactory.abstractemthod;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.abstractfactory.abstractemthod$
 * @ClassName: Huawei$
 * @date ：Created in 2020-11-05 14:21
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class Huawei extends Phone {

    public Huawei(String name) {
        super(name);
    }

    public void printName(){
        System.out.println("huawei:"+getName());
    }
}