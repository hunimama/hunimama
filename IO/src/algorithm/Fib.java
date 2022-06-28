package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 794073612@qq.com
 * @time 22:50 2022/6/14
 **/
public class Fib {
    public static void main(String[] args) throws IOException {
        int num;
        String str;
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        str = buf.readLine();
        num = Integer.parseInt(str);
        if (num < 0) {
            System.out.println("输入数字必须大于0");
        } else {
            System.out.println(Fibonacci(num));
        }
    }

    public static int output[] = new int[1000];

    public static int Fibonacci(int n) {
        int result;
        result = output[n];
        if (result == 0) {
            if (n == 0) {
                return 0;
            } else if (n == 1) {
                return 1;
            } else {
                return Fibonacci(n - 1) + Fibonacci(n - 2);
            }
        }
        output[n] = result;
        return result;
    }
}

