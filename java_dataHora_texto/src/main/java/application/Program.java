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
        Instant data6 = Instant.parse("2026-03-04T15:52:33Z");

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
        DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT;

        System.out.println("--------------------------------");
        System.out.println("Data 1: " + data4.format(fmt1));
        System.out.println("Data 1: " + fmt1.format(data4));
        System.out.println("Data 2: " + fmt2.format(data5));
        System.out.println("Data 3: " + fmt3.format(data6));
        System.out.println("--------------------------------");
        System.out.println("Data 2: " + fmt4.format(data5));
        System.out.println("Data 3: " + fmt5.format(data6));
    }
}
