package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> regs = new HashMap<>();

        IO.print("Digite o caminho do arquivo: ");
        String file = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                Integer votes = Integer.parseInt(fields[1]);

                Candidate candidate = new Candidate(name, votes);

                if(!regs.containsKey(candidate.getName())) {
                    regs.put(candidate.getName(), candidate.getVotes());
                } else {
                    Integer vote = regs.get(candidate.getName());
                    regs.put(candidate.getName(), vote + candidate.getVotes());
                }

                line = br.readLine();
            }

            IO.println();
            IO.println("Contagem de votos:");
            for (String item : regs.keySet()) {
                IO.println(item + ": " + regs.get(item));
            }
        } catch (IOException e) {
            IO.println("Erro: " + e.getMessage());
        }

        sc.close();

    }
}

class Candidate {
    private String name;
    private Integer votes;

    public Candidate(String name, Integer votes) {
        this.name = name;
        this.votes = votes;
    }

    public String getName() {
        return name;
    }

    public Integer getVotes() {
        return votes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(name, candidate.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
