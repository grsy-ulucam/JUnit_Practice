package tasks;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Task29 {
    //    Add the excel file on the resources folder.
//    Open the file.
//    Open the workbook using file input stream.
//    Open the first worksheet.
//    Go to first row.
//    Go to first cell on that first row and print.
//    Go to second cell on that first row and print.
//    Go to 2nd row first cell and assert if the data equal to Russia.
//    Go to 3rd row 2nd cell-chain the row and cell.
//    Find the number of used row.
//    Print country, area key value pairs as map object.
    @Test
    public void test01() throws IOException {
        String path = "src/test/java/resources/excelfile.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell row1cell1 = row.getCell(0);
        System.out.println("row1 cell1=  " + row1cell1);
        Cell row1cell2 = row.getCell(1);
        System.out.println("row1 cell2=  " + row1cell2);
        Row row2 = sheet.getRow(1);
        Cell row2cell1 = row2.getCell(0);
        Assert.assertEquals("Rusya", row2cell1.toString());
        Cell row3cell2 = sheet.getRow(2).getCell(1);
        System.out.println("row3 cell2= " + row3cell2);
        System.out.println(sheet.getPhysicalNumberOfRows());
        int totalRows = sheet.getPhysicalNumberOfRows();
        Map<String, String> countryAreas = new HashMap<>();
        for (int row1 = 1; row1 < totalRows; row1++) {
            String country = sheet.getRow(row1).getCell(0).toString();
            String area = sheet.getRow(row1).getCell(1).toString();
            countryAreas.put(country, area);
        }
        System.out.println(countryAreas);
    }

    @Test
    public void test02() throws IOException {

        String path = "src/test/java/resources/excelfile.xlsx";
        FileInputStream fis = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet2 = workbook.getSheetAt(1);
        Row row1 = sheet2.getRow(0);
        Cell row1cell3 = row1.createCell(2);
        sheet2.getRow(1).createCell(2).setCellValue("Rusya nin populasyonu");
        sheet2.getRow(2).createCell(2).setCellValue("Cin in populasyonu");
        sheet2.getRow(3).createCell(2).setCellValue("ABD nin populasyonu");
        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);
        fis.close();
        fos.close();
        workbook.close();

    }

}



