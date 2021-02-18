package service.desionmode.chainofresponsibility;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.chainofresponsibility$
 * @ClassName: HTMLFilter$
 * @date ：Created in 2/18/21 7:04 PM
 * @description：htmlfiter
 * @modified By：
 * @version: 1.01
 */
public class HTMLFilter implements FilterInterface {

    /**
     * 替换html标签
     *
     * @param message
     */
    @Override
    public void doFilter(Message message) {
        String msg = null;
        msg = message.getMsg().replace("<", "[");
        message.setMsg(msg);
    }
}