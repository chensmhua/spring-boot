package service.desionmode.abstractfactory.abstractemthod;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.abstractfactory.abstractemthod$
 * @ClassName: Phone$
 * @date ：Created in 2020-11-05 14:24
 * @description：
 * @modified By：
 * @version: 1.01
 */
public abstract class Phone {

    private String name;

    public Phone(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}