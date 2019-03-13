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
    private int id; //campaignCategoryId;
    //private boolean isFirstLoanFree;


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
