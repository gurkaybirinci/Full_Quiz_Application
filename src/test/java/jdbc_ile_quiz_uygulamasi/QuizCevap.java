package jdbc_ile_quiz_uygulamasi;

public class QuizCevap {
    private int id;
    private String metin;
    private boolean dogru;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMetin() {
        return metin;
    }

    public void setMetin(String metin) {
        this.metin = metin;
    }

    public boolean isDogru() {
        return dogru;
    }

    public void setDogru(boolean dogru) {
        this.dogru = dogru;
    }
}
