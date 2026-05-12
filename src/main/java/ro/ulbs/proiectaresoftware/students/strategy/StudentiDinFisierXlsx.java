package ro.ulbs.proiectaresoftware.students.strategy;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ro.ulbs.proiectaresoftware.students.Student;

import java.io.*;
import java.util.*;

public class StudentiDinFisierXlsx implements IStudentiImport {

    private final String fileName;

    public StudentiDinFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Student> doImport() {
        List<Student> studenti = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(fileName);
             Workbook workbook   = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {

                if (row.getRowNum() == 0) continue;

                int    nr       = (int) row.getCell(0).getNumericCellValue();
                String prenume  = row.getCell(1).getStringCellValue();
                String nume     = row.getCell(2).getStringCellValue();
                String formatie = row.getCell(3).getStringCellValue();
                float  nota     = (float) row.getCell(4).getNumericCellValue();

                studenti.add(new Student(nr, prenume, nume, formatie, nota));
            }
            System.out.println(" Import XLSX reusit: "
                    + studenti.size() + " studenti din " + fileName);

        } catch (IOException e) {
            System.out.println(" Eroare la citire XLSX: " + e.getMessage());
        }
        return studenti;
    }
}