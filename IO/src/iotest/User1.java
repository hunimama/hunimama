package iotest;

/**
 * @author 794073612@qq.com
 * @time 10:05 2022/5/29
 **/
public class User1 {
    private String name;
    private Integer age;

    public User1() {
    }

    public User1(Integer age) {
        this.age = age;
    }

    public User1(String name) {
        this.name = name;
    }

    public User1(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
