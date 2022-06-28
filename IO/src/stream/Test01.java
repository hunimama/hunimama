package stream;

import newjava8.UserEntity;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 794073612@qq.com
 * @time 14:48 2022/6/3
 **/
public class Test01 {
    public static void main(String[] args) {
        ArrayList<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity("hkt", 13));
        userEntities.add(new UserEntity("cyk", 23));
        userEntities.add(new UserEntity("mjh", 14));
        userEntities.add(new UserEntity("lzb", 15));
        userEntities.add(new UserEntity("yjn", 43));
//        userEntities.add(new UserEntity("yjn", 43));

        Stream<UserEntity> stream = userEntities.stream();
//        Set<UserEntity> setUserList = stream.collect(Collectors.toSet());
//        setUserList.forEach(userEntity -> System.out.println(userEntity.toString()));

//        Map<String, UserEntity> collect = stream.collect(Collectors.toMap(userEntity -> userEntity.getUserName(), userEntity -> userEntity));
//        collect.forEach((BiConsumer)(s, userEntity) -> System.out.println(s + "," + userEntity));

        Optional<UserEntity> reduce = stream.reduce((u1, u2) -> {
            UserEntity userEntity = new UserEntity("sum: ", u1.getAge() + u2.getAge());
            return userEntity;
        });
        System.out.println(reduce.get().getAge());
    }
}
