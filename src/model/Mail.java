package model;

public class Mail{

    private String mail;

    public Mail(String mail){
        this.mail = mail;
    }

    public String getDomain(){
        int n = mail.indexOf('@');
        return mail.substring(n+1);
    }
}