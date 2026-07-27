package aplicacao;

import dominio.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Programa {
    public static void main(String[] args) {
//        List<Pessoa> pessoas = new ArrayList<>();
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Deseja registrar uma pessoa no banco? (S/N) ");
//        System.out.print("Opção: ");
//        String opcao = sc.next().toUpperCase();
//
//        if (!opcao.equals("S") && !opcao.equals("N")) {
//            System.out.println("Opção invalida!");
//            return;
//        }
//
//        do {
//            if (Objects.equals(opcao, "N")) {
//                break;
//            }
//
//            System.out.print("Nome: ");
//            String nome = sc.next();
//
//            System.out.print("Email: ");
//            String email = sc.next();
//
//            Pessoa pessoa = new Pessoa(null, nome, email);
//            pessoas.add(pessoa);
//
//            System.out.println("Deseja registrar uma pessoa no banco? (S/N) ");
//            opcao = sc.next().toUpperCase();
//        } while (true);
//
//        if (pessoas.isEmpty()) {
//            System.out.println("Nenhuma pessoa cadastrada!");
//            return;
//        }

        // É a fábrica de EntityManager
        // Persistence - classe utilitária usada para criar EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");
        // Conversa com o banco de dados
        EntityManager em = emf.createEntityManager();
        // Gerencia transações no banco de dados
        EntityTransaction et = em.getTransaction();

        Pessoa p1 = em.find(Pessoa.class, 52);

        et.begin();
        em.remove(p1);
        et.commit();

        System.out.println(p1);

        em.close();
        emf.close();

//        pessoas.forEach(pessoa -> {
//            et.begin();
//            em.persist(pessoa);
//            et.commit();
//        });

    }
}