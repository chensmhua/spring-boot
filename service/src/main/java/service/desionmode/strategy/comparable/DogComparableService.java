package service.desionmode.strategy.comparable;

import service.desionmode.strategy.ComparableInterface;
import service.desionmode.strategy.Dog;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.strategy.comparable$
 * @ClassName: DogComparableService$
 * @date ：Created in 2020-09-29 15:53
 * @description：🐶比较器
 * @modified By：
 * @version: 1.01
 */
public class DogComparableService implements ComparableInterface<Dog> {

    @Override
    public int comparator(Dog o1, Dog o2) {
        if (o1.getHeight() < o2.getHeight()){
            return -1;
        }else {
            return 1;
        }
    }
}