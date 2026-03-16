package ro.ulbs.proiectaresoftware.lab2;

import ro.ulbs.proiectaresoftware.students.Student;

import java.util.ArrayList;
import java.util.List;

public class Exercise252 {


    public static boolean containsStudent(List<Student> list, Student target) {
        for (Student s : list) {
            if (s.getPrenume().equals(target.getPrenume())
                    && s.getNume().equals(target.getNume())
                    && s.getFormatieDeStudiu().equals(target.getFormatieDeStudiu())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        // a)
        List<Student> students = new ArrayList<>();
        students.add(new Student(112, "Ioan",  "Popa",     "TI21/1"));
        students.add(new Student(112, "Maria", "Oprea",    "TI21/1"));
        students.add(new Student(120, "Alis",  "Popa",     "TI21/2"));
        students.add(new Student(122, "Mihai", "Vecerdea", "TI22/1"));
        students.add(new Student(122, "Eugen", "Uritescu", "TI22/2"));

        // Afișare
        System.out.println(String.format("%15s %10s %10s %10s",
                "numar matricol", "prenume", "nnume", "formatieDeStudiu"));
        for (Student s : students) {
            System.out.println(s);
        }

        // b)
        Student cautareB = new Student(120, "Alis", "Popa", "TI21/2");
        boolean existaB = containsStudent(students, cautareB);
        System.out.println("\nb) Studentul Alis Popa TI21/2 există în listă: " + existaB);

        // c)
        Student cautareC = new Student(112, "Maria", "Popa", "TI21/1");
        boolean existaC = containsStudent(students, cautareC);
        System.out.println("c) Studentul Maria Popa TI21/1 există în listă: " + existaC);
    }
}
