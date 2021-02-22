package service.thead.self;

/**
 * @author ：huadong.chen
 * @ProjectName: springboot01helloword$
 * @Package: com.springboot.test.thead$
 * @ClassName: ThreadRace$
 * @date ：Created in 2020-07-13 19:11
 * @description：龟兔赛跑
 * @modified By：
 * @version: 1.01
 */
public class ThreadRace implements Runnable {

    //获胜者
    private static String winner;

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            Boolean result = checkGame(i);
            if(result){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"---->跑了["+i+"]步");
        }
    }

    private Boolean checkGame(int steps){
        if (winner!=null){
            return true;
        }else {
            if (steps >= 100){
                winner = Thread.currentThread().getName();
                System.out.println("冠军是:"+winner);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ThreadRace threadRace = new ThreadRace();

        new Thread(threadRace,"兔子").start();
        new Thread(threadRace,"乌龟").start();
    }
}