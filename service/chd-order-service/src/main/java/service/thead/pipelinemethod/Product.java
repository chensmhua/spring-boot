package service.thead.pipelinemethod;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead.pipelinemethod$
 * @ClassName: Product$
 * @date ：Created in 2020-07-14 18:05
 * @description：生产者
 * @modified By：
 * @version: 1.01
 */
public class Product extends Thread {

    private CatchProductDemo catchProductDemo;

    public Product(CatchProductDemo catchProductDemo){
        this.catchProductDemo = catchProductDemo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                catchProductDemo.push(new ProductDemo(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生产者生产了："+i+"只🐔");
        }
    }
}