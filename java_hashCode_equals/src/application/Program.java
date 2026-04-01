package application;

import model.entities.Client;

public class Program {
    public static void main (String[] args) {

        Client client1 = new Client("Fred", "fred@m.c");
        Client client2 = new Client("Fred", "fred@ms.c");

        String s1 = "AAA";
        String s2 = "AAA";

        System.out.println(s1 == s2); // true
        System.out.println(s1.equals(s2)); // true

        System.out.println(client1.equals(client2)); // false
        System.out.println(client1.hashCode());
        System.out.println(client2.hashCode());

    }
}
