package thread;

import java.util.concurrent.TimeUnit;

/**
 * @author 794073612@qq.com
 * @time 15:29 2022/6/4
 **/
public class Test01 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 开始运行, " +
                    ((Thread.currentThread().isDaemon()) ? "守护线程" : "用户线程"));
            while (true) {

            }
        }, "t1");
        // setDaemon必须在start之前
        t1.setDaemon(true);
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t -----end 主线程");
    }
}
