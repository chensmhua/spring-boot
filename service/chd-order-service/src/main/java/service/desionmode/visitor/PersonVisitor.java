package service.desionmode.visitor;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.visitor$
 * @ClassName: PersonVisitor$
 * @date ：Created in 2/21/21 8:12 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class PersonVisitor implements Visitor {

    int price = 0;

    @Override
    public void visitCpu(Cpu cpu) {
        price += cpu.getPrice()*0.88;
    }

    @Override
    public void visitGpu(Gpu gpu) {
        price += gpu.getPrice()*0.98;
    }
}