package application;

import entities.Cachorro;
import entities.Gato;
import entities.Mamifero;

public class App {
    public static void main(String[] args) throws Exception {
        Mamifero mamifero = new Mamifero();
        Cachorro cachorro = new Cachorro();
        Gato gato = new Gato();

        mamifero.emitirSom();
        gato.emitirSom();
        cachorro.emitirSom();

        // Upcasting
        Mamifero m1 = cachorro;
        Mamifero m2 = new Cachorro();
        Mamifero m3 = new Gato();

        // Downcasting
        Cachorro m4 = (Cachorro) m2;
        // m4.latir();

        if (m3 instanceof Cachorro) {
            Cachorro m5 = (Cachorro) m3; // Erro em tempo de execução
            IO.println("É cachorro!");
            m5.latir();
        }  else if (m3 instanceof Gato) {
            Gato m5 = (Gato) m3; 
            IO.println("É gato!");
            m5.miar();
        }

    }
}
