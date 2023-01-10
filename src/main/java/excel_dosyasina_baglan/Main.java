package excel_dosyasina_baglan;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {
    static boolean flag = true;
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

        // Kayıt Bilgileri bölümündeki (sheet1) varolan bir hücrenin değerini değiştirme
//        Row row = sheet1.getRow(Satır No Gir);
//        row.getCell(0).setCellValue("Yeni İsim Gir");
//        row.getCell(1).setCellValue("Yeni Şifre Gir");
//        row = sheet2.getRow(Yukardaki Satır No ile aynı noyu gir);
//        row.getCell(0).setCellValue("Yeni İsim Gir");


        // Kayıt Bilgileri bölümünde (sheet1) yeni bir satır ve hücre ekleyerek veri girme
//        row = sheet1.createRow(satirSayisi+1);
//        row.createCell(0).setCellValue("İsim Gir");
//        row.createCell(1).setCellValue("Şifre Gir");
//        row = sheet2.createRow(satirSayisi+1);
//        row.createCell(0).setCellValue("İsim Gir");


        // Quiz Sayfasına (sheet0) yeni bir soru ve cevapları girme
//        row = sheet0.createRow(satirSayisi+1);
//        row.createCell(0).setCellValue("Soru Metnini Gir");
//        row.createCell(1).setCellValue("a) Cevap1 Gir");
//        row.createCell(1).setCellValue("b) Cevap2 Gir");
//        row.createCell(1).setCellValue("c) Cevap3 Gir");
//        row.createCell(1).setCellValue("d) Cevap4 Gir");
//        row.createCell(1).setCellValue("Doğru Cevap Şıkkını Gir");


        Scanner input = new Scanner(System.in);
        System.out.println("\n...QUİZ UYGULAMASINA HOŞGELDİNİZ...\n");

        // Giriş ekranı: Sisteme giriş mi yapılacak yoksa kayıt mı olunacağı sorulur.
        while (flag){
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
                System.out.println("Hatalı giriş yaptınız. Tekrar deneyiniz.");
            }
        }
        flag = true;
        System.out.println(satirSayisi);
        System.out.println("\n______________________________\nSORULAR");

        // Bütün satırları okuma
        for (int i = 0; i < satirSayisi+1; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(sheet1.getRow(i).getCell(j) + ", ");
            }
        }








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
        while (flag){
            System.out.print("Adınızı giriniz: ");
            String ad = input.next();
            for (i = 0; i < satirSayisi+1; i++) {
                if (ad.equals(sheet1.getRow(i).getCell(0).getStringCellValue())) {
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.println("Bu isim yok. Tekrar deneyiniz.");
            }
        }
        flag =true;
    }

    public static void sifreSor(){
        while (flag){
            System.out.print("Şifrenizi giriniz: ");
            String sifre = input.next();
            if (sifre.equals(sheet1.getRow(i).getCell(1).getStringCellValue())) {
                System.out.println("Hoşgeldin " + sheet1.getRow(i).getCell(0).getStringCellValue());
                flag = false;
            } else {
                System.out.println("Hatalı şifre girdiniz. Tekrar deneyiniz.");
            }
        }
        flag = true;
    }

}
