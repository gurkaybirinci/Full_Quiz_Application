package excel_dosyasina_baglan;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.xmlbeans.impl.schema.SoapEncSchemaTypeSystem;

public class Main {
//    static boolean flagGiris = true;
    static boolean flagAd = true;
//    static boolean flagSifre = true;
    static int satirSayisi;
    static XSSFSheet sheet0;
    static XSSFSheet sheet1;
    static XSSFSheet sheet2;
    static int i = 0;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //Excel dosyasını okuma işlemi
        FileInputStream file = new FileInputStream("src/main/java/resources/proje_bilgileri.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        sheet0 = workbook.getSheetAt(0);
        sheet1 = workbook.getSheetAt(1);
        sheet2 = workbook.getSheetAt(2);
        satirSayisi = sheet1.getLastRowNum();
        System.out.println(satirSayisi);

//        int hucreSayisi = sheet.get

        // Bir hücrenin değerini değiştirme
//        Row row = sheet1.getRow(0);
//        row.getCell(0).setCellValue("Gürkay");
//        row.getCell(1).setCellValue("123456");
//        row.getCell(2).setCellValue("Şifre");
//
//        row = sheet.getRow(1);
//        row.getCell(0).setCellValue("Gürkay");
//        row.getCell(1).setCellValue("Birinci");
//        row.getCell(2).setCellValue("123456");
//
//        row = sheet.getRow(2);
//        row.getCell(0).setCellValue("Esra");
//        row.getCell(1).setCellValue("Birinci");
//        row.getCell(2).setCellValue("123456");
//
//        row = sheet.createRow(3);
//        row.createCell(0).setCellValue("Abidik");
//        row.createCell(1).setCellValue("Birinci");
//        row.createCell(2).setCellValue("123456");
//
//        row = sheet.createRow(4);
//        row.createCell(0).setCellValue("Kubidik");
//        row.createCell(1).setCellValue("Birinci");
//        row.createCell(2).setCellValue("123456");
//
//        row = sheet.createRow(5);
//        row.createCell(0).setCellValue("Mobidik");
//        row.createCell(1).setCellValue("Birinci");
//        row.createCell(2).setCellValue("123456");

        //Bütün satırları okuma
//        satirSayisi = sheet1.getLastRowNum()+1;
//        for (int i = 0; i < satirSayisi; i++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(sheet.getRow(i).getCell(j) + ", ");
//            }
//        }
//        boolean flagGiris = true;
//        boolean flagAd = true;
//        boolean flagSifre = true;

        Scanner input = new Scanner(System.in);
        System.out.println("\n...QUİZ UYGULAMASINA HOŞGELDİNİZ...\n");

        // Giriş ekranı: Sisteme giriş mi yapılacak yoksa kayıt mı olunacağı sorulur.
        while (flagAd){
            System.out.print("Ne yapmak istersiniz?\n\tGiriş yapmak için --> 1'e\n\tKayıt olmak için --> 2'ye\nbasınız: ");
            String ilkEkran = input.next();
            if (ilkEkran.equals("1")) {
                kullaniciAdiSor();
                sifreSor();
                break;
            }else if (ilkEkran.equals("2")){
                System.out.print("Kullanıcı Adı: ");
                String kullaniciAdi = input.next();
                sheet1.createRow(satirSayisi+1).createCell(0).setCellValue(kullaniciAdi);
                sheet2.createRow(satirSayisi+1).createCell(0).setCellValue(kullaniciAdi);
                System.out.print("Şifre: ");
                String sifre = input.next();
                sheet1.getRow(satirSayisi+1).createCell(1).setCellValue(sifre);
                break;
            }else {
                System.out.println("Hatalı giriş yaptınız. Tehrar deneyiniz.");
            }
        }
        flagAd = true;
        System.out.println(satirSayisi);
        System.out.println("\n______________________________\nSORULAR");
        for (int i = 0; i < satirSayisi; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(sheet1.getRow(i).getCell(j) + ", ");
            }
        }





        // Kullanıcı Girişi: Ad-Şifre doğrulaması yapılır

        int i = 0;
//        while (flagAd){
//            System.out.print("Adınızı giriniz: ");
//            String ad = input.next();
//            for (i = 0; i < satirSayisi; i++) {
//                if (ad.equals(sheet.getRow(i).getCell(0).getStringCellValue())) {
//                    flagAd = false;
//                    break;
//                }
//            }
//            if (flagAd){
//                System.out.println("Bu isim yok. Tekrar deneyiniz.");
//            }
//        }
//        while (flagSifre){
//            System.out.print("Şifrenizi giriniz: ");
//            String sifre = input.next();
//            if (sifre.equals(sheet.getRow(i).getCell(2).getStringCellValue())) {
//                System.out.println("Hoşgeldin " + sheet.getRow(i).getCell(0).getStringCellValue());
//                flagSifre = false;
//            } else {
//                System.out.println("Hatalı şifre girdiniz. Tekrar deneyiniz.");
//            }
//        }
//
//        System.out.println("\n______________________________\nSORULAR");


//        //Excel dosyasındaki bir hücrenin değerini okuma
//        Row row = sheet.getRow(0);
//        Cell cell = row.getCell(0);
//        System.out.println("Hücre değeri: " + cell.getStringCellValue());
//
//        //Excel dosyasına bir hücre değeri yazma
//        Row row2 = sheet.createRow(4);
//        Cell newCell = row2.createCell(0);
//        newCell.setCellValue("Yeni hücre değeri");
//        System.out.println("Hücre değeri: " + row2.getCell(0).getStringCellValue());
//
            //Excel dosyasını kaydetme işlemi
        file.close();
        FileOutputStream outFile = new FileOutputStream("src/main/java/resources/proje_bilgileri.xlsx");
        workbook.write(outFile);
        outFile.close();

    }


    public static void kullaniciAdiSor(){
        while (flagAd){
            System.out.print("Adınızı giriniz: ");
            String ad = input.next();
            for (i = 0; i < satirSayisi+1; i++) {
                if (ad.equals(sheet1.getRow(i).getCell(0).getStringCellValue())) {
                    flagAd = false;
                    break;
                }
            }
            if (flagAd){
                System.out.println("Bu isim yok. Tekrar deneyiniz.");
            }
        }
        flagAd=true;
    }

    public static void sifreSor(){
        while (flagAd){
            System.out.print("Şifrenizi giriniz: ");
            String sifre = input.next();
            if (sifre.equals(sheet1.getRow(i).getCell(1).getStringCellValue())) {
                System.out.println("Hoşgeldin " + sheet1.getRow(i).getCell(0).getStringCellValue());
                flagAd = false;
            } else {
                System.out.println("Hatalı şifre girdiniz. Tekrar deneyiniz.");
            }
        }
        flagAd = true;
    }

}
