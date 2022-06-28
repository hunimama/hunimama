package thread;

import java.util.concurrent.*;

/**
 * @author 794073612@qq.com
 * @time 19:51 2022/6/4
 **/
public class Test05 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        future1();
        future2();
    }

    private static void future2() throws ExecutionException, InterruptedException {
//        CompletableFuture<Integer> completableFuture =
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "----------come in");
            int result = ThreadLocalRandom.current().nextInt(10);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("--------1秒钟后结果: " + result);
            return result;
        }, threadPool).whenComplete((v, e) -> {
            if (e == null) {
                System.out.println("-----计算完成，更新系统UpdateVa：" + v);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            System.out.println("异常情况：" + e.getCause() + "\t" + e.getMessage());
            return null;
        });
        System.out.println(Thread.currentThread().getName() + "线程先去忙其他任务");
        threadPool.shutdown();
        //主线程不要立刻结束，否则CompletableFuture默认使用的线程池会立刻关闭
//        TimeUnit.SECONDS.sleep(3);
    }


    private static void future1() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "----------come in");
            int result = ThreadLocalRandom.current().nextInt(10);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("--------1秒钟后结果: " + result);
            return result;
        });
        System.out.println(Thread.currentThread().getName() + "线程先去忙其他任务");
        System.out.println(completableFuture.get());
    }
}
