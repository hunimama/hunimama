package thread;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author 794073612@qq.com
 * @time 20:33 2022/6/4
 **/
public class CompletableFutureMallDemo {
    static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("dangdang"),
            new NetMall("taobao"),
            new NetMall("pdd"),
            new NetMall("tianmao")
    );

//    public static List<String> getPrice(List<NetMall> list, String productName){
//        List<String> price = list.stream().map(netMall ->
//                String.format(productName + " in %s price is %.2f",
//                        netMall.getNetMallName(),
//                        netMall.calcPrice(productName))
//        ).collect(Collectors.toList());
//        return price;
//    }

    public static List<String> getPriceByCompletableFuture(List<NetMall> list, String productName) {
        List<String> price = list.stream().map(netMall ->
                        CompletableFuture.supplyAsync(() ->
                                String.format(productName + " in %s price is %.2f", netMall.getNetMallName(), netMall.calcPrice(productName))))
                .collect(Collectors.toList())
                .stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        return price;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<String> list1 = getPriceByCompletableFuture(list, "mysql");
        for (String element : list1) {
            System.out.println(element);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("-----costTime: " + (endTime - startTime) + "毫秒");
    }
}

@Data
class NetMall {
    private String netMallName;

    public NetMall(String netMallName) {
        this.netMallName = netMallName;
    }

    public double calcPrice(String productName) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0);
    }
}
