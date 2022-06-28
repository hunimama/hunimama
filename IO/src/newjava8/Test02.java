package newjava8;

/**
 * @author 794073612@qq.com
 * @time 13:22 2022/6/3
 **/
public class Test02 {
    public static void main(String[] args) {
        HktInterface hktInterface = new HktInterface() {
            @Override
            public String get(int i, int j) {
                return i + "--" + j;
            }
        };
        hktInterface.get(1, 2);
        HktInterface hktInterface1 = (i, j) -> {
            return i + "--" + j;
        };
        System.out.println(hktInterface.get(1, 2));
    }
}
