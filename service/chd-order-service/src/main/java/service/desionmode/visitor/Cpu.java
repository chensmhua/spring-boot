package service.desionmode.visitor;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.visitor$
 * @ClassName: Cpu$
 * @date ：Created in 2/21/21 8:08 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class Cpu extends ComputerPart {
    @Override
    void accept(Visitor visitor) {
        visitor.visitCpu(this);
    }

    @Override
    int getPrice() {
        return 1000;
    }
}