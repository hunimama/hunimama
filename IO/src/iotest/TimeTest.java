package iotest;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author 794073612@qq.com
 * @time 20:36 2022/5/30
 **/
public class TimeTest {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angeles"));
        Date date = new Date();
        System.out.println(date);
        System.out.println(Calendar.getInstance(TimeZone.getTimeZone("America/Los_Angeles")));
        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataStr = sdf.format(date);
        System.out.println(dataStr);
    }
}
