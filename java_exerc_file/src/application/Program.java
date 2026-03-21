package application;

import model.entities.Product;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Program {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        IO.print("Informe o local do arquivo .csv: ");
        String sourceFileStr = sc.nextLine();

        File sourceFile = new File(sourceFileStr);
        String sourceFolderStr = sourceFile.getParent();

        if (sourceFolderStr != null) {
            File pathFile = new File(sourceFolderStr, "out");

            if (pathFile.mkdir()) {
                IO.println("Pasta criada!");
            } else {
                IO.println("Pasta já existe ou não pode ser criada!");
            }
        }

        String targetFileStr = sourceFolderStr + File.separator + "out" + File.separator + "summary.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {
            String itemCsv = br.readLine();

            while (itemCsv != null) {
                String[] fields = itemCsv.split(",");
                String name = fields[0];
                Double price = Double.parseDouble(fields[1]);
                Integer quantity = Integer.parseInt(fields[2]);

                list.add(new Product(name, price, quantity));
                itemCsv = br.readLine();
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
                for (Product item : list) {
                    bw.write(item.getName() + "," + String.format("%.2f", item.total()));
                    bw.newLine();
                }

                IO.println(targetFileStr + " criada com sucesso!");

            } catch (IOException e) {
                IO.println("Erro ao criar o arquivo: " + e.getMessage());
            }

        } catch (IOException e) {
            IO.println("Erro ao ler o arquivo: " + e.getMessage());
        }



        sc.close();
    }
}