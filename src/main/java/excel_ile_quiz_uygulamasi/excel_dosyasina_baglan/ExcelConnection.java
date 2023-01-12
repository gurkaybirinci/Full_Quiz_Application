package excel_ile_quiz_uygulamasi.excel_dosyasina_baglan;

import java.io.*;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConnection {
    private FileInputStream file;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelConnection() {
        try {
            file = new FileInputStream("src/main/java/excel_ile_quiz_uygulamasi/resources/user_info.xlsx");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void connect() {
        try {
            workbook = new XSSFWorkbook(file);
            sheet = workbook.getSheetAt(0);
        } catch (EncryptedDocumentException | IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumberOfRows() {
        return sheet.getPhysicalNumberOfRows();
    }

    public Sheet getSheet() {
        return sheet;
    }

    public void close() {
        try {
            FileOutputStream outFile = new FileOutputStream("src/main/java/excel_ile_quiz_uygulamasi/resources/user_info.xlsx");
            workbook.write(outFile);
            outFile.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}