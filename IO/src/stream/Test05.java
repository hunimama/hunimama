package stream;

import newjava8.UserEntity;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * @author 794073612@qq.com
 * @time 16:29 2022/6/3
 **/
public class Test05 {
    public static void main(String[] args) {
        ArrayList<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity("hkt", 13));
        userEntities.add(new UserEntity("cyk", 23));
        userEntities.add(new UserEntity("mjh", 14));
        userEntities.add(new UserEntity("lzb", 15));
        userEntities.add(new UserEntity("lzb", 16));
        userEntities.add(new UserEntity("lzb", 13));
        userEntities.add(new UserEntity("lzb", 18));
        userEntities.add(new UserEntity("yjn", 43));
        userEntities.add(new UserEntity("hcl", 33));
        userEntities.add(new UserEntity("ysl", 25));
        Stream<UserEntity> stream = userEntities.stream();
        //开始skip 结束limit
//        stream.skip(2).limit(2).forEach(userEntity -> System.out.println(userEntity));
        stream.sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .filter((o) -> "lzb".equals(o.getUserName()))
                .skip(2).limit(2)
                .forEach(userEntity -> System.out.println(userEntity));
    }
}
