package service.desionmode.strategy;

import lombok.Data;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.strategy$
 * @ClassName: Cat$
 * @date ：Created in 2020-09-27 16:03
 * @description：🐱
 * @modified By：
 * @version: 1.01
 */
@Data
public class Cat implements Comparable<Cat> {

    int beer;

    int soft;

    public Cat(int beer,int soft){
        this.beer = beer;
        this.soft = soft;
    }

    @Override
    public String toString() {
        return beer + "||" + soft;
    }

    @Override
    public int compareTo(Cat o) {
        if (this.beer < o.getBeer()){
            return -1;
        }else {
            return 1;
        }
    }
}