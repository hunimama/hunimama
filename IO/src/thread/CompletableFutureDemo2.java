package thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author 794073612@qq.com
 * @time 16:03 2022/6/5
 **/
public class CompletableFutureDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> thenCombineResult = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "--------come in 1");
            return 10;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "--------come in 2");
            return 20;
        }), (x, y) -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "--------come in 3");
            return x + y;
        }).thenCombine(CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "--------come in 4");
            return 30;
        }), (a, b) -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "--------come in 5");
            return a + b;
        });
        System.out.println("---------主线程end");
        System.out.println(thenCombineResult.get());
    }

}
