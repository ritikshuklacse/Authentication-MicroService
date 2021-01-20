package com.example.Authentication.dto;

public class MerchantChangePassword {
    private String merchantMail;
    private String oldMerchantPswd;
    private String newMerchantPswd;

    public String getMerchantMail() {
        return merchantMail;
    }

    public void setMerchantMail(String merchantMail) {
        this.merchantMail = merchantMail;
    }

    public String getOldMerchantPswd() {
        return oldMerchantPswd;
    }

    public void setOldMerchantPswd(String oldMerchantPswd) {
        this.oldMerchantPswd = oldMerchantPswd;
    }

    public String getNewMerchantPswd() {
        return newMerchantPswd;
    }

    public void setNewMerchantPswd(String newMerchantPswd) {
        this.newMerchantPswd = newMerchantPswd;
    }
}
