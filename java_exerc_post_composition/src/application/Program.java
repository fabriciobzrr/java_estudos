package application;

import entities.Comment;
import entities.Post;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        // Post 1
        LocalDateTime moment1 = LocalDateTime.parse("07/03/2026 16:17:05", dtf);
        String title1 = "Traveling to New Zeland";
        String content1 = "I'm going to visit this wonderful country!";
        Integer likes1 = 12;
        Comment comment1 = new Comment("Have a nice trip!");
        Comment comment2 = new Comment("Wow that's awesome!");
        Post post1 = new Post(moment1, title1, content1, likes1);
        post1.addComment(comment1);
        post1.addComment(comment2);

        // Post 2
        LocalDateTime moment2 = LocalDateTime.parse("06/03/2026 21:47:55", dtf);
        String title2 = "Good night guys";
        String content2 = "See you tomorrow";
        Integer likes2 = 5;
        Comment comment3 = new Comment("Good night!");
        Comment comment4 = new Comment("May the father of understanding guide us!");
        Post post2 = new Post(moment2, title2, content2, likes2);
        post2.addComment(comment3);
        post2.addComment(comment4);

        System.out.println(post1);
        System.out.println(post2);

        sc.close();
    }
}
