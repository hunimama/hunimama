package iotest;

/**
 * @author 794073612@qq.com
 * @time 10:48 2022/5/29
 **/
public class HelloServiceProxy implements HelloService {
    private HelloService target;

    public HelloServiceProxy(HelloService target) {
        this.target = target;
    }

    @Override
    public void say() {
        System.out.println("记录日志");
        target.say();
        System.out.println("清理数据");
    }

}
