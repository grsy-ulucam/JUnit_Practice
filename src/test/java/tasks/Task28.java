package tasks;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class Task28 {

    public static void main(String[] args) throws IOException {

        String path="src/test/java/resources/excelfile.xlsx";
        FileInputStream fileInputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sheet= workbook.getSheetAt(0);
        Row row= sheet.getRow(0);
        Cell cell= row.getCell(0);
        System.out.println("Cell1=  "+cell.toString().toLowerCase());
        Sheet sheet1= workbook.getSheetAt(0);
        Row row1= sheet.getRow(1);
        Cell cell1= row.getCell(1);
        System.out.println("Cell2=  "+cell1.toString().toLowerCase());

    }
}
