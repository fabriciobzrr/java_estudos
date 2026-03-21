package application;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Program {
    public static void main(String[] args) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date date1 = Date.from(Instant.parse("2023-04-02T20:51:22Z"));

        System.out.println(sdf1.format(date1));

        Calendar calendario = Calendar.getInstance();
        calendario.setTime(date1);
        calendario.add(Calendar.HOUR, 3);
        date1 = calendario.getTime();

        System.out.println(sdf1.format(date1));

        int hours = calendario.get(Calendar.HOUR_OF_DAY);
        int minutes = calendario.get(Calendar.MINUTE);
        int seconds = calendario.get(Calendar.SECOND);
        int day =  calendario.get(Calendar.DAY_OF_WEEK);
        System.out.println(hours);
        System.out.println(minutes);
        System.out.println(seconds);
        System.out.println(day);
    }
}
