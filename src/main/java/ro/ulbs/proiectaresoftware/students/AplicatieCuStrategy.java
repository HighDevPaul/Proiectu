package ro.ulbs.proiectaresoftware.students;

import ro.ulbs.proiectaresoftware.students.strategy.*;

import java.util.*;

public class AplicatieCuStrategy {

    public static void main(String[] args) {


        List<Student> studenti = Arrays.asList(
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

        Exporter exporter = new Exporter();

        // ── a) Export în consolă ──────────────────────────────────────────
        System.out.println("\n--- a) Strategy: Consola ---");
        IStudentiExport strategyConsole = new StudentiInConsola();
        exporter.startExport(strategyConsole, studenti);

        // ── b) Export în fișier TXT ───────────────────────────────────────
        System.out.println("\n--- b) Strategy: Fisier TXT ---");
        String txtFile = "studentiStrategyText.txt";
        StudentiInFisierText strategyFisierText = new StudentiInFisierText(txtFile);
        exporter.startExport(strategyFisierText, studenti);

        // ── c) Export în fișier XLSX ──────────────────────────────────────
        System.out.println("\n--- c) Strategy: Fisier XLSX ---");
        String xlsxFile = "studentiStrategyExcel.xlsx";
        StudentiInFisierXlsx strategyFisierExcel = new StudentiInFisierXlsx(xlsxFile);
        exporter.startExport(strategyFisierExcel, studenti);

        // ── d) Import din fișier TXT ──────────────────────────────────────
        System.out.println("\n--- d) Strategy: Import din TXT ---");
        StudentiDinFisierText strategyImportTxt = new StudentiDinFisierText(txtFile);
        List<Student> dinTxt = exporter.startImport(strategyImportTxt);
        System.out.println("Studenti cititi din TXT:");
        dinTxt.forEach(System.out::println);

        // ── e) Import din fișier XLSX ─────────────────────────────────────
        System.out.println("\n--- e) Strategy: Import din XLSX ---");
        StudentiDinFisierXlsx strategyImportXlsx = new StudentiDinFisierXlsx(xlsxFile);
        List<Student> dinXlsx = exporter.startImport(strategyImportXlsx);
        System.out.println("Studenti cititi din XLSX:");
        dinXlsx.forEach(System.out::println);
    }
}