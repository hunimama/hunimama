package newjava8;

import java.util.Objects;

/**
 * @author 794073612@qq.com
 * @time 14:31 2022/6/3
 **/

public class UserEntity {
    private String userName;
    private int age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserEntity(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof UserEntity) {
            return userName.equals(((UserEntity) o).getUserName()) && age == ((UserEntity) o).getAge();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return userName.hashCode();
    }
}
