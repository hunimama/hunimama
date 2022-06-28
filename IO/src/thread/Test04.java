package thread;

import java.util.concurrent.*;

/**
 * @author 794073612@qq.com
 * @time 17:09 2022/6/4
 **/
public class Test04 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
//        CompletableFuture<Void> CompletableFuture = java.util.concurrent.CompletableFuture.runAsync(() -> {
//            System.out.println(Thread.currentThread().getName());
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        },threadPool);
        CompletableFuture<String> CompletableFuture = java.util.concurrent.CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello supplyAsync";
        }, threadPool);
        System.out.println(CompletableFuture.get());
        threadPool.shutdown();
    }
}
