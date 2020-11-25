package service.desionmode.abstractfactory.abstractemthod;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.abstractfactory.abstractemthod$
 * @ClassName: AbstractChina$
 * @date ：Created in 2020-11-05 11:40
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class AbstractChina extends AbstractFactory {
    @Override
    public Person creatMan() {
        return new Chinese("张三");
    }

    @Override
    public Phone createPhone() {
        return new Huawei("华为mate40");
    }
}