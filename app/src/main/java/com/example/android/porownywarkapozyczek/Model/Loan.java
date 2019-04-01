package com.example.android.porownywarkapozyczek.Model;

import android.graphics.Bitmap;
import android.util.Range;

/*
klasa pożyczki (POJO)
 */
public class Loan {

    private int wiek; //requiredAge;
    private String nazwa; //loanName;
    //private Bitmap loanLogo;
    private int kwota_min; //loanValueMin;
    private int kwota_max; //loanValueMax;
    private int DZIEN_MAX; //dayMax;
    private int DZIEN_MIN; //dayMin;
    private int campaignCategoryId; //campaignCategoryId;
    private int isFirstLoanFree;
    private Bitmap logoBitmp;
    private String affilatelink;
    private String logourl;
    private int KWOTA_MAX_STALYCH;

    public int getKWOTA_MAX_STALYCH() {
        return KWOTA_MAX_STALYCH;
    }

    public void setKWOTA_MAX_STALYCH(int KWOTA_MAX_STALYCH) {
        this.KWOTA_MAX_STALYCH = KWOTA_MAX_STALYCH;
    }

    public String getAffilatelink() {
        return affilatelink;
    }

    public void setAffilatelink(String affilatelink) {
        this.affilatelink = affilatelink;
    }

    public String getLogourl() {
        return logourl;
    }

    public void setLogourl(String logourl) {
        this.logourl = logourl;
    }

    public Bitmap getLogoBitmp() {
        return logoBitmp;
    }

    public void setLogoBitmp(Bitmap logoBitmp) {
        this.logoBitmp = logoBitmp;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getKwota_min() {
        return kwota_min;
    }

    public void setKwota_min(int kwota_min) {
        this.kwota_min = kwota_min;
    }

    public int getKwota_max() {
        return kwota_max;
    }

    public void setKwota_max(int kwota_max) {
        this.kwota_max = kwota_max;
    }

    public int getDZIEN_MAX() {
        return DZIEN_MAX;
    }

    public void setDZIEN_MAX(int DZIEN_MAX) {
        this.DZIEN_MAX = DZIEN_MAX;
    }

    public int getDZIEN_MIN() {
        return DZIEN_MIN;
    }

    public void setDZIEN_MIN(int DZIEN_MIN) {
        this.DZIEN_MIN = DZIEN_MIN;
    }

    public int getcampaignCategoryId() {
        return campaignCategoryId;
    }

    public void setcampaignCategoryId(int id) {
        this.campaignCategoryId = id;
    }

    public int getisFirstLoanFree() {
        return isFirstLoanFree;
    }

    public void setFirstLoanFree(int firstLoanFree) {
        isFirstLoanFree = firstLoanFree;
    }
}
