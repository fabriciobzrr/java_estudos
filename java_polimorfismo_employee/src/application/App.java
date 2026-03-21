package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();
        
        IO.print("Digite o número de funcionários: ");
        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            IO.println("Funcionario #" + i + ":");
            IO.print("É terceirizado? (s/n) ");
            char answer = sc.next().charAt(0);
            IO.print("Nome do funcionário: ");
            sc.nextLine();
            String name = sc.nextLine();
            IO.print("Horas trabalhadas: ");
            int hours = sc.nextInt();
            IO.print("Valor pago por hora: ");
            double valuePerHour = sc.nextDouble();

            if (answer != 'n') {
                IO.print("Custos adicionais: ");
                double additionalCharge = sc.nextDouble();
                Employee emp = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
                list.add(emp);
            } else {
                Employee emp = new Employee(name, hours, valuePerHour);
                list.add(emp);
            }
        }
        IO.println();
        IO.println("----------------------------------------------------------------------------------------");
        IO.println("Lista de Pagamentos: ");
        IO.println();
        for (Employee emp : list) {
            IO.println(emp);
            IO.println();
        }
        IO.println("----------------------------------------------------------------------------------------");
        sc.close();
    }
}
