package thread;

import java.util.concurrent.*;

/**
 * @author 794073612@qq.com
 * @time 16:28 2022/6/4
 **/
public class Test03 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<String> futureTask = new FutureTask<String>(() -> {
            System.out.println(Thread.currentThread().getName() + "\t ---------come in");
            TimeUnit.SECONDS.sleep(5);
            return "task over";
        });
        Thread t1 = new Thread(futureTask, "t1");
        t1.start();

        //假如不愿意等待很长时间，可以选择离开
//        System.out.println(futureTask.get(3, TimeUnit.SECONDS));

        //非要等到结果才会离开，不管你是否计算完成，容易程序堵塞
//        System.out.println(futureTask.get());
        while (true) {
            if (futureTask.isDone()) {
                System.out.println(futureTask.get());
                break;
            } else {
                TimeUnit.MILLISECONDS.sleep(500);
                System.out.println("正在处理中，不要再催了");
            }
        }

        System.out.println(Thread.currentThread().getName() + "\t ------ 忙其他任务了");
    }
}
