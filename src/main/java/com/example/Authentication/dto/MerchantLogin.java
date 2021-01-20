package com.example.Authentication.dto;

public class MerchantLogin {
    private String merchantMail;
    private String merchantPswd;

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
