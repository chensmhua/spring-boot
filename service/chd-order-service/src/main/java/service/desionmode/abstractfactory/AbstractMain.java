package service.desionmode.abstractfactory;

import service.desionmode.abstractfactory.abstractemthod.*;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.abstractfactory$
 * @ClassName: AbstractMain$
 * @date ：Created in 2020-11-05 14:09
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class AbstractMain {

    public static void main(String[] args) {
        AbstractFactory f = new AbstarctJapan();
        Japan p = (Japan) f.creatMan();
        p.printName();
        Iphone phone = (Iphone) f.createPhone();
        phone.printName();

        AbstractFactory c = new AbstractChina();
        Huawei phone1 = (Huawei) c.createPhone();
        Chinese person = (Chinese) c.creatMan();
        person.printName();
        phone1.printName();


    }
}