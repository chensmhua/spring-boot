package service.desionmode.strategy.comparable;

import service.desionmode.strategy.Cat;
import service.desionmode.strategy.ComparableInterface;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.strategy.comparable$
 * @ClassName: CatComparableService$
 * @date ：Created in 2020-09-29 15:52
 * @description：🐱比较器
 * @modified By：
 * @version: 1.01
 */
public class CatComparableService implements ComparableInterface<Cat> {
    @Override
    public int comparator(Cat o1, Cat o2) {
        if (o1.getBeer() < o2.getBeer()){
            return -1;
        }else {
            return 1;
        }
    }
}