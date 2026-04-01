package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        IO.print("Digite o caminho do arquivo: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            Set<LogEntry> set = new HashSet<>();

            String line = br.readLine();

            while (line != null) {
                String[] logItem = line.split(" ");
                String name = logItem[0];
                Instant moment = Instant.parse(logItem[1]);
                set.add(new LogEntry(name, moment));
                line = br.readLine();
            }

            IO.println("Quantos usuários? " + set.size());

        } catch (IOException e) {
            IO.println("Erro: " + e);
        }

        sc.close();

    }
}
class LogEntry {
    private String name;
    private Instant moment;

    public LogEntry(String name, Instant moment) {
        this.name = name;
        this.moment = moment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LogEntry logEntry = (LogEntry) o;
        return Objects.equals(name, logEntry.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
