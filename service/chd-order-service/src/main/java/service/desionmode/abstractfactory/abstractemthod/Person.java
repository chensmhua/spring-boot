package service.desionmode.abstractfactory.abstractemthod;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.abstractfactory.abstractemthod$
 * @ClassName: Person$
 * @date ：Created in 2020-11-05 14:26
 * @description：
 * @modified By：
 * @version: 1.01
 */
public abstract class Person {
    private String name;

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}