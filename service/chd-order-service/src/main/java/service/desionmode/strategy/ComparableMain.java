package service.desionmode.strategy;

import service.desionmode.strategy.comparable.CatComparableService;

import java.util.Arrays;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.strategy$
 * @ClassName: ComparableMain$
 * @date ：Created in 2020-09-29 16:40
 * @description：比较主函数
 * @modified By：
 * @version: 1.01
 */
public class ComparableMain {

    public static void main(String[] args) {
        Cat[] a = {new Cat(1,4),new Cat(5,2),new Cat(3,3)};
        Sorter<Cat> sorter = new Sorter<>();
        sorter.sort(a,new CatComparableService());
        System.out.println(Arrays.toString(a));
    }
}