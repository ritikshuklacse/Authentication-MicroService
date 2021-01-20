package com.example.Authentication.service;

import com.example.Authentication.dto.*;
import com.example.Authentication.entity.Merchant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MerchantService {
    Merchant save(Merchant merchant);
    Merchant findByMerchantId(String merchantId);
    List<Merchant> findAll();
    List<Merchant> findByMerchantName(String merchantName);
    Merchant findByMerchantMail(String merchantMail);
    Merchant loginMerchant(MerchantLogin merchant);

    boolean editMerchant(MerchantChangePassword merchantChangePassword);

    Merchant registerMerchant(MerchantRegDetails merchantRegDetails);

    MerchantDetails getByMerchantId(String merchantId);

    MerchantDetails getByMerchantMail(String merchantMail);

    Merchant loginGoogleUser(MerchantLoginOauth merchantLoginOauth);

    void updateRating(String string);
}
