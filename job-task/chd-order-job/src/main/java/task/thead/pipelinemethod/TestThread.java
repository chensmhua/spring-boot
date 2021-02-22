package task.thead.pipelinemethod;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead.pipelinemethod$
 * @ClassName: TestThread$
 * @date ：Created in 2020-07-14 18:35
 * @description：
 * @modified By：
 * @version: 1.01
 */
public class TestThread {
    public static void main(String[] args) {
        CatchProductDemo catchProductDemo = new CatchProductDemo();

        Product product = new Product(catchProductDemo);
        product.start();

        new Cusumer(catchProductDemo).start();
    }
}