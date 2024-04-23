package com.demo.dao;

import com.demo.bean.Login;

public interface Logindao {
   public Login validateUser(String username,String password);
   public int RegisterUser(String username, String password, String email);
}
