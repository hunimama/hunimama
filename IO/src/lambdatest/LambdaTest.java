package lambdatest;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer;

/**
 * @author 794073612@qq.com
 * @time 22:03 2022/5/30
 **/
public class LambdaTest {
    public static void main(String[] args) {
        String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length");
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
