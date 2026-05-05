package ro.ulbs.proiectaresoftware.lab9;

import ro.ulbs.proiectaresoftware.students.Student;

import java.util.*;
import java.util.stream.*;

public class AppLab9Studenti {

    public static void main(String[] args) {


        List<Student> studentiCuNote = Arrays.asList(
                new Student(1025, "Andrei",   "Popa",     "ISM141/2", 8.70f),
                new Student(1024, "Ioan",     "Mihalcea", "ISM141/1", 10f),
                new Student(1026, "Anamaria", "Prodan",   "TI131/1",  8.90f),
                new Student(1029, "Bianca",   "Popescu",  "TI131/1",  10f),
                new Student(1029, "Maria",    "Pana",     "TI131/2",  4.10f),
                new Student(1029, "Gabriela", "Mohanu",   "TI131/2",  7.33f),
                new Student(1029, "Marius",   "Nasta",    "TI131/2",  3.20f),
                new Student(1029, "Marius",   "Nasta",    "TI131/1",  5.12f),
                new Student(1029, "Andrei",   "Dobrescu", "TI131/2",  2.22f)
        );


        System.out.println("=== Studenti cu nota 10 ===");
        studentiCuNote.stream()
                .filter(s -> s.getNota() == 10)
                .forEach(System.out::println);


        System.out.println("\n=== Studenti cu nota < 5 ===");
        studentiCuNote.stream()
                .filter(s -> s.getNota() < 5)
                .forEach(System.out::println);

         System.out.println("\n=== Lista dupa map (nota < 4 devine 4) ===");
        List<Student> listaCorectata = studentiCuNote.stream()
                .map(s -> {
                    if (s.getNota() < 4) {
                        // Creem un student nou cu nota 4 (imutabilitate!)
                        return new Student(
                                s.getNumarMatricol(),
                                s.getPrenume(),
                                s.getNume(),
                                s.getFormatieDeStudiu(),
                                4.0f
                        );
                    }
                    return s;
                })
                .collect(Collectors.toList());
        listaCorectata.forEach(System.out::println);


        double sumaNote = studentiCuNote.stream()
                .reduce(0.0,
                        (suma, s) -> suma + s.getNota(),
                        Double::sum);
        System.out.println("\n=== Suma notelor: " + sumaNote + " ===");

        double media = sumaNote / studentiCuNote.size();
        System.out.printf("=== Media notelor: %.2f ===%n", media);
    }
}