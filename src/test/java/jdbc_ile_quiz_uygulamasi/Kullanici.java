package jdbc_ile_quiz_uygulamasi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Kullanici {
    private int id;
    private String kullaniciAdi;
    private String sifre;
    private boolean admin;
    private int puan;
    private List<QuizSonuc> sonuclar;

    public Kullanici(String kullaniciAdi, String sifre, boolean admin) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.admin = admin;
        sonuclar = new ArrayList<>();
    }

    public Kullanici(int id, String kullaniciAdi, String sifre, boolean admin) {
        this.id = id;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.admin = admin;
        sonuclar = new ArrayList<>();
    }

    public Kullanici(String kullaniciAdi, String sifre, String email) {
    }

    public int getId() {
        return id;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public List<QuizSonuc> getSonuclar() {
        return sonuclar;
    }
    public static Kullanici getByUsername(String kullaniciAdi){
        // JDBC ile veritabanına bağlantı kurulur
        // kullanici adi ile arama yapılır
        // geriye Kullanici nesnesi döndürür
        return null; //Kullanici nesnesi döndürecek
    }

    public boolean save() {
        Connection con = null;
        PreparedStatement pstmt = null;
        try{
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement("INSERT INTO Kullanici (kullaniciAdi, sifre, admin) VALUES (?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, kullaniciAdi);
            pstmt.setString(2, sifre);
            pstmt.setBoolean(3, admin);
            pstmt.executeUpdate();
            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(con);
            ConnectionManager.close(pstmt);
        }
        return false;
    }
    public void takeQuiz(Quiz quiz){
        QuizUygulama uygulama = new QuizUygulama();
        uygulama.kullaniciGirisi(this);
    }
}
