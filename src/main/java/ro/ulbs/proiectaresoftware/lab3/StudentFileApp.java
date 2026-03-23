package ro.ulbs.proiectaresoftware.lab3;

import ro.ulbs.proiectaresoftware.students.Student;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class StudentFileApp {

    public static void main(String[] args) throws IOException {


        List<String> lines = Files.readAllLines(Path.of("C:\\Users\\Paul\\IdeaProjects\\Proiectu\\src\\main\\java\\ro\\ulbs\\proiectaresoftware\\lab3\\studenti_in.txt"));
        List<Student> students = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(",");
            int numarMatricol       = Integer.parseInt(parts[0].trim());
            String prenume          = parts[1].trim();
            String nume             = parts[2].trim();
            String formatieDeStudiu = parts[3].trim();
            students.add(new Student(numarMatricol, prenume, nume, formatieDeStudiu));
        }

        System.out.println(String.format("%15s %12s %12s %15s",
                "numarMatricol", "prenume", "nume", "formatieDeStudiu"));
        System.out.println("-".repeat(58));
        for (Student s : students) {
            System.out.println(s);
        }


        students.sort(Comparator.comparing(Student::getNume));


        StringBuilder sb = new StringBuilder();
        for (Student s : students) {
            sb.append(s.getNumarMatricol()).append(",")
                    .append(s.getPrenume()).append(",")
                    .append(s.getNume()).append(",")
                    .append(s.getFormatieDeStudiu()).append("\n");
        }
        Files.writeString(Path.of("C:\\Users\\Paul\\IdeaProjects\\Proiectu\\src\\main\\java\\ro\\ulbs\\proiectaresoftware\\lab3\\studenti_out.txt"), sb.toString());
        System.out.println("\n✅ Salvat sortat in studenti_out.txt");


        System.out.println("\nDupa sortare dupa nume:");
        System.out.println("-".repeat(58));
        for (Student s : students) {
            System.out.println(s);
        }


        students.sort(
                Comparator.comparing(Student::getFormatieDeStudiu)
                        .thenComparing(Student::getNume)
        );


        System.out.println("\nDupa sortare dupa formatieDeStudiu + nume:");
        System.out.println("-".repeat(58));
        for (Student s : students) {
            System.out.println(s);
        }


        StringBuilder sbSorted = new StringBuilder();
        for (Student s : students) {
            sbSorted.append(s.getNumarMatricol()).append(",")
                    .append(s.getPrenume()).append(",")
                    .append(s.getNume()).append(",")
                    .append(s.getFormatieDeStudiu()).append("\n");
        }
        Files.writeString(Path.of("C:\\Users\\Paul\\IdeaProjects\\Proiectu\\src\\main\\java\\ro\\ulbs\\proiectaresoftware\\lab3\\studenti_out_sorted.txt"), sbSorted.toString());
        System.out.println("✅ Salvat in studenti_out_sorted.txt");

    }
}