package iotest;

import org.junit.Test;

/**
 * @author 794073612@qq.com
 * @time 10:50 2022/5/29
 **/
public class Main {
    @Test
    public void testProxy() {
        //目标对象
        HelloService target = new HelloServiceImpl();
        //代理对象
        HelloServiceProxy proxy = new HelloServiceProxy(target);
        proxy.say();
    }
}
