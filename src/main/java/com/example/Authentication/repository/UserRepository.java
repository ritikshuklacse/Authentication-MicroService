package com.example.Authentication.repository;

import com.example.Authentication.dto.UserLogin;
import com.example.Authentication.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,String> {
//    List<User> findByUserName(String firstName);
    User findByUserMail(String userMail);
    User findByUserId(String userId);

}
