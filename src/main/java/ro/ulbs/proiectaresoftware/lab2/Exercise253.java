package ro.ulbs.proiectaresoftware.lab2;

import ro.ulbs.proiectaresoftware.students.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercise253 {


    public static boolean containsStudentFast(Set<Student> set, Student target) {
        return set.contains(target);
    }

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student(112, "Ioan",  "Popa",     "TI21/1"));
        students.add(new Student(112, "Maria", "Oprea",    "TI21/1"));
        students.add(new Student(120, "Alis",  "Popa",     "TI21/2"));
        students.add(new Student(122, "Mihai", "Vecerdea", "TI22/1"));
        students.add(new Student(122, "Eugen", "Uritescu", "TI22/2"));


        Set<Student> studentSet = new HashSet<>(students);

        // b)
        Student cautareB = new Student(120, "Alis", "Popa", "TI21/2");
        System.out.println("b) Alis Popa TI21/2 există: " + containsStudentFast(studentSet, cautareB));

        // c)
        Student cautareC = new Student(112, "Maria", "Popa", "TI21/1");
        System.out.println("c) Maria Popa TI21/1 există: " + containsStudentFast(studentSet, cautareC));
    }
}