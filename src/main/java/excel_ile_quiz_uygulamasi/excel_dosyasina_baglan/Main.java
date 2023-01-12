package excel_ile_quiz_uygulamasi.excel_dosyasina_baglan;

import java.io.IOException;
import java.util.*;

public class Main {
    static boolean flag = true;
    static Scanner input = new Scanner(System.in);
    static ConnectionManager connect;
    static String kullaniciAdi;
    static String sifre;
    static int i = 0;
    public static void main(String[] args) throws IOException {
        //Excel dosyasına ConnectionManager dosyası üzerinden bağlanma işlemi
        connect = new ConnectionManager();
        connect.excelBelgesineBaglan();

        Scanner input = new Scanner(System.in);
        System.out.println("\n...QUİZ UYGULAMASINA HOŞGELDİNİZ...\n");

        // Giriş ekranı: Sisteme giriş mi yapılacak yoksa kayıt mı olunacağı sorulur.
        while (flag){
            System.out.print("Ne yapmak istersiniz?\n\tGiriş yapmak için --> 1'e\n\tKayıt olmak için --> 2'ye\nbasınız: ");
            String secimYap = input.next();

            if (secimYap.equals("1")) {
                loginKullaniciAdi();
                loginSifre();
                break;
            }else if (secimYap.equals("2")){
                signUpKullaniciAdi();
                signUpSifre();
                break;
            }else {
                System.out.println("Hatalı giriş yaptınız. Tekrar deneyiniz.");
            }
        }

        System.out.println(connect.getSatirSayisi());
        System.out.println("\n______________________________\nSORULAR");

        // Bütün satırları okuma
        for (int i = 0; i < connect.getSatirSayisi(); i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(connect.getSheet1().getRow(i).getCell(j) + ", ");
            }
        }

        //Excel dosyasını kaydetme ve kapatma işlemi
        connect.excelBelgesiniKapat();
    }

    public static void signUpKullaniciAdi(){
        while (flag){
            int sayac = 0;
            System.out.print("Kullanıcı adı giriniz: ");
            kullaniciAdi = input.next();
            for (i = 0; i < connect.getSatirSayisi(); i++) {
                if (kullaniciAdi.equals(connect.getSheet1().getRow(i).getCell(0).getStringCellValue())) {
                    sayac = 1;
                }
            }
            if (sayac==0){
                connect.getSheet1().createRow(connect.getSatirSayisi()).createCell(0).setCellValue(kullaniciAdi);
                connect.getSheet2().createRow(connect.getSatirSayisi()).createCell(0).setCellValue(kullaniciAdi);
                flag = false;
            }else {
                System.out.println("Bu isimde bir kayıt zaten var. Başka bir kullanıcı adı giriniz.");
            }
        }
        flag =true;
    }

    public static void signUpSifre(){
        System.out.print("Şifre: ");
        sifre = input.next();
        connect.getSheet1().getRow(connect.getSatirSayisi()).createCell(1).setCellValue(sifre);
        System.out.println("Hesabınız başarılı bir şekilde oluşturuldu!");
        System.out.println("Hoşgeldin " + kullaniciAdi);
    }

    public static void loginKullaniciAdi(){
        while (flag){
            System.out.print("Adınızı giriniz: ");
            kullaniciAdi = input.next();
            for (i = 0; i < connect.getSatirSayisi(); i++) {
                if (kullaniciAdi.equals(connect.getSheet1().getRow(i).getCell(0).getStringCellValue())) {
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

    public static void loginSifre(){
        while (flag){
            System.out.print("Şifrenizi giriniz: ");
            sifre = input.next();
            if (sifre.equals(connect.getSheet1().getRow(i).getCell(1).getStringCellValue())) {
                System.out.println("Hoşgeldin " + kullaniciAdi);
                flag = false;
            } else {
                System.out.println("Hatalı şifre girdiniz. Tekrar deneyiniz.");
            }
        }
        flag = true;
    }
}


// Kayıt Bilgileri bölümündeki (sheet1) varolan bir hücrenin değerini değiştirme
//        Row row = sheet1.getRow(Satır No Gir);
//        row.getCell(0).setCellValue("Yeni İsim Gir");
//        row.getCell(1).setCellValue("Yeni Şifre Gir");
//        row = sheet2.getRow(Yukardaki Satır No ile aynı noyu gir);
//        row.getCell(0).setCellValue("Yeni İsim Gir");


// Kayıt Bilgileri bölümünde (sheet1) yeni bir satır ve hücre ekleyerek veri girme
//        row = connect.getSheet1().createRow(connect.getSatirSayisi()+1);
//        row.createCell(0).setCellValue("İsim Gir");
//        row.createCell(1).setCellValue("Şifre Gir");
//        row = connect.getSheet2().createRow(connect.getSatirSayisi()+1);
//        row.createCell(0).setCellValue("İsim Gir");


// Quiz Sayfasına (sheet0) yeni bir soru ve cevapları girme
//        row = sheet0.createRow(satirSayisi+1);
//        row.createCell(0).setCellValue("Soru Metnini Gir");
//        row.createCell(1).setCellValue("a) Cevap1 Gir");
//        row.createCell(1).setCellValue("b) Cevap2 Gir");
//        row.createCell(1).setCellValue("c) Cevap3 Gir");
//        row.createCell(1).setCellValue("d) Cevap4 Gir");
//        row.createCell(1).setCellValue("Doğru Cevap Şıkkını Gir");


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