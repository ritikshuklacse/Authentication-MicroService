package com.example.Authentication.repository;

import com.example.Authentication.entity.Merchant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MerchantRepository extends CrudRepository<Merchant, String> {
    List<Merchant> findByMerchantName(String firstName);
    Merchant findByMerchantMail(String merchantMail);
    Merchant findByMerchantId(String merchantId);




}
