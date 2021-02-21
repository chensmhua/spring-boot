package service.desionmode.prototype;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.prototype$
 * @ClassName: Person$
 * @date ：Created in 2/21/21 9:21 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class Person implements Cloneable {


    int age = 22;
    String name = "张三";

    Location location = new Location("s1",1);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person p = (Person)super.clone();
       // p.location = (Location)location.clone();
        return p;
    }
}