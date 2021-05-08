package com.ecommerce.controllers;

import com.ecommerce.beans.Response;
import com.ecommerce.entities.Users;
import com.ecommerce.models.AuthRequest;
import com.ecommerce.services.UserService;
import com.ecommerce.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthentificationController {

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
        return response;

    }

}
