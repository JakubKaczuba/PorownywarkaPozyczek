package com.example.android.porownywarkapozyczek.Model;

import android.graphics.Bitmap;
import android.util.Range;

/*
klasa pożyczki (POJO)
 */
public class Loan {

    private int requiredAge;
    private String loanName;
    private Bitmap loanLogo;
    private Range<Integer> loanValueRange;
    private Range<Integer> daysRange;
    private int campaignCategoryId;
    private boolean isFirstFreeLoan;

    public int getRequiredAge() {
        return requiredAge;
    }

    public void setRequiredAge(int requiredAge) {
        this.requiredAge = requiredAge;
    }

    public String getLoanName() {
        return loanName;
    }

    public void setLoanName(String loanName) {
        this.loanName = loanName;
    }

    public Bitmap getLoanLogo() {
        return loanLogo;
    }

    public void setLoanLogo(Bitmap loanLogo) {
        this.loanLogo = loanLogo;
    }

    public Range<Integer> getLoanValueRange() {
        return loanValueRange;
    }

    public void setLoanValueRange(Range<Integer> loanValueRange) {
        this.loanValueRange = loanValueRange;
    }

    public Range<Integer> getDaysRange() {
        return daysRange;
    }

    public void setDaysRange(Range<Integer> daysRange) {
        this.daysRange = daysRange;
    }

    public int getCampaignCategoryId() {
        return campaignCategoryId;
    }

    public void setCampaignCategoryId(int campaignCategoryId) {
        this.campaignCategoryId = campaignCategoryId;
    }

    public boolean isFirstFreeLoan() {
        return isFirstFreeLoan;
    }

    public void setFirstFreeLoan(boolean firstFreeLoan) {
        isFirstFreeLoan = firstFreeLoan;
    }
}
