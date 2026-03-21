package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        // Cria uma data local a partir de um texto padrão ISO 8601
        LocalDate data4 = LocalDate.parse("2026-03-04");
        // Cria uma data local com horas a partir de um texto padrão ISO 8601
        LocalDateTime data5 = LocalDateTime.parse("2026-03-04T15:52:33");
        // Cria uma data global com horas a partir de um texto padrão ISO 8601
        // informando o timezone do GMT
        Instant data6 = Instant.parse("2026-03-04T01:52:33Z");

        LocalDate res1 = LocalDate.ofInstant(data6, ZoneId.systemDefault());
        LocalDate res2 = LocalDate.ofInstant(data6, ZoneId.of("Portugal"));

        LocalDateTime res3 = LocalDateTime.ofInstant(data6, ZoneId.systemDefault());
        LocalDateTime res4 = LocalDateTime.ofInstant(data6, ZoneId.of("Portugal"));

        System.out.println("Resultado: " + res1);
        System.out.println("Resultado: " + res2);
        System.out.println("Resultado: " + res3);
        System.out.println("Resultado: " + res4);

        System.out.println(data5.getDayOfMonth());
        System.out.println(data5.getDayOfWeek());
        System.out.println(data5.getDayOfYear());
        System.out.println(data5.getMonthValue());
        System.out.println(data5.getDayOfWeek().getValue());
    }
}
