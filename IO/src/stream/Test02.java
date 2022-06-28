package stream;

import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * @author 794073612@qq.com
 * @time 15:47 2022/6/3
 **/
public class Test02 {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(10, 20, 40, 50);
        Optional<Integer> reduce = integerStream.reduce((a1, a2) -> a1 + a2);
        System.out.println(reduce.get());
    }
}
