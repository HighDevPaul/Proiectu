package ro.ulbs.proiectaresoftware.students.decorator;

import ro.ulbs.proiectaresoftware.students.Student;
import ro.ulbs.proiectaresoftware.students.strategy.IStudentiExport;

import java.util.List;

// Concrete Decorator — extinde TimeExecution
// Adaugă afișarea timpului în consolă
public class TimeExecutionDecorator extends TimeExecution {

    private List<Student> studenti;

    public TimeExecutionDecorator(IStudentiExport exporter,
                                  List<Student> studenti) {
        super(exporter);
        this.studenti = studenti;
    }

    @Override
    public long executionTime(List<Student> studenti) {
        // Apelăm metoda din clasa abstractă care măsoară timpul
        long execTime = super.executionTime(studenti);
        return execTime;
    }
}