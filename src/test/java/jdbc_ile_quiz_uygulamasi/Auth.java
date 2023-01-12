package jdbc_ile_quiz_uygulamasi;

public class Auth {
    private static Auth instance;
    private Kullanici loggedInUser;
    private Auth(){
    }
    public static Auth getInstance(){
        if(instance == null){
            instance = new Auth();
        }
        return instance;
    }
    public boolean login(String kullaniciAdi, String sifre){
        Kullanici kullanici = Kullanici.getByUsername(kullaniciAdi);
        if(kullanici != null && kullanici.getSifre().equals(sifre)){
            loggedInUser = kullanici;
            return true;
        }
        return false;
    }
    public void logout(){
        loggedInUser = null;
    }
    public boolean isLoggedIn(){
        return loggedInUser != null;
    }
    public Kullanici getLoggedInUser(){
        return loggedInUser;
    }
}