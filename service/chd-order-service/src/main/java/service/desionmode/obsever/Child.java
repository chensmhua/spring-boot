package service.desionmode.obsever;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：huadong.chen
 * @ProjectName: controller$
 * @Package: service.desionmode.obsever$
 * @ClassName: Child$
 * @date ：Created in 2/19/21 3:54 PM
 * @description：baby
 * @modified By：
 * @version: 1.01
 */
public class Child {

    private Boolean cry=Boolean.FALSE;

    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
    }

    public void setCry(Boolean cry) {
        this.cry = cry;
    }

    public void wakeUp() {
        if (cry) {
            for (Observer observer :
                    observers) {
                observer.actionBabyWakeUp();
            }
        }
    }
}