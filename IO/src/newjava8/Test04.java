package newjava8;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @author 794073612@qq.com
 * @time 14:29 2022/6/3
 **/
public class Test04 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("hkt");
        strings.add("ysl");
        strings.add("mjh");
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        strings.forEach(s -> {
            System.out.println(s);
        });
    }
}
