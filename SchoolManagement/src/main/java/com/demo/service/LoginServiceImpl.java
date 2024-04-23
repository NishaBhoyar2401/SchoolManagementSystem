package com.demo.service;

import com.demo.bean.Login;
import com.demo.dao.LoginDaoImpl;
import com.demo.dao.Logindao;

public class LoginServiceImpl implements LoginService {
	
   Logindao logindao=new LoginDaoImpl();

@Override
public Login ValidateUser(String username, String password) {
	// TODO Auto-generated method stub
	Login l=logindao.validateUser(username, password);
	return l;
}

@Override
public int RegisterUser(String uname, String pwd, String mail) {
	// TODO Auto-generated method stub
	int i=logindao.RegisterUser(uname, pwd, mail);
	return i;
}
  
}
