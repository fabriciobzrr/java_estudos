package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        IO.print("Caminho do arquivo: ");
        String path = sc.nextLine();

        Map<String, Integer> reg = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                Integer quantity = Integer.parseInt(fields[1]);

                // o método containsKey() sempre irá retornar false pois não existe nenhuma ocorrência (chave, valor)
//                IO.println(reg.containsKey(name));

                // então o if irá testar: se não existe a chave name no Map então ele insere usando o metodo .put
                if (!reg.containsKey(name)) {
                    reg.put(name, quantity);
                // caso a chave 'name' já exista ele irá pegar o valor que já existe na chave 'name' e irá adicionar na
                // adicionar na variável votes, e, depois irá somar com o valor da variável quantity que corresponde a
                // iteração (loop) atual
                } else {
                    int votes = reg.get(name);
                    reg.put(name, votes + quantity);
                }

                line = br.readLine();
            }

            for (String name : reg.keySet()) {
                Integer value = reg.get(name);
                IO.println(name + ": " + value);
            }

        } catch (IOException e) {
            IO.println("Erro: " + e.getMessage());
        }

        sc.close();
    }
}
