package com.ecommerce.controllers;

import com.ecommerce.beans.ProfileCredentials;
import com.ecommerce.beans.Response;
import com.ecommerce.entities.Profile;
import com.ecommerce.entities.Users;
import com.ecommerce.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

     private final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    /**
     * returns authenticated user profile.
     * @param authentication authentication info.
     * @return user profile
     */
    @RequestMapping(method = RequestMethod.GET,value = "/profile")
    public Response getUserProfile(Authentication authentication) {


          Users user=userService.findByUserName(authentication.getName());
          LOGGER.info("Request to return user {} profile",user.getUserName());
          Profile userProfile=user.getProfile();

          ProfileCredentials profile = new ProfileCredentials(userProfile.getFirstName(),
                  userProfile.getLastName(),userProfile.getEmail(),userProfile.getCountry());

          Response response = new Response();
          response.setObject(profile);
          return response;
    }

    /**
     * updates current user profile.
     * @param authentication
     * @param profileCredentials
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value="/updateProfile")
    public Response updateUserProfile(Authentication authentication,
                                      @RequestBody  ProfileCredentials profileCredentials){

        Users user=userService.findByUserName(authentication.getName());
        Profile userProfile=user.getProfile();
        LOGGER.info("Request to update user {} profile", user.getUserName());
        userProfile.setFirstName(profileCredentials.getFirstName());
        userProfile.setLastName(profileCredentials.getLastName());
        userProfile.setCountry(profileCredentials.getCountry());
        userProfile.setEmail(profileCredentials.getEmail());
        LOGGER.info(profileCredentials.getEmail());
        userService.save(user);
        LOGGER.info("user {} profile updated successfully",user.getUserName());

        Response response = new Response();
        response.setMessage("updated successfully");
        return response;
    }
}
