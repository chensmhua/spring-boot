package task.thead.pipelinemethod;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead.pipelinemethod$
 * @ClassName: CatchProductDemo$
 * @date ：Created in 2020-07-14 18:06
 * @description：商品缓冲区
 * @modified By：
 * @version: 1.01
 */
public class CatchProductDemo {

    //初始化数据
    ProductDemo[] productDemos = new ProductDemo[10];

    //容器计数器
    private int count = 0;

    //生产产品
    public synchronized void push(ProductDemo productDemo) throws InterruptedException {
        //如果容器满了，等待消费者消费
        if (count == productDemos.length){
            this.wait();
        }
        //没有满，则放入数据
        productDemos[count] = productDemo;
        count++;

        //通知消费者消费
        this.notifyAll();
    }


    public synchronized ProductDemo pop() throws InterruptedException {
        //判断能否消费
        if (count == 0){
            //没有产品，不能消费
            this.wait();
        }

        //可以消费
        count--;
        ProductDemo productDemo = productDemos[count];

        //消费结束通知消费
        this.notifyAll();
        return productDemo;
    }

}