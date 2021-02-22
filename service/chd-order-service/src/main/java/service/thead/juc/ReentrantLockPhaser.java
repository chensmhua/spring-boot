package service.thead.juc;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead.juc$
 * @ClassName: ReentrantLockPhaser$
 * @date ：Created in 2020-08-18 15:13
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class ReentrantLockPhaser {
    static Random random = new Random();
    static MarryPhaser marryPhaser =new MarryPhaser();
    static class MarryPhaser extends Phaser {
        @Override
        protected boolean onAdvance(int phase, int registeredParties){
            switch (phase) {
                case 0:
                    System.out.println("所有人到齐了！");
                    return false;
                case 1:
                    System.out.println("所有人吃完了！");
                    return false;
                case 2:
                    System.out.println("所有人离开了！");
                    System.out.println("婚礼结束！");
                    return true;
                default:
                    return true;
            }
        }
    }

    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        public void arrive() {
            milliSleep(random.nextInt(1000));
            System.out.printf("%s 到达现场！\n", name);
        }

        public void eat() {
            milliSleep(random.nextInt(1000));
            System.out.printf("%s 吃完!\n", name);
        }

        public void leave() {
            milliSleep(random.nextInt(1000));
            System.out.printf("%s 离开！\n", name);
        }

    }

    static void milliSleep(int i){
        try {
            TimeUnit.SECONDS.sleep(i);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        marryPhaser.bulkRegister(5);

        for (int i = 0; i < 5; i++) {
            final int name = i;
            new Thread(() -> {
                Person p = new Person("person " + name);
                p.arrive();
                marryPhaser.arriveAndAwaitAdvance();

                p.eat();
                marryPhaser.arriveAndAwaitAdvance();

                p.leave();
                marryPhaser.arriveAndAwaitAdvance();
            }).start();
        }
    }
}


