package com.ecommerce.controllers;

import com.ecommerce.beans.Response;
import com.ecommerce.entities.Users;
import com.ecommerce.models.AuthRequest;
import com.ecommerce.models.RegisterRequest;
import com.ecommerce.services.UserService;
import com.ecommerce.util.JwtUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthenticationController {

    private final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String welcome() {
        return "welcome";
    }


    /**
     * authenticate the user generates and returns a token based on the user firstName
     *
     * @param authRequest
     * @return token
     * @throws Exception
     */
    @PostMapping("/authenticate")
    public Response generateToken(@RequestBody AuthRequest authRequest) throws Exception {

        LOGGER.info("Request to authenticate user {}",authRequest.getUserName());

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(),
                            authRequest.getPassword())
            );
        } catch (Exception e) {
            throw new Exception("invalid username or password");
        }

        Users user = userService.findByUserName(authRequest.getUserName());

        Response response = new Response();
        response.setObject(user);
        response.setMessage(jwtUtil.generateToken(authRequest.getUserName()));

        LOGGER.info("user {} authenticated successfully",authRequest.getUserName());
        return response;

    }


    /**
     * registers a user.
     * @param registerRequest user info.
     * @throws Exception
     */
    @PostMapping("/register")
    public void registerUser(@RequestBody RegisterRequest registerRequest) throws Exception {
        LOGGER.info("Request to register user {}",registerRequest.getAuthCredentials().getUserName());
        Users user= userService.findByUserName(registerRequest.getAuthCredentials().getUserName());
        if(user != null){
            throw new Exception("username already in use");
        }
        userService.save(registerRequest);
        LOGGER.info("user {} registered successfully",registerRequest.getAuthCredentials().getUserName());

    }

}
