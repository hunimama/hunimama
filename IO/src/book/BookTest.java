package book;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author 794073612@qq.com
 * @time 21:37 2022/6/13
 **/
public class BookTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, book> hashMap = new HashMap<Integer,book>();
        int i = 0;
        while (scanner.hasNext()){
            book book = new book();
            String s = scanner.nextLine();
            String[] x = s.split(" ");
            book.setNumber(x[0]);
            book.setNumber(x[1]);
            book.setPrice(x[3]);
            if(book.getNumber().equals("0") && book.getName().equals("0") && book.getPrice().equals("0")){
                break;
            }
            hashMap.put(i, book);
            ++i;
        }
        System.out.println(i);
        for (Map.Entry<Integer, book> book : hashMap.entrySet()) {
            System.out.println(book.getValue());
        }
    }

}
@Data
class book {
    private String number;
    private String name;
    private String price;
}