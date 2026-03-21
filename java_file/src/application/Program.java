package application;

import java.io.File;
import java.util.Scanner;

public class Program {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        IO.println("Diretório:");
        String txtCaminho = sc.nextLine();

        File caminho = new File(txtCaminho);

        File[] pastas = caminho.listFiles(File::isDirectory);
        File[] arquivos = caminho.listFiles(File::isFile);

        IO.println();
        IO.println("Lista de pastas:");
        for (File pasta : pastas) {
            IO.println(pasta);
        }

        IO.println();
        IO.println("Lista de Arquivos:");
        for (File arquivo : arquivos) {
            IO.println(arquivo);
        }

        IO.println();
        IO.print("Nome da pasta a criar:");
        String pastaNome = sc.nextLine();
        File nomePasta = new File(caminho + File.separator + pastaNome);
        if (nomePasta.mkdir()) {
            IO.println("Pasta " + nomePasta.getName() + " criada com sucesso!");
        } else {
            if (nomePasta.exists()) {
                IO.println("Pasta " + nomePasta.getName() + " já existe.");
            } else {
                IO.println("Erro ao tentar criar pasta " + nomePasta.getName() + "!");
            }
        }

        IO.println();
        IO.print("Nome da pasta a excluir: ");
        pastaNome = sc.nextLine();
        nomePasta = new File(caminho + File.separator + pastaNome);
        if (nomePasta.delete()) {
            IO.println("Pasta " + nomePasta.getName() + " excluida com sucesso!");
        } else {
            IO.println("Pasta " + nomePasta.getName() + " não existe.");
        }

        sc.close();
    }
}
