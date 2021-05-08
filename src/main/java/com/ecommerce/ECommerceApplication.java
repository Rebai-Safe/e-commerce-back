package com.ecommerce;

import com.ecommerce.entities.Users;
import com.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins="*")
public class ECommerceApplication {


    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);
    }

}
