package stream;

import newjava8.UserEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author 794073612@qq.com
 * @time 15:57 2022/6/3
 **/
public class Test03 {
    public static void main(String[] args) {
        ArrayList<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity("hkt", 13));
        userEntities.add(new UserEntity("cyk", 23));
        userEntities.add(new UserEntity("mjh", 14));
        userEntities.add(new UserEntity("lzb", 15));
        userEntities.add(new UserEntity("yjn", 43));
        Stream<UserEntity> stream = userEntities.stream();
        Optional<UserEntity> max = stream.max(new Comparator<UserEntity>() {
            @Override
            public int compare(UserEntity o1, UserEntity o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(max.get());
    }
}
