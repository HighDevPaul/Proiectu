package ro.ulbs.proiectaresoftware.students.strategy;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import ro.ulbs.proiectaresoftware.students.Student;

import java.io.*;
import java.util.List;

public class StudentiInFisierXlsx implements IStudentiExport {

    private final String fileName;

    public StudentiInFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Studenti");

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

        // ── Auto-size coloane ─────────────────────────────────────────────
        for (int i = 0; i < 5; i++) sheet.autoSizeColumn(i);

        // ── Salvare ───────────────────────────────────────────────────────
        try (FileOutputStream fos = new FileOutputStream(fileName)) {
            workbook.write(fos);
            workbook.close();
            System.out.println(" Export XLSX reusit: " + fileName);
        } catch (IOException e) {
            System.out.println(" Eroare la scriere XLSX: " + e.getMessage());
        }
    }
}