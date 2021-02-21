package service.desionmode.visitor;

import sun.plugin2.gluegen.runtime.CPU;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.visitor$
 * @ClassName: Visitor$
 * @date ：Created in 2/21/21 8:07 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
public interface Visitor {


    void visitCpu(Cpu cpu);

    void visitGpu(Gpu gpu);


}