package com.demo.service;

import com.demo.bean.Login;

public interface LoginService {
    public Login ValidateUser(String username,String password); 
    public int RegisterUser(String username, String password, String email);
}
