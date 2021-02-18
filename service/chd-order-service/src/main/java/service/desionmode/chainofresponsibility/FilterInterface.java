package service.desionmode.chainofresponsibility;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.chainofresponsibility$
 * @ClassName: FilterInterface$
 * @date ：Created in 2/18/21 7:03 PM
 * @description：fiter接口
 * @modified By：
 * @version: 1.01
 */
public interface FilterInterface {

    /**
     * filter
     * @param message
     */
    void doFilter(Message message);
}
