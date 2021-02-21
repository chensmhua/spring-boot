package service.desionmode.prototype;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.prototype$
 * @ClassName: Main$
 * @date ：Created in 2/21/21 9:20 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        Person person1 = (Person) person.clone();
        System.out.println(person.location == person1.location);

        System.out.println(person1.age + ""+person1.name+person1.location.toString());
        person.location.street = "s2";
        System.out.println(person.age + ""+person.name + person.location.toString());
        System.out.println(person1.age + ""+person1.name+person1.location.toString());
    }
}