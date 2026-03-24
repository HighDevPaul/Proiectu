package ro.ulbs.proiectaresoftware.lab4;

import ro.ulbs.proiectaresoftware.students.Student;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class StudentMapApp {

    public static void main(String[] args) throws IOException {


        List<String> lines = Files.readAllLines(Path.of("C:\\Users\\Paul\\IdeaProjects\\Proiectu\\src\\main\\java\\ro\\ulbs\\proiectaresoftware\\lab4\\studenti_in.txt"));
        HashMap<Integer, Student> studentiMap = new HashMap<>();

        for (String line : lines) {
            String[] parts  = line.split(",");
            int    nr       = Integer.parseInt(parts[0].trim());
            String prenume  = parts[1].trim();
            String nume     = parts[2].trim();
            String formatie = parts[3].trim();

            studentiMap.put(nr, new Student(nr, prenume, nume, formatie));
        }


        System.out.println("=== Studenti cititi ===");
        for (Student s : studentiMap.values()) {
            System.out.println(s);
        }


        List<String> noteLines = Files.readAllLines(Path.of("C:\\Users\\Paul\\IdeaProjects\\Proiectu\\src\\main\\java\\ro\\ulbs\\proiectaresoftware\\lab4\\note_anon.txt"));

        for (String noteLine : noteLines) {
            String[] parts      = noteLine.split(",");
            int    nr           = Integer.parseInt(parts[0].trim());
            float  nota         = Float.parseFloat(parts[1].trim());


            Student student = studentiMap.get(nr);
            if (student != null) {
                student.setNota(nota);
            }
        }


        System.out.println("\n=== Studenti cu note ===");
        for (Student s : studentiMap.values()) {
            System.out.println(s);
        }

        // ── 4.5.3 Tema
        float notaBianca = gasesteNota("Bianca", "Popescu", studentiMap);
        float notaIoan   = gasesteNota("Ioan",   "Popa",    studentiMap);

        System.out.println("\n=== 4.5.3 Tema ===");
        System.out.println("Nota Bianca Popescu: " + notaBianca);
        System.out.println("Nota Ioan Popa: "      + notaIoan);
    }


    public static float gasesteNota(String prenume, String nume,
                                    HashMap<Integer, Student> studentiMap) {


        HashMap<String, Student> byName = new HashMap<>();
        for (Student s : studentiMap.values()) {
            String cheie = s.getPrenume() + "-" + s.getNume();
            byName.put(cheie, s);
        }


        String cheie  = prenume + "-" + nume;
        Student found = byName.get(cheie);

        if (found != null) {
            return found.getNota();
        }
        return 0.0f;
    }
}
