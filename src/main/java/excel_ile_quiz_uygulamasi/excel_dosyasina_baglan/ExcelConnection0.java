package excel_ile_quiz_uygulamasi.excel_dosyasina_baglan;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelConnection0 {
    static int satirSayisi;
    static XSSFSheet sheet0;
    static XSSFSheet sheet1;
    static XSSFSheet sheet2;
    static Row row;
    static FileInputStream file;
    static XSSFWorkbook workbook;

    public void connect() throws IOException {
        file = new FileInputStream("src/main/java/excel_ile_quiz_uygulamasi/resources/proje_bilgileri.xlsx");
        workbook = new XSSFWorkbook(file);
        sheet0 = workbook.getSheetAt(0);
        sheet1 = workbook.getSheetAt(1);
        sheet2 = workbook.getSheetAt(2);
        satirSayisi = sheet1.getLastRowNum();
        System.out.println(satirSayisi);
    }

    public void disconnect() throws IOException {
        file.close();
        FileOutputStream outFile = new FileOutputStream("src/main/java/excel_ile_quiz_uygulamasi/resources/proje_bilgileri.xlsx");
        workbook.write(outFile);
        outFile.close();
    }

    public int getNumberOfRows() {
        return satirSayisi;
    }

    public XSSFSheet getSheet0() {
        return sheet0;
    }

    public XSSFSheet getSheet1() {
        return sheet1;
    }

    public XSSFSheet getSheet2() {
        return sheet2;
    }

    public Row getRow() {
        return row;
    }

    public FileInputStream getFile() {
        return file;
    }

    public XSSFWorkbook getWorkbook() {
        return workbook;
    }
}
