package application;

import model.entities.Product;
import model.exception.BusinessException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main (String[] args) throws BusinessException {
        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        IO.print("Digite o caminho do arquivo: ");
        String path = sc.nextLine();

        File filePath = new File(path);

        if (!filePath.exists()) {
            throw new BusinessException("Arquivo não encontrado.");
        }

        IO.println("Processando leitura do arquivo...");

        String filePathDirectory = filePath.getAbsoluteFile().getParent();

        IO.print("Digite o nome da pasta onde será salvo o arquivo: ");
        String pathName = sc.nextLine();

        File newOutPutDir = new File(filePathDirectory, pathName);

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String itemCsv = br.readLine();
            while (itemCsv != null) {
                String[] item = itemCsv.split(",");
                String name = item[0];
                Double price = Double.parseDouble(item[1]);
                Integer quantity = Integer.parseInt(item[2]);

                products.add(new Product(name, price, quantity));
                itemCsv = br.readLine();
            }

            if (!newOutPutDir.exists()) {
                newOutPutDir.mkdir();
            }

            IO.print("Digite o nome do arquivo a ser salvo: ");
            String archiveName = sc.nextLine();
            String newOutPutFile = filePathDirectory + File.separator + pathName + File.separator + archiveName + ".csv";

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(newOutPutFile))) {
                double total = 0.0;
                for (Product product : products) {
                    total += product.subtotal();
                    bw.write(product.getName() + "," + String.format("%.2f", product.subtotal()) + "\n");
                }
                bw.write("TOTAL," + total + "\n");

                IO.println("Arquivo " + archiveName + ".csv" + " criado com sucesso!");
            } catch (IOException e) {
                IO.println("Erro ao criar o arquivo: " + e.getMessage());
            }

        } catch (IOException e) {
            IO.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        sc.close();
    }
}
