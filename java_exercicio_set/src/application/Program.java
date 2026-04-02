package application;

import java.util.*;

public class Program {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Course> students = new HashSet<>();
        List<String> courses = Arrays.asList("A", "B", "C");

        for (String course : courses) {
            IO.print("Quantidade de alunos matriculados no curso " + course + "? ");

            Integer numberStudents = sc.nextInt();
            for (int i = 0; i < numberStudents; i++) {
                IO.print("ID: ");
                Integer ids = sc.nextInt();
                students.add(new Course(ids));
            }
        }
        IO.println();
        IO.println("Total de estudantes: " + students.size());

        sc.close();
    }
}

class Course {
    private Integer id;

    public Course(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(id, course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}