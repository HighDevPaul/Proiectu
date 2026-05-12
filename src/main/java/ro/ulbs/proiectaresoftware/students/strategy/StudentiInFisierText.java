package ro.ulbs.proiectaresoftware.students.strategy;

import ro.ulbs.proiectaresoftware.students.Student;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class StudentiInFisierText implements IStudentiExport {

    private final String fileName;

    public StudentiInFisierText(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        StringBuilder sb = new StringBuilder();

        // Header
        sb.append("numarMatricol,prenume,nume,formatieDeStudiu,nota\n");

        // Date CSV
        for (Student s : studenti) {
            sb.append(s.getNumarMatricol()).append(",")
                    .append(s.getPrenume()).append(",")
                    .append(s.getNume()).append(",")
                    .append(s.getFormatieDeStudiu()).append(",")
                    .append(s.getNota()).append("\n");
        }

        try {
            Files.writeString(Path.of(fileName), sb.toString());
            System.out.println(" Export TXT reusit: " + fileName);
        } catch (IOException e) {
            System.out.println(" Eroare la scriere TXT: " + e.getMessage());
        }
    }
}