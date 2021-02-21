package service.desionmode.visitor;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.visitor$
 * @ClassName: ComputerPart$
 * @date ：Created in 2/21/21 8:06 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
public abstract class ComputerPart {

    abstract void accept(Visitor visitor);

    abstract int getPrice();
}