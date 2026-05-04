package ro.ulbs.proiectaresoftware.lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.*;

public class AppLab8 {

    public static void main(String[] args) throws Exception {

        String inputFile   = "laborator8_input.xlsx";
        String outputFile2 = "laborator8_output2.xlsx";
        String outputFile3 = "laborator8_output3.xlsx";


        System.out.println("=== 8.5.1 Citire fisier ===");
        citesteSiAfiseaza(inputFile);


        System.out.println("\n=== 8.5.2 Generare output2 ===");
        scrieOutput2(inputFile, outputFile2);
        System.out.println("Generat: " + outputFile2);

        System.out.println("\n=== 8.5.3 Generare output3 ===");
        scrieOutput3(inputFile, outputFile3);
        System.out.println("Generat: " + outputFile3);
    }

    static void citesteSiAfiseaza(String fileName) throws Exception {

        try (FileInputStream fis = new FileInputStream(fileName);
             Workbook workbook   = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                StringBuilder sb = new StringBuilder();

                for (Cell cell : row) {

                    switch (cell.getCellType()) {
                        case STRING:
                            sb.append(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            sb.append(cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            sb.append(cell.getBooleanCellValue());
                            break;
                        case FORMULA:
                            sb.append(cell.getCellFormula());
                            break;
                        default:
                            sb.append("N/A");
                    }
                    sb.append("\t");
                }
                System.out.println(sb);
            }
        }
    }


    static void scrieOutput2(String inputFile, String outputFile) throws Exception {

        try (FileInputStream fis = new FileInputStream(inputFile);
             Workbook inputWb    = new XSSFWorkbook(fis)) {

            Sheet inputSheet = inputWb.getSheetAt(0);
            XSSFWorkbook outputWb = new XSSFWorkbook();
            XSSFSheet outputSheet = outputWb.createSheet("Sheet1");

            for (Row inputRow : inputSheet) {
                Row outputRow = outputSheet.createRow(inputRow.getRowNum());
                int lastCol   = 0;


                for (Cell inputCell : inputRow) {
                    Cell outputCell = outputRow.createCell(inputCell.getColumnIndex());
                    lastCol = inputCell.getColumnIndex();

                    switch (inputCell.getCellType()) {
                        case STRING:
                            outputCell.setCellValue(inputCell.getStringCellValue());
                            break;
                        case NUMERIC:
                            outputCell.setCellValue(inputCell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            outputCell.setCellValue(inputCell.getBooleanCellValue());
                            break;
                        default:
                            outputCell.setCellValue("");
                    }
                }


                int newColIndex = lastCol + 1;
                Cell mediaCell  = outputRow.createCell(newColIndex);


                if (inputRow.getRowNum() == 0) {
                    mediaCell.setCellValue("Medie");
                } else {

                    double suma  = 0;
                    int nrColoane = 3;
                    for (int i = lastCol - nrColoane + 1; i <= lastCol; i++) {
                        Cell c = inputRow.getCell(i);
                        if (c != null && c.getCellType() == CellType.NUMERIC) {
                            suma += c.getNumericCellValue();
                        }
                    }
                    double media = suma / nrColoane;
                    mediaCell.setCellValue(Math.round(media * 100.0) / 100.0);
                }
            }


            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                outputWb.write(fos);
            }
            outputWb.close();
        }
    }




    static void scrieOutput3(String inputFile, String outputFile) throws Exception {

        try (FileInputStream fis = new FileInputStream(inputFile);
             Workbook inputWb    = new XSSFWorkbook(fis)) {

            Sheet inputSheet  = inputWb.getSheetAt(0);
            XSSFWorkbook outputWb = new XSSFWorkbook();
            XSSFSheet outputSheet = outputWb.createSheet("Sheet1");


            String colStart = "D";
            String colEnd   = "F";
            for (Row inputRow : inputSheet) {
                Row outputRow = outputSheet.createRow(inputRow.getRowNum());
                int lastCol   = 0;


                for (Cell inputCell : inputRow) {
                    Cell outputCell = outputRow.createCell(inputCell.getColumnIndex());
                    lastCol = inputCell.getColumnIndex();

                    switch (inputCell.getCellType()) {
                        case STRING:
                            outputCell.setCellValue(inputCell.getStringCellValue());
                            break;
                        case NUMERIC:
                            outputCell.setCellValue(inputCell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            outputCell.setCellValue(inputCell.getBooleanCellValue());
                            break;
                        default:
                            outputCell.setCellValue("");
                    }
                }


                int newColIndex = lastCol + 1;
                Cell mediaCell  = outputRow.createCell(newColIndex);


                int excelRow = inputRow.getRowNum() + 1;

                if (inputRow.getRowNum() == 0) {
                    mediaCell.setCellValue("Medie (formula)");
                } else {

                    String formula = "AVERAGE(" + colStart + excelRow
                            + ":" + colEnd + excelRow + ")";
                    mediaCell.setCellFormula(formula);
                }
            }


            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                outputWb.write(fos);
            }
            outputWb.close();
        }
    }
}