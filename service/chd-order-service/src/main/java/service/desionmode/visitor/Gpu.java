package service.desionmode.visitor;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.visitor$
 * @ClassName: Gpu$
 * @date ：Created in 2/21/21 8:09 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class Gpu extends ComputerPart {
    @Override
    void accept(Visitor visitor) {
        visitor.visitGpu(this);
    }

    @Override
    int getPrice() {
        return 5000;
    }
}