package ro.ulbs.proiectaresoftware.students.strategy;

import ro.ulbs.proiectaresoftware.students.Student;
import java.util.List;

public class StudentiInConsola implements IStudentiExport {

    @Override
    public void doExport(List<Student> studenti) {
        System.out.println("=== Export in Consola ===");
        System.out.printf("%6s %10s %12s %12s %6s%n",
                "NrMat", "Prenume", "Nume", "Formatie", "Nota");
        System.out.println("-".repeat(52));
        studenti.forEach(System.out::println);
        System.out.println("Total: " + studenti.size() + " studenti");
    }
}