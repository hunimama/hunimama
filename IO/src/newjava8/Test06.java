package newjava8;

/**
 * @author 794073612@qq.com
 * @time 14:39 2022/6/3
 **/
public class Test06 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();

    }

}
