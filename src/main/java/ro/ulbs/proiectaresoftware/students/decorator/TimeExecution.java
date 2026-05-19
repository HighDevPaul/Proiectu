package ro.ulbs.proiectaresoftware.students.decorator;

import ro.ulbs.proiectaresoftware.students.Student;
import ro.ulbs.proiectaresoftware.students.strategy.IStudentiExport;

import java.util.List;

// Abstract Decorator — implementează ITimeExecution
// Primește un IStudentiExport și adaugă măsurarea timpului
public abstract class TimeExecution implements ITimeExecution {

    // Referința la strategia de export (componenta decorată)
    protected IStudentiExport exporter;

    public TimeExecution(IStudentiExport exporter) {
        this.exporter = exporter;
    }

    // Implementare de bază — măsoară timpul de execuție al exportului
    @Override
    public long executionTime(List<Student> studenti) {
        long startTime = System.currentTimeMillis();

        // Apelăm exportul fără să îl modificăm
        exporter.doExport(studenti);

        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }
}