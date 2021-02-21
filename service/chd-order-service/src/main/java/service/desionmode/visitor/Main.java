package service.desionmode.visitor;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.visitor$
 * @ClassName: Main$
 * @date ：Created in 2/21/21 8:13 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class Main {

    Gpu gpu = new Gpu();
    Cpu cpu = new Cpu();

    public void accept(Visitor visitor){
        gpu.accept(visitor);
        cpu.accept(visitor);
    }

    public static void main(String[] args) {
        PersonVisitor personVisitor = new PersonVisitor();

        new Main().accept(personVisitor);

        System.out.println(personVisitor.price);

    }
}