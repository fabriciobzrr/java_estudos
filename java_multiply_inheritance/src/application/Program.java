package application;

import model.entities.ComboDevice;

public class Program {
    public static void main (String[] args) {

        ComboDevice cd = new ComboDevice("2523230");
        cd.print("Fabricio");
        cd.processDoc("Fabricio");
        IO.println(cd.scan() + ": Fabricio");

    }
}
