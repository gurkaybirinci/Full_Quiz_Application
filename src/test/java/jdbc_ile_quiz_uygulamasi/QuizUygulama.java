package jdbc_ile_quiz_uygulamasi;

import java.sql.*;

public class QuizUygulama {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // JDBC bağlantısını oluştur
            connection = ConnectionManager.getConnection();
            // Quiz sınıfının nesnesini oluştur
            Quiz quiz = new Quiz();
            // Quiz'in adını set et
            quiz.setName("Java Quiz");
            // Quiz'i veritabanına kaydet
            String sql = "INSERT INTO quiz (name) VALUES (?)";
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, quiz.getName());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                int quizId = rs.getInt(1);
                // Soruları quiz nesnesine ekle
                sql = "INSERT INTO quiz_soru (quiz_id, metin) VALUES (?,?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, quizId);
                preparedStatement.setString(2, "Soru 1");
                preparedStatement.executeUpdate();
                preparedStatement.setString(2, "Soru 2");
                preparedStatement.executeUpdate();
                preparedStatement.setString(2, "Soru 3");
                preparedStatement.executeUpdate();
            }
            // Quiz oyununu başlat
            quiz.baslat();
            // Quiz sonucunu kaydet
            QuizSonuc sonuc = new QuizSonuc();
            sonuc.save();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void kullaniciGirisi(Kullanici kullanici){
        // kullanici adi ve sifre kontrol edilir
        // eğer doğruysa kullaniciya quiz'in baslangic zamanı verilir
    }

    private KullaniciKayit kullaniciKayit;
    public QuizUygulama(){
        kullaniciKayit = new KullaniciKayit();
    }
    public void kullaniciKayitEt(String kullaniciAdi, String sifre, String email){
        kullaniciKayit.register(kullaniciAdi, sifre, email);
    }
}
