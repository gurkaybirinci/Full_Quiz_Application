package jdbc_ile_quiz_uygulamasi;

import java.util.ArrayList;
import java.util.List;

public class QuizSoru {
    private int id;
    private String metin;
    private List<QuizCevap> cevaplar;
    private int dogruCevap;

    public QuizSoru() {
        this.cevaplar = new ArrayList<>();
    }

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

    public void addCevap(QuizCevap cevap) {
        this.cevaplar.add(cevap);
    }

    public void setDogruCevap(int dogruCevap) {
        this.dogruCevap = dogruCevap;
    }

    public boolean cevapKontrol(int cevap) {
        return cevap == dogruCevap;
    }
}
