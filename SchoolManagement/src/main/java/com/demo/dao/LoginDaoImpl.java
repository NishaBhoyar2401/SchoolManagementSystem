package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.demo.bean.Login;

public class LoginDaoImpl implements Logindao {

	Login l=null;
	@Override
	public Login validateUser(String username, String password) {
		// TODO Auto-generated method stub
		Connection conn=DBUtility.getconnection();
		System.out.println("connection established");
		try {
			System.out.println(username+" "+password);
			String sql="select * from users where username=? and password=?";
			System.out.println(conn);
					PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1, username);
					ps.setString(2, password);
					ResultSet rs=ps.executeQuery();
				
			 while(rs.next()) {
				 l=new Login();
				 l.setUsername(rs.getString(1));
				 l.setEmail(rs.getString(2));
				 l.setPassword(rs.getString(3));
			 }
			} catch (Exception e) {
				e.printStackTrace();
			}
			return l;
	}

	@Override
	public int RegisterUser(String uname, String pwd, String mail) {
		// TODO Auto-generated method stub
		Connection conn=DBUtility.getconnection();
		try {
			String query="insert into users values (?,?,?)";
			conn.setAutoCommit(true);
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, uname);
			ps.setString(2, mail);
			ps.setString(3, pwd);
			ps.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
    
}
