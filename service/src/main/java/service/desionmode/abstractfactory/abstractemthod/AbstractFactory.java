package service.desionmode.abstractfactory.abstractemthod;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.abstractfactory.abstractemthod$
 * @ClassName: AbstractFactory$
 * @date ：Created in 2020-11-05 11:38
 * @description：抽象工厂
 * @modified By：
 * @version: 1.01
 */
public abstract class AbstractFactory {

    public abstract Person creatMan();

    public abstract Phone createPhone();
}