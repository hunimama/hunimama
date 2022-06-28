package newjava8;

/**
 * @author 794073612@qq.com
 * @time 13:14 2022/6/3
 **/
public class Test01 {
    public static void main(String[] args) {
        new AcanthopanaxInterface() {
            @Override
            public void get() {
                System.out.println("get");
            }
        }.get();
        AcanthopanaxInterface acanthopanaxInterface = () -> {
            System.out.println("lambda");
        };
        acanthopanaxInterface.get();
        ((AcanthopanaxInterface) () -> System.out.println("lambda get")).get();
    }
}
