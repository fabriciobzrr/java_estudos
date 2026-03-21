package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        IO.print("Entre com o nome do departamento: ");
        String departmentName = sc.nextLine().toUpperCase();

        Department department = new Department(departmentName);

        IO.println();
        IO.println("Entre com os dados do trabalhador:");
        IO.print("Nome: ");
        String workerName = sc.nextLine().toUpperCase();
        IO.print("Nível: ");
        WorkerLevel workerLevel = WorkerLevel.valueOf(sc.nextLine().toUpperCase());
        IO.print("Salário Base: ");
        double baseSalary = sc.nextDouble();
        Worker newWorker = new Worker(workerName, workerLevel, baseSalary, department);

        IO.println();
        IO.print("Deseja registrar um contrato? (s/n) ");
        char answer = sc.next().charAt(0);

        while (answer != 's' && answer != 'n') {
            IO.println("Opção inválida!");
            IO.println("Deseja registrar um contrato? (s/n) ");
            answer = sc.next().charAt(0);
        }

        int count = 0;
        while (answer == 's') {
            count++;
            IO.println();
            IO.println("Entre com os dados do contrato #" + count + ":");
            IO.print("Data do contrato (DD/MM/YYYY): ");
            LocalDate contractDate = LocalDate.parse(sc.next(), dtf);
            IO.print("Valor por hora: ");
            double hours = sc.nextDouble();
            IO.print("Duração do contrato: ");
            int duration = sc.nextInt();

            HourContract contract = new HourContract(contractDate, hours, duration);
            newWorker.addContract(contract);

            IO.print("Deseja registrar mais contratos? (s/n) ");
            answer =  sc.next().charAt(0);
        }

        IO.println();
        IO.print("Entre com o ano e mês para calcular o ganho (MM/YYYY): ");
        String monthAndYear = sc.next();
        int contractMonth = Integer.parseInt(monthAndYear.substring(0, 2));
        int contractYear = Integer.parseInt(monthAndYear.substring(3));

        IO.println();
        IO.println("Contratos localizados do período de " + monthAndYear + ":");
        IO.println("Nome: " + newWorker.getName());
        IO.println("Departamento: " + newWorker.getDepartment().getName());
        IO.println("Ganhos para " + monthAndYear + ": " + String.format("%.2f", newWorker.income(contractYear, contractMonth)));

        sc.close();
    }
}
