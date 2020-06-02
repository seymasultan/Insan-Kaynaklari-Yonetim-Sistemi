package com.seymasultan;

import java.util.ArrayList;

public class Users {

    private String id;
    private String isim;
    private String mail;
    private String profil;


    public Users() {
    }


    public Users(String isim, String mail, String profil) {
        this.isim = isim;
        this.mail = mail;
        this.profil = profil;
    }

    public Users(String id, String isim, String mail, String profil) {
        this.id = id;
        this.isim = isim;
        this.mail = mail;
        this.profil = profil;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

}
