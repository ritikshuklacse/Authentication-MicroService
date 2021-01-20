package com.example.Authentication.service.impl;

import com.example.Authentication.dto.*;
import com.example.Authentication.entity.User;
import com.example.Authentication.repository.UserRepository;
import com.example.Authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }


    @Override
    public User findByUserId(String userId) {

        return userRepository.findByUserId(userId);
    }


    @Override
    public List<User> findAll() {
        Iterable<User> employeeIterable = userRepository.findAll();
        List<User> employeeList = new ArrayList<>();
        employeeIterable.forEach(employeeList::add);
        return employeeList;
    }


    @Override
    public List<User> findByUserName(String userName) {
        return null;
    }

    @Override
    public User findByUserMail(String userMail) {
        return userRepository.findByUserMail(userMail);
    }

    @Override
    public UserDetails getByUserId(String userId) {
        try{
            User user = userRepository.findByUserId(userId); // Later : Input parameter as part of the URL
            UserDetails userDetails = new UserDetails();
            userDetails.setUserImageUrl((user.getUserImageUrl()));
            userDetails.setUserMail(user.getUserMail());
            userDetails.setUserName(user.getUserName());
            userDetails.setUserId(user.getUserId());
            userDetails.setLoginTimeStamp((user.getLoginTimeStamp()));
            return userDetails;

        }
        catch (Exception e){
            return null;

        }
    }

    @Override
    public UserDetails getByUserMail(String userMail) {

        try{
            User user = userRepository.findByUserMail(userMail); // Later : Input parameter as part of the URL
            UserDetails userDetails = new UserDetails();
            userDetails.setUserImageUrl((user.getUserImageUrl()));
            userDetails.setUserMail(user.getUserMail());
            userDetails.setUserName(user.getUserName());
            userDetails.setUserId(user.getUserId());
            userDetails.setLoginTimeStamp((user.getLoginTimeStamp()));
            return userDetails;

        }
        catch (Exception e){
            return null;

        }
    }

    @Override
    public User loginUser(UserLogin userLogin) {
        try{

//            System.out.println(userLogin.getUserMail());
//            System.out.println(userLogin.getUserPswd());
            User usertemp = userRepository.findByUserMail(userLogin.getUserMail());
//        System.out.println(usertemp.getUserPswd());

            if(userLogin.getUserPswd().equals(usertemp.getUserPswd()))
            {
                User user = userRepository.findByUserMail(userLogin.getUserMail());
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                System.out.println(dtf.format(now).toString()+",");
                user.setLoginTimeStamp((user.getLoginTimeStamp()+ (dtf.format(now).toString()+",")).toString());
                return userRepository.save(user);
            }

            else
                return null;

        }
        catch(Exception e){
            return null;

        }

    }

    @Override
    public User registerUser(UserRegDetails userRegDetails) {
        try{
            if(userRepository.findByUserMail(userRegDetails.getUserMail())!=null){
                return null;

            }
            User user = new User();
            user.setUserMail(userRegDetails.getUserMail());
            user.setUserName(userRegDetails.getUserName());
            user.setUserPswd(userRegDetails.getUserPswd());
            int index = userRegDetails.getUserMail().indexOf('@');
            user.setUserId(userRegDetails.getUserMail().substring(0,index));
            return userRepository.save(user);

        }
        catch(Exception e){
            return null;

        }

    }

    @Override
    public boolean editUser(UserChangePassword userChangePassword) {
        User user = userRepository.findByUserMail(userChangePassword.getUserMail());
        if(user.getUserPswd().equals(userChangePassword.getOldUserPswd())){
            user.setUserPswd(userChangePassword.getNewUserPswd());
            userRepository.save(user);
            return true;

        }
        else{
            return false;
        }
    }

    @Override
    public User loginGoogleUser(UserLoginOauth userLoginOauth) {
            User newUser = new User();
            int index = userLoginOauth.getUserMail().indexOf('@');
            newUser.setUserId(userLoginOauth.getUserMail().substring(0,index));
            newUser.setUserName(userLoginOauth.getUserName());
            newUser.setUserMail(userLoginOauth.getUserMail());
            newUser.setUserImageUrl(userLoginOauth.getUserImage());
            return userRepository.save(newUser);

    }
}






