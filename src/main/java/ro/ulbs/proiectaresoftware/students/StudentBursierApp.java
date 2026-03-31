package ro.ulbs.proiectaresoftware.students;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class StudentBursierApp {

    public static void main(String[] args) throws IOException {


        List<StudentBursier> bursieri = new ArrayList<>();
        bursieri.add(new StudentBursier(1025, "Andrei",   "Popa",     "ISM141/2", 8.70, 725.50));
        bursieri.add(new StudentBursier(1024, "Ioan",     "Mihalcea", "ISM141/1", 9.80, 801.10));
        bursieri.add(new StudentBursier(1026, "Anamaria", "Prodan",   "TI131/1",  8.90, 745.50));
        bursieri.add(new StudentBursier(1029, "Bianca",   "Popescu",  "TI131/1",  9.10, 780.80));


        System.out.println("=== Bursieri ===");
        for (StudentBursier sb : bursieri) {
            System.out.println(sb);
        }

        writeToFile("bursieri_out.txt", bursieri);
        System.out.println("\n Salvat in bursieri_out.txt");
    }


    public static void writeToFile(String filename,
                                   Collection<? extends Student> studenti)
            throws IOException {
        StringBuilder sb = new StringBuilder();
        for (Student s : studenti) {
            sb.append(s.toString()).append("\n");
        }
        Files.writeString(Path.of(filename), sb.toString());
    }
}