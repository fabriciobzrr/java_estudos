package application;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        // Cria uma data local (AGORA)
        LocalDate date1 = LocalDate.now();
        // Cria uma data local com horas (AGORA)
        LocalDateTime date2 = LocalDateTime.now();
        // Cria uma data global (AGORA)
        Instant date3 = Instant.now();
        // Cria uma data local a partir de um texto padrão ISO 8601
        LocalDate data4 = LocalDate.parse("2026-03-04");
        // Cria uma data local com horas a partir de um texto padrão ISO 8601
        LocalDateTime data5 = LocalDateTime.parse("2026-03-04T15:52:33");
        // Cria uma data global com horas a partir de um texto padrão ISO 8601
        // informando o timezone do GMT
        Instant data6 = Instant.parse("2026-03-04T15:52:33Z");
        // Cria uma data global com horas a partir de um texto padrão ISO 8601
        // informando o timezone diferente do GMT
        Instant data7 = Instant.parse("2026-03-04T15:52:33-03:00");

        // Cria uma formatação customizada tipo dia/mês/ano
        DateTimeFormatter fmtr1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date8 = LocalDate.parse("04/03/2026", fmtr1);


        System.out.println("Data 1: " + date1);
        System.out.println("Data 2: " + date2);
        System.out.println("Data 3: " + date3);
        System.out.println("Data 4: " + data4);
        System.out.println("Data 5: " + data5);
        System.out.println("Data 6: " + data6);
        System.out.println("Data 7: " + data7);
        System.out.println("Data 8: " + date8);

    }
}
