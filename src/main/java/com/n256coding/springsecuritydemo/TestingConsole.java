package com.n256coding.springsecuritydemo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestingConsole {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(11);
        String pwd = bCryptPasswordEncoder.encode("pwd");
        String test = "asdfasd";
    }
}
