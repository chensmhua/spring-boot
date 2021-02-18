package service.desionmode.chainofresponsibility;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.chainofresponsibility$
 * @ClassName: FilterMain$
 * @date ：Created in 2/18/21 7:14 PM
 * @description：主函数
 * @modified By：
 * @version: 1.01
 */
public class FilterMain {

    public static void main(String[] args) {
        Message message = new Message();

        message.setMsg(" <th> 替换标题 敏感字：996 ");

        FilterChain filterChain = new FilterChain();

        filterChain.add(new HTMLFilter()).add(new SensitiveFilter());

        filterChain.doFilter(message);

        System.out.println(message.getMsg());

    }
}