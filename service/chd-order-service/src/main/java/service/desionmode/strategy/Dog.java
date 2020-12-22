package service.desionmode.strategy;

import lombok.Data;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.strategy$
 * @ClassName: Dog$
 * @date ：Created in 2020-09-27 16:01
 * @description：🐶
 * @modified By：
 * @version: 1.01
 */
@Data
public class Dog implements Comparable<Dog> {

    int height;

    int weight;

    public Dog (int height,int weight){
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString(){
        return height +" || "+ weight;
    }

    @Override
    public int compareTo(Dog o) {
        if (this.weight < o.getWeight()){
            return -1;
        }else {
            return 1;
        }
    }
}