package com.seymasultan;

public class HumanResources {

    private int id;
    private String hrAd;
    private String hrMail;
    private String hrSifre;
    private String sirket;

    public HumanResources(String hrAd, String hrMail, String hrSifre, String sirket) {
        this.hrAd = hrAd;
        this.hrMail = hrMail;
        this.hrSifre = hrSifre;
        this.sirket = sirket;
    }

    public HumanResources(int id, String hrAd, String hrMail, String hrSifre, String sirket) {
        this.id=id;
        this.hrAd = hrAd;
        this.hrMail = hrMail;
        this.hrSifre = hrSifre;
        this.sirket = sirket;
    }

    public HumanResources() {
    }

    public String getHrAd() {
        return hrAd;
    }

    public void setHrAd(String hrAd) {
        this.hrAd = hrAd;
    }

    public String getHrMail() {
        return hrMail;
    }

    public void setHrMail(String hrMail) {
        this.hrMail = hrMail;
    }

    public String getHrSifre() {
        return hrSifre;
    }

    public void setHrSifre(String hrSifre) {
        this.hrSifre = hrSifre;
    }

    public String getSirket() {
        return sirket;
    }

    public void setSirket(String sirket) {
        this.sirket = sirket;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
