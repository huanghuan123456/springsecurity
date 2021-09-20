package com.cy.jt.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class,args);
    newPassword();
    }
    static void newPassword(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePdw = encoder.encode("123456");
        System.out.println(encodePdw);
    }
}
