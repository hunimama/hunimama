package newjava8;

/**
 * @author 794073612@qq.com
 * @time 13:27 2022/6/3
 **/
public class Test03 {
    public static void main(String[] args) {
        AcanthopanaxInterface acanthopanaxInterface = () -> {
            System.out.println("我是方法");
        };
        acanthopanaxInterface.get();
        ((AcanthopanaxInterface) () -> {
            System.out.println("我是方法");
        }).get();
        ((AcanthopanaxInterface) () -> System.out.println("我是方法")).get();
        String s = ((HktInterface) (i, j) -> i + "-" + j).get(2, 3);
        System.out.println(s);
    }
}
