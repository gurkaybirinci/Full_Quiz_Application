package jdbc_ile_quiz_uygulamasi;

import java.sql.*;

public class QuizAnahtar {
    private int id;
    private int quizId;
    private String anahtar;

    public QuizAnahtar(int quizId, String anahtar) {
        this.quizId = quizId;
        this.anahtar = anahtar;
    }
    public QuizAnahtar(int id,int quizId, String anahtar) {
        this.id=id;
        this.quizId = quizId;
        this.anahtar = anahtar;
    }

    public int getId() {
        return id;
    }

    public int getQuizId() {
        return quizId;
    }

    public String getAnahtar() {
        return anahtar;
    }

    public void setAnahtar(String anahtar) {
        this.anahtar = anahtar;
    }
    public void save() {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = ConnectionManager.getConnection();
            pstmt = con.prepareStatement("INSERT INTO QuizAnahtar (quizId, anahtar) VALUES (?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, quizId);
            pstmt.setString(2, anahtar);
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
    }
}
