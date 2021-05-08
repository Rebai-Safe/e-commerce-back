package com.ecommerce.services;

import com.ecommerce.entities.Users;
import com.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Users findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
}
