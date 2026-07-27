package aplicacao;

import dominio.Pessoa;

public class Programa {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa(1, "Roger Santos", "roger@m.c");
        Pessoa pessoa2 = new Pessoa(2, "Maria Fantos", "maria@m.c");
        Pessoa pessoa3 = new Pessoa(3, "Nart Xantos", "nart@m.c");

        System.out.println("Pessoa " + pessoa1.getId() + ": " + pessoa1);
        System.out.println("Pessoa " + pessoa2.getId() + ": " + pessoa2);
        System.out.println("Pessoa " + pessoa3.getId() + ": " + pessoa3);
    }
}