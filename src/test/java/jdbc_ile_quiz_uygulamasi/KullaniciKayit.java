package jdbc_ile_quiz_uygulamasi;

public class KullaniciKayit {
    public boolean register(String kullaniciAdi, String sifre, String email){
        Kullanici varolanKullanici = Kullanici.getByUsername(kullaniciAdi);
        if (varolanKullanici == null){
            Kullanici kullanici = new Kullanici(kullaniciAdi, sifre, email);
            return kullanici.save();
        }
        return false;
    }
}