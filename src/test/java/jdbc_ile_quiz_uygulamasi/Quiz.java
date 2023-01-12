package jdbc_ile_quiz_uygulamasi;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private int id;
    private String name;
    private List<QuizSoru> sorular;

    public Quiz() {
        this.sorular = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSoru(QuizSoru soru) {
        this.sorular.add(soru);
    }

    public void baslat() {
        // Quiz oyununu başlat
        System.out.println("Quiz '" + this.name + "' başlatıldı!");
        for (QuizSoru soru : sorular) {
            System.out.println(soru.getMetin());
            // Sorunun cevabını al
            //...
        }
    }
}