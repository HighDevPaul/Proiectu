package ro.ulbs.proiectaresoftware.students;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.*;

public class StudentXlsApp {

    public static void main(String[] args) throws Exception {


        Set<Student> studenti = new HashSet<>();
        studenti.add(new Student(1024, "Ioan",     "Mihalcea", "ISM141/1", 9.80f));
        studenti.add(new Student(1025, "Andrei",   "Popa",     "ISM141/2", 8.70f));
        studenti.add(new Student(1026, "Anamaria", "Prodan",   "TI131/1",  8.90f));
        studenti.add(new Student(1027, "Paul",     "Mohanu",   "TI132/1",  5.40f));
        studenti.add(new Student(1028, "Mihai",    "Ionescu",  "TI132/2",  6.20f));
        studenti.add(new Student(1029, "Bianca",   "Popescu",  "TI131/1",  9.10f));

        String xlsFileName = "laborator8_students.xlsx";
        writeToXls(studenti, xlsFileName);
        System.out.println(" Salvat in " + xlsFileName);


        List<Student> studentsFromXls = readFromXls(xlsFileName);
        System.out.println("\nStudenti cititi din xlsx:");
        for (Student st : studentsFromXls) {
            System.out.println(st);
        }
    }




    static void writeToXls(Set<Student> studenti, String fileName) throws Exception {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet       = workbook.createSheet("Studenti");


        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("numarMatricol");
        header.createCell(1).setCellValue("prenume");
        header.createCell(2).setCellValue("nume");
        header.createCell(3).setCellValue("formatieDeStudiu");
        header.createCell(4).setCellValue("nota");


        int rowNum = 1;
        for (Student s : studenti) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(s.getNumarMatricol());
            row.createCell(1).setCellValue(s.getPrenume());
            row.createCell(2).setCellValue(s.getNume());
            row.createCell(3).setCellValue(s.getFormatieDeStudiu());
            row.createCell(4).setCellValue(s.getNota());
        }


        for (int i = 0; i < 5; i++) {
            sheet.autoSizeColumn(i);
        }


        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            workbook.write(fos);
        }
        workbook.close();
    }



    static List<Student> readFromXls(String fileName) throws Exception {

        List<Student> result = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(fileName);
             Workbook workbook   = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {

                if (row.getRowNum() == 0) continue;

                int    numarMatricol    = (int) row.getCell(0).getNumericCellValue();
                String prenume          = row.getCell(1).getStringCellValue();
                String nume             = row.getCell(2).getStringCellValue();
                String formatieDeStudiu = row.getCell(3).getStringCellValue();
                float  nota             = (float) row.getCell(4).getNumericCellValue();

                result.add(new Student(numarMatricol, prenume,
                        nume, formatieDeStudiu, nota));
            }
        }
        return result;
    }
}