package service.desionmode.chainofresponsibility;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.chainofresponsibility$
 * @ClassName: SensitiveFilter$
 * @date ：Created in 2/18/21 7:06 PM
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class SensitiveFilter implements FilterInterface {
    /**
     * 替换敏感字
     *
     * @param message
     */
    @Override
    public void doFilter(Message message) {
        String replace = message.getMsg().replace("997", "955");
        message.setMsg(replace);
    }
}