package service.desionmode.abstractfactory.abstractemthod;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.abstractfactory.abstractemthod$
 * @ClassName: AbstarctJapan$
 * @date ：Created in 2020-11-05 11:48
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class AbstarctJapan extends AbstractFactory {
    @Override
    public Person creatMan() {
        return new Japan("小野次郎");
    }

    @Override
    public Phone createPhone() {
        return new Iphone("iphone x");
    }
}