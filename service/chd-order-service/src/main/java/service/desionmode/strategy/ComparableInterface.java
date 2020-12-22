package service.desionmode.strategy;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.strategy$
 * @ClassName: ComparableInterface$
 * @date ：Created in 2020-09-28 15:44
 * @description：比较接口
 * @modified By：
 * @version: 1.01
 */
public interface ComparableInterface<T> {

    int comparator(T o1, T o2);
}
