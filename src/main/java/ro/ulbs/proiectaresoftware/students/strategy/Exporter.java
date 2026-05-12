package ro.ulbs.proiectaresoftware.students.strategy;

import ro.ulbs.proiectaresoftware.students.Student;
import java.util.List;


public class Exporter {


    public void startExport(IStudentiExport strategyInstance,
                            List<Student> studenti) {
        strategyInstance.doExport(studenti);
    }


    public List<Student> startImport(IStudentiImport strategyInstance) {
        return strategyInstance.doImport();
    }
}