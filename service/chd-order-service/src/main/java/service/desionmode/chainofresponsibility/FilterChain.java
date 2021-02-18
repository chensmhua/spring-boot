package service.desionmode.chainofresponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.chainofresponsibility$
 * @ClassName: FilterChain$
 * @date ：Created in 2/18/21 7:11 PM
 * @description：链过滤
 * @modified By：
 * @version: 1.01
 */
public class FilterChain implements FilterInterface {

    private List<FilterInterface> filters = new ArrayList<>();

    /**
     * 添加filter
     *
     * @param filterInterface
     * @return
     */
    public FilterChain add(FilterInterface filterInterface) {
        filters.add(filterInterface);
        return this;
    }

    /**
     * 执行filter
     *
     * @param message
     */
    @Override
    public void doFilter(Message message) {
        for (FilterInterface filter : filters) {
            filter.doFilter(message);
        }
    }
}