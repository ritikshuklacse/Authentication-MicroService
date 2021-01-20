package com.example.Authentication.service;

import com.example.Authentication.dto.*;
import com.example.Authentication.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    User save(User user);
    User findByUserId(String userId);
    List<User> findAll();
    List<User> findByUserName(String userName);
    User findByUserMail(String userMail);
    User loginUser(UserLogin user);

    boolean editUser(UserChangePassword userChangePassword);

    User registerUser(UserRegDetails userRegDetails);

    UserDetails getByUserId(String userId);

    UserDetails getByUserMail(String userMail);

    User loginGoogleUser(UserLoginOauth userLoginOauth);
}
