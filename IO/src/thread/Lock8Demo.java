package thread;

import java.util.concurrent.TimeUnit;

/**
 * @author 794073612@qq.com
 * @time 19:55 2022/6/5
 **/
class Phone { //资源类
    public static synchronized void sendEmail() {
//        try {
//            TimeUnit.MILLISECONDS.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("-------sendEmail");
    }

    public synchronized void sendSMS() {
        System.out.println("-------sendSMS");
    }

    public void hello() {
        System.out.println("hello");
    }
}

/**
 * 题目：谈谈你对多线程锁的理解，8锁案例说明
 * 口诀：线程 操作 资源类
 * 8锁案例说明：
 * 1.标准访问有ab两个线程，请问先打印邮件还是短信
 * 2.sendEmail方法中加入暂停3秒钟，请问是先打印邮件还是短信
 * 3.添加一个普通的hello方法，请问先打印邮件还是hello
 * 4.有两部手机，请问先打印邮件还是短信
 * 5.有两个静态同步方法，有1部手机，请问先打印邮件还是短信
 * 6.有两个静态同步方法，有2部手机，请问先打印邮件还是短信
 * 7.有1个静态同步方法，有1个普通同步方法，有1部手机，请问先打印邮件还是短信
 * 8.有1个静态同步方法，有1个普通同步方法，有2部手机，请问先打印邮件还是短信
 */
public class Lock8Demo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(() -> {
            phone.sendEmail();
        }, "a").start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
//            phone.sendSMS();
//            phone.hello();
            phone2.sendSMS();
        }, "b").start();
    }

}
