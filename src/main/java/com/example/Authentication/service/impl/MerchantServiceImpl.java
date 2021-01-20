package com.example.Authentication.service.impl;

import com.example.Authentication.dto.*;
import com.example.Authentication.entity.Merchant;
import com.example.Authentication.repository.MerchantRepository;
import com.example.Authentication.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Autowired
    MerchantRepository merchantRepository;

    @Override
    public Merchant save(Merchant merchant) {
        return merchantRepository.save(merchant);
    }

    @Override
    public Merchant findByMerchantId(String merchantId) {

        return merchantRepository.findByMerchantId(merchantId);
    }

//    @Override
//    public void deleteById(int id) {
//        employeeRepository.deleteById(id);
//    }

    @Override
    public List<Merchant> findAll() {
        Iterable<Merchant> merchantIterable = merchantRepository.findAll();
        List<Merchant> merchantList = new ArrayList<>();
        merchantIterable.forEach(merchantList::add);
        return merchantList;
    }

    @Override
    public List<Merchant> findByMerchantName(String userName) {
        Iterable<Merchant> merchantIterable = merchantRepository.findByMerchantName(userName);
        List<Merchant> merchantList = new ArrayList<>();
        merchantIterable.forEach(merchantList::add);
        return merchantList;
    }

    @Override
    public Merchant findByMerchantMail(String userMail) {
        return  merchantRepository.findByMerchantMail(userMail);
    }

    @Override
    public Merchant registerMerchant(MerchantRegDetails merchantRegDetails) {
        try{
            if(merchantRepository.findByMerchantMail(merchantRegDetails.getMerchantMail())!=null){
                return null;

            }

            Merchant merchant = new Merchant();

            merchant.setMerchantMail(merchantRegDetails.getMerchantMail());
            merchant.setMerchantName(merchantRegDetails.getMerchantName());
            merchant.setMerchantPswd(merchantRegDetails.getMerchantPswd());
            int index = merchantRegDetails.getMerchantMail().indexOf('@');
            merchant.setMerchantId(merchantRegDetails.getMerchantMail().substring(0,index));
            merchant.setMerchantRating(0);
            merchant.setMerchantImageUrl(null);

            return merchantRepository.save(merchant);

        }
        catch(Exception e){
            return null;

        }

    }

    @Override
    public MerchantDetails getByMerchantId(String merchantId) {
        try{
            Merchant merchant = merchantRepository.findByMerchantId(merchantId); // Later : Input parameter as part of the URL
            MerchantDetails merchantDetails = new MerchantDetails();
            merchantDetails.setMerchantImageUrl(merchant.getMerchantImageUrl());
            merchantDetails.setMerchantMail(merchant.getMerchantMail());
            merchantDetails.setMerchantName(merchant.getMerchantName());
            merchantDetails.setMerchantId(merchant.getMerchantId());
            merchantDetails.setMerchantRating(merchant.getMerchantRating());

            return merchantDetails;

        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public MerchantDetails getByMerchantMail(String merchantMail) {
        try{
            Merchant merchant = merchantRepository.findByMerchantMail(merchantMail); // Later : Input parameter as part of the URL
            MerchantDetails merchantDetails = new MerchantDetails();
            merchantDetails.setMerchantImageUrl(merchant.getMerchantImageUrl());
            merchantDetails.setMerchantMail(merchant.getMerchantMail());
            merchantDetails.setMerchantName(merchant.getMerchantName());
            merchantDetails.setMerchantId(merchant.getMerchantId());
            merchantDetails.setMerchantRating(merchant.getMerchantRating());
            return merchantDetails;

        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean editMerchant(MerchantChangePassword merchantChangePassword) {


          Merchant merchant = merchantRepository.findByMerchantMail(merchantChangePassword.getMerchantMail());
        System.out.println(merchant.getMerchantMail() + " " + merchant.getMerchantPswd());
        System.out.println(merchantChangePassword.getOldMerchantPswd());
        System.out.println(merchantChangePassword.getNewMerchantPswd());
            if(merchant.getMerchantPswd().equals(merchantChangePassword.getOldMerchantPswd()))
            {
                merchant.setMerchantPswd(merchantChangePassword.getNewMerchantPswd());
                merchantRepository.save(merchant);
                System.out.println("if");
                return true;

            }
            else{
                System.out.println("else");
                return false;
            }
    }

    @Override
    public Merchant loginMerchant(MerchantLogin merchantLogin) {
        try{
            Merchant merchanttemp = merchantRepository.findByMerchantMail(merchantLogin.getMerchantMail());
//        System.out.println(merchantLogin.getMerchantPswd());
            if(merchantLogin.getMerchantPswd().equals(merchanttemp.getMerchantPswd()))

                return merchanttemp;
            else
                return null;

        }
        catch(Exception e){
            return null;
        }

    }

    @Override
    public Merchant loginGoogleUser(MerchantLoginOauth merchantLoginOauth) {
        if(merchantRepository.findByMerchantMail(merchantLoginOauth.getMerchantMail())!=null){
            Merchant merchanttemp = new Merchant();
            int index = merchantLoginOauth.getMerchantMail().indexOf('@');
            merchanttemp.setMerchantImageUrl(merchantLoginOauth.getMerchantImageUrl());
            merchanttemp.setMerchantName(merchantLoginOauth.getMerchantName());
            merchanttemp.setMerchantMail(merchantLoginOauth.getMerchantMail());
            merchanttemp.setMerchantId(merchantLoginOauth.getMerchantMail().substring(0,index));
            merchanttemp.setMerchantRating(merchantRepository.findByMerchantMail(merchantLoginOauth.getMerchantMail()).getMerchantRating());
            return merchanttemp;
        }
        else {
            Merchant merchanttemp = new Merchant();
            int index = merchantLoginOauth.getMerchantMail().indexOf('@');
            merchanttemp.setMerchantImageUrl(merchantLoginOauth.getMerchantImageUrl());
            merchanttemp.setMerchantName(merchantLoginOauth.getMerchantName());
            merchanttemp.setMerchantMail(merchantLoginOauth.getMerchantMail());
            merchanttemp.setMerchantId(merchantLoginOauth.getMerchantMail().substring(0, index));
            merchanttemp.setMerchantPswd(Math.round(Math.random()*1000000)+"");
            return merchantRepository.save(merchanttemp);
        }
    }

    @Override
    public void updateRating(String string) {
        int index = string.indexOf('*');
        String merchantId = string.substring(0,index);
        String rating = string.substring(index+1);
        System.out.println(merchantId);
        System.out.println(rating);
        System.out.println(Double.valueOf(rating));
        Merchant merchant = merchantRepository.findByMerchantId(merchantId);
        merchant.setMerchantRating(Double.valueOf(rating));
        merchantRepository.save(merchant);

    }

}
