package ro.ulbs.proiectaresoftware.students.decorator;

import ro.ulbs.proiectaresoftware.students.Student;
import java.util.List;

// Interfața decorator — definește metoda de măsurare timp
public interface ITimeExecution {
    long executionTime(List<Student> studenti);
}