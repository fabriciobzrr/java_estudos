package application;

import entities.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Program {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final Scanner sc = new Scanner(System.in);
    public static void main (String[] args) {
        Set<LogEntry> logs = new TreeSet<>();
        print("Caminho: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(" ");
                LocalDateTime date = Instant.parse(fields[1]).atZone(ZoneId.systemDefault()).toLocalDateTime();
                logs.add(new LogEntry(fields[0], date));
                line = br.readLine();
            }

            print("\nNúmeros de usuários: " + logs.size());
            print("\n\nOrdem: ");
            for (LogEntry user : logs) {
                print("\n" + user.getUser() + " - " + dtf.format(user.getDate()));
            }
        } catch (IOException e) {
            print("\nErro: " + e.getMessage());
        }

        sc.close();
    }
    private static void print(String message) {
        IO.print(message);
    }
}
