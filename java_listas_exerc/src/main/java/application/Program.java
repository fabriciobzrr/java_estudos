package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Employee;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees will be registered? ");
        int n = sc.nextInt();
        List<Employee> lista = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println();
            System.out.println("Employee " + (i + 1) + ":");
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary);
            lista.add(emp);
        }

        System.out.println();
        System.out.print("Enter the employee ID that will have salary increase: ");
        int id = sc.nextInt();
        // Executa a função para encontrar a posição de um funcionário pelo id.
        // Integer pos = posId(lista, id);

        // .stream() → converte a lista em um fluxo de elementos para processamento
        // Percorre a lista de empregados usando o Stream

        // .filter(...) → mantém apenas os elementos onde e.getId() == id
        // Filtra aquele cujo id é igual ao id informado

        // .findFirst() → pega o primeiro resultado encontrado (retorna um Optional<Employee>)
        // retorna o primeiro encontrado.

        // .orElse(null) → se nenhum funcionário for encontrado, retorna null
        // Caso nenhum funcionário tenha esse id, retorna null.
        Employee emp = lista.stream().filter(e -> e.getId() == id).findFirst().orElse(null);

        System.out.println();

        if (emp == null) {
            System.out.println("Employee " + id + " does not exist");
        } else {
            System.out.print("Enter the percentage: ");
            Double percentage = sc.nextDouble();
            // Pega a posição do ID encontrado e aplica a porcentagem ao salário
            emp.increaseSalary(percentage);
        }

        // Imprime a lista de empregados atualizada
        System.out.println();
        System.out.println("List of employee:");
        for (Employee e : lista) {
            System.out.println(e);
        }
        sc.close();
    }

    // Função que encontra o indice do empregado, se não encontrar, retorna nulo.
    public static int posId(List<Employee> lista, int id) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
