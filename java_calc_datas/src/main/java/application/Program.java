package application;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.parse("2021-04-20");
        LocalDateTime date2 = LocalDateTime.parse("2021-04-20T10:15:30");
        Instant date3 = Instant.parse("2021-04-20T10:15:30Z");

        LocalDate sevenLessDays = date1.minusDays(7);
        LocalDate sevenPlusDays = date1.plusDays(7);

        System.out.println("sevenLessDays: " + sevenLessDays);
        System.out.println("sevenPlusDays: " + sevenPlusDays);

        LocalDateTime sevenLessDaysTime = date2.minusDays(7);
        LocalDateTime sevenPlusDaysTime = date2.plusDays(7);

        System.out.println("sevenLessDaysTime: " + sevenLessDaysTime);
        System.out.println("sevenPlusDaysTime: " + sevenPlusDaysTime);

        Instant sevenLessDaysInstant = date3.minus(7, ChronoUnit.DAYS);
        Instant sevenPlusDaysInstant = date3.plus(7, ChronoUnit.DAYS);

        System.out.println("sevenLessDaysInstant: " + sevenLessDaysInstant);
        System.out.println("sevenPlusDaysInstant: " + sevenPlusDaysInstant);

        Duration d1 = Duration.between(sevenLessDaysTime, date2);
        Duration d2 = Duration.between(sevenLessDays.atTime(0,0), date1.atTime(0,0));

        System.out.println("d1: " + d1.toDays());
        System.out.println("d2: " + d2.toDays());

    }
}
