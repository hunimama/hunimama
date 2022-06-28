package stream;

import newjava8.UserEntity;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author 794073612@qq.com
 * @time 16:26 2022/6/3
 **/
public class Test04 {
    public static void main(String[] args) {
        ArrayList<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity("hkt", 13));
        userEntities.add(new UserEntity("cyk", 23));
        userEntities.add(new UserEntity("mjh", 14));
        userEntities.add(new UserEntity("lzb", 15));
        userEntities.add(new UserEntity("yjn", 43));
        userEntities.add(new UserEntity("hcl", 33));
        userEntities.add(new UserEntity("ysl", 25));
        Stream<UserEntity> stream = userEntities.stream();
        stream.filter(userEntity -> {
            boolean flag = userEntity.getAge() > 19;
            return flag;
        }).forEach(userEntity -> System.out.println(userEntity));
    }
}
