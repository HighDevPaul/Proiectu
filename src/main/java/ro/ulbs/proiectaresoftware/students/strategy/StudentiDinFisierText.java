package ro.ulbs.proiectaresoftware.students.strategy;

import ro.ulbs.proiectaresoftware.students.Student;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class StudentiDinFisierText implements IStudentiImport {

    private final String fileName;

    public StudentiDinFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Student> doImport() {
        List<Student> studenti = new ArrayList<>();

        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));


            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line.isBlank()) continue;

                String[] parts = line.split(",");
                int    nr       = Integer.parseInt(parts[0].trim());
                String prenume  = parts[1].trim();
                String nume     = parts[2].trim();
                String formatie = parts[3].trim();
                float  nota     = Float.parseFloat(parts[4].trim());

                studenti.add(new Student(nr, prenume, nume, formatie, nota));
            }
            System.out.println(" Import TXT reusit: "
                    + studenti.size() + " studenti din " + fileName);

        } catch (IOException e) {
            System.out.println(" Eroare la citire TXT: " + e.getMessage());
        }
        return studenti;
    }
}