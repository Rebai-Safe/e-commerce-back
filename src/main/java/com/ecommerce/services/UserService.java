package com.ecommerce.services;

import com.ecommerce.entities.Profile;
import com.ecommerce.entities.Users;
import com.ecommerce.models.RegisterRequest;
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

    public void save(RegisterRequest registerRequest) {
        Users user= new Users(registerRequest.getAuthCredentials().getUserName(),
                registerRequest.getAuthCredentials().getPassword());
        Profile profile = new Profile(registerRequest.getProfileCredentials().getFirstName(),
                registerRequest.getProfileCredentials().getLastName(),
                registerRequest.getProfileCredentials().getEmail(),
                registerRequest.getProfileCredentials().getCountry());

        user.setProfile(profile);

        userRepository.save(user);
    }


    /*
     *update user
     */
    public void save(Users user) {
        userRepository.save(user);
    }
}
