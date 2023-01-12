package jdbc_ile_quiz_uygulamasi;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class QuizSonuc {
    private int id;
    private int quizId;
    private int kullaniciId;
    private Date tarih;
    private Map<QuizSoru, QuizCevap> cevaplar;
    private int skor;

    public QuizSonuc() {
        this.cevaplar = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(int kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public void addCevap(QuizSoru soru, QuizCevap cevap) {
        this.cevaplar.put(soru, cevap);
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }


    public void save() {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement("INSERT INTO QuizSonuc (quizId, kullaniciId, tarih) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, quizId);
            pstmt.setInt(2, kullaniciId);
            pstmt.setTimestamp(3, new Timestamp(tarih.getTime()));
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
        for (Map.Entry<QuizSoru, QuizCevap> entry : cevaplar.entrySet()) {
            int soruId = entry.getKey().getId();
            int cevapId = entry.getValue().getId();
            try {
                con = ConnectionManager.getConnection();
                pstmt = con.prepareStatement("INSERT INTO QuizSonucCevap (quizSonucId, quizSoruId, quizCevapId) VALUES (?, ?, ?)");
                pstmt.setInt(1, id);
                pstmt.setInt(2, soruId);
                pstmt.setInt(3, cevapId);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConnectionManager.close(con);
                ConnectionManager.close(pstmt);
            }
        }
    }
}
