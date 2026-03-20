package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Product;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos produtos? ");
        int N = sc.nextInt();
        // Cria um vetor de N elementos passado acima pelo usuário.
        Product[] vect = new Product[N];

        // Vai ler os elementos do vetor e a cada ciclo do loop;
        // A cada iteração será armazenado nas variáveis name e price os valores que o usuário digitar.
        // Em seguida será instanciado um novo objeto passando name e price como argumentos.
        for (int i = 0; i < vect.length; i++) {
            System.out.print("Nome do produto: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Preço do produto: ");
            double price = sc.nextDouble();
            vect[i] = new Product(name, price);
        }

        // A cada iteração, a soma de todos os preços dos produtos serão somados a variável total.
        double total = 0;
        for (int i = 0; i < vect.length; i++) {
            total += vect[i].getPrice();
            System.out.println(vect[i]);
        }

        double media = total / vect.length;

        System.out.printf("Média: %.2f%n", media);

        sc.close();
    }
}
