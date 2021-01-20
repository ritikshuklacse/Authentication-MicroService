package com.example.Authentication.dto;

public class MerchantRegDetails {
    private String merchantName;
    private String merchantMail;
    private String merchantPswd;

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantMail() {
        return merchantMail;
    }

    public void setMerchantMail(String merchantMail) {
        this.merchantMail = merchantMail;
    }

    public String getMerchantPswd() {
        return merchantPswd;
    }

    public void setMerchantPswd(String merchantPswd) {
        this.merchantPswd = merchantPswd;
    }
}
