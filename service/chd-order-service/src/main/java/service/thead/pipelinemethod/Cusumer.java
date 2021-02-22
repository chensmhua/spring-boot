package service.thead.pipelinemethod;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead.pipelinemethod$
 * @ClassName: Cusumer$
 * @date ：Created in 2020-07-14 18:05
 * @description：消费者
 * @modified By：
 * @version: 1.01
 */
public class Cusumer extends Thread{

    CatchProductDemo container;

    public Cusumer(CatchProductDemo container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {

                System.out.println("消费了："+container.pop().id+"只🐔");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}