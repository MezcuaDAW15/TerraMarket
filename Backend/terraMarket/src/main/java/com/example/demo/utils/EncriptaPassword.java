package com.example.demo.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptaPassword {
    public static void main(String[] args) {
        var password = "$2a$10$Ob5DP8Q/jOCJ5sEniPsImemloOwwB/pf/MoQlh/M0B23QCGGfDGYy";
        System.out.println("password: " + password);
        System.out.println("password encriptado:" + encriptarPassword(password));
        
    }

    public static String encriptarPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
