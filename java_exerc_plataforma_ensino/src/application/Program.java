package application;

import entities.Lesson;
import entities.Task;
import entities.Video;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Lesson> list = new ArrayList<>();
        IO.print("Quantas aulas tem o curso? ");
        int number = sc.nextInt();

        for (int i = 1; i <= number; i++) {
            IO.println();
            IO.println("Dados da " + i + "ª aula:");
            IO.print("Conteúdo ou tarefa? (c/t) ");
            char answer = sc.next().charAt(0);
            if (answer == 'c') {
                IO.print("Título: ");
                sc.nextLine();
                String title = sc.nextLine();
                IO.print("URL do vídeo: ");
                String url = sc.nextLine();
                IO.print("Duração em segundos: ");
                int seconds = sc.nextInt();

                list.add(new Video(title, url, seconds));
            } else {
                IO.print("Título: ");
                sc.nextLine();
                String title = sc.nextLine();
                IO.print("Descrição: ");
                String description = sc.nextLine();
                IO.print("Quantidade de questões: ");
                int questionCount = sc.nextInt();

                list.add(new Task(title, description, questionCount));
            }
        }

        IO.println();
        int total = 0;
        for (Lesson lesson : list) {
            total += lesson.duration();
        }
        IO.print("Duração total do curso: " + total + " segundos.");


        sc.close();
    }
}
