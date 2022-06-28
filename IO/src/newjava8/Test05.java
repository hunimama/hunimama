package newjava8;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author 794073612@qq.com
 * @time 14:32 2022/6/3
 **/
public class Test05 {
    public static void main(String[] args) {
        ArrayList<UserEntity> userLists = new ArrayList<>();
        userLists.add(new UserEntity("hkt", 12));
        userLists.add(new UserEntity("cyk", 13));
        userLists.add(new UserEntity("mjh", 14));
        userLists.sort((o1, o2) -> o1.getAge() - o2.getAge());
        userLists.sort(Comparator.comparingInt(UserEntity::getAge));
        userLists.forEach((t) -> {
            System.out.println(t);
        });

    }
}
