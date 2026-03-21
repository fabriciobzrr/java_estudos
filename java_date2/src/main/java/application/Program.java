package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Program {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Date date1 = sdf1.parse("12/04/2023");
        Date date2 = sdf2.parse("12/04/2023 15:32:34");
        Date dateNow1 = new Date();

        System.out.println("-------------------");
        System.out.println("Data 1: " + date1);
        System.out.println("Data 2: " + date2);
        System.out.println("Data 1: " + sdf1.format(date1));
        System.out.println("Data 2: " + sdf2.format(date2));
        System.out.println("Data 3: " + dateNow1);
        System.out.println("Data 3: " + sdf2.format(dateNow1));
    }
}
