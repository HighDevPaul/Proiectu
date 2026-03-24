package ro.ulbs.proiectaresoftware.lab4;

import ro.ulbs.proiectaresoftware.students.Student;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class StudentMapApp {

    public static void main(String[] args) throws IOException {

        // ── Citire studenti din fisier → HashMap<numarMatricol, Student> ──
        // Cheia e numarMatricol pentru acces O(1) la alocare note
        List<String> lines = Files.readAllLines(Path.of("C:\\Users\\Paul\\IdeaProjects\\Proiectu\\src\\main\\java\\ro\\ulbs\\proiectaresoftware\\lab4\\studenti_in.txt"));
        HashMap<Integer, Student> studentiMap = new HashMap<>();

        for (String line : lines) {
            String[] parts = line.split(",");
            int nr = Integer.parseInt(parts[0].trim());
            String prenume = parts[1].trim();
            String nume = parts[2].trim();
            String formatie = parts[3].trim();

            studentiMap.put(nr, new Student(nr, prenume, nume, formatie));
        }

        // ── Afișare studenți citiți ───────────────────────────────────────
        System.out.println("=== Studenti cititi ===");
        for (Student s : studentiMap.values()) {
            System.out.println(s);
        }

        // ── Citire note_anon.txt și alocare note O(1) ─────────────────────
        List<String> noteLines = Files.readAllLines(Path.of("C:\\Users\\Paul\\IdeaProjects\\Proiectu\\src\\main\\java\\ro\\ulbs\\proiectaresoftware\\lab4\\note_anon.txt"));

        for (String noteLine : noteLines) {
            String[] parts = noteLine.split(",");
            int nr = Integer.parseInt(parts[0].trim());
            float nota = Float.parseFloat(parts[1].trim());

            // O(1) - get direct din HashMap după cheia numarMatricol
            Student student = studentiMap.get(nr);
            if (student != null) {
                student.setNota(nota);
            }
        }
        // ── Afișare studenți cu note ──────────────────────────────────────
        System.out.println("\n=== Studenti cu note ===");
        for (Student s : studentiMap.values()) {
            System.out.println(s);
        }
    }
}