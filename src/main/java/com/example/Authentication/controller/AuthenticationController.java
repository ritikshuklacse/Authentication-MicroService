package com.example.Authentication.controller;

import com.example.Authentication.dto.*;
import com.example.Authentication.entity.Merchant;
import com.example.Authentication.entity.User;
import com.example.Authentication.service.MerchantService;
import com.example.Authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping(value="/auth")
public class AuthenticationController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/register/user")
    public User registerUser(@RequestBody UserRegDetails userRegDetails){

        return userService.registerUser(userRegDetails);

    }

    @PostMapping(value = "/user/changepassword")
    public boolean editUser(@RequestBody UserChangePassword userChangePassword){

        try{
            return userService.editUser(userChangePassword);
        }
        catch(Exception e){
            return false;
        }
    }


    @PostMapping(value = "/login/google/user")
    User loginGoogleUser(@RequestBody UserLoginOauth userLoginOauth){
        return userService.loginGoogleUser(userLoginOauth);
    }

    @GetMapping(value = "/user/id/{userId}")
    UserDetails getByUserId(@PathVariable("userId") String userId){
        return userService.getByUserId(userId);
    }

    @GetMapping(value = "/user/mail/{userMail}")
    UserDetails getByUserMail(@PathVariable("userMail") String userMail){
        return userService.getByUserMail(userMail);
    }

    @PostMapping("/login/user")
    public User loginUser(@RequestBody  UserLogin userLogin)
    {
        //System.out.println("abc");
        return userService.loginUser(userLogin);
    }


    @GetMapping(value="/user/findAll")
    List<User> findAllUsers(){
        return userService.findAll();
    }


    @Autowired
    MerchantService merchantService;

    @GetMapping(value="/merchant/findAll")
    List<Merchant> findAllMerchants(){
        return merchantService.findAll();
    }


    @PostMapping(value = "/register/merchant")
    public Merchant registerMerchant(@RequestBody MerchantRegDetails merchantRegDetails){
        return merchantService.registerMerchant(merchantRegDetails);
    }

    @PostMapping("/login/merchant")
    public  Merchant loginMerchant(@RequestBody  MerchantLogin merchantLogin)
    {
        return merchantService.loginMerchant(merchantLogin);
    }

    @PostMapping(value = "/login/google/merchant")
    Merchant loginGoogleUser(@RequestBody MerchantLoginOauth merchantLoginOauth){
        return merchantService.loginGoogleUser(merchantLoginOauth);
    }

    @PostMapping(value = "/merchant/changepassword")
    public boolean editMerchant(@RequestBody MerchantChangePassword merchantChangePassword){
        try{
            return merchantService.editMerchant(merchantChangePassword);

        }
        catch(Exception e){
            System.out.println(e);
            return false;

        }
    }



    @GetMapping(value = "/merchant/id/{merchantId}")
    MerchantDetails getByMerchantId(@PathVariable("merchantId") String merchantId){
        return merchantService.getByMerchantId(merchantId);

    }

    @GetMapping(value = "/merchant/mail/{merchantMail}")
    MerchantDetails getByMerchantMail(@PathVariable("merchantMail") String merchantMail){
        return merchantService.getByMerchantMail(merchantMail);

    }

    @KafkaListener(topics = "authrating", groupId = "team7")
    public void updateRating(String string){
        merchantService.updateRating(string);
        System.out.println(string);
    }

    @GetMapping(value = "/getmail/{userid}")
    public String getmail(@PathVariable("userid") String userid)
    {
        return getByUserId(userid).getUserMail();
    }


}
