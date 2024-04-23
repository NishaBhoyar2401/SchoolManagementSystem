package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.bean.Login;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String user=request.getParameter("Username");
		String pwd=request.getParameter("Password");
		String mail=request.getParameter("Email");
		LoginService ls=new LoginServiceImpl();
		int i=ls.RegisterUser(user, pwd, mail);
		PrintWriter out=response.getWriter();
		RequestDispatcher rd;
		if(i>0) {
			out.println("Data Inserted Successfully");
			rd=request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		else {
			out.println("Data not inserted");
			rd=request.getRequestDispatcher("Register.jsp");
			rd.forward(request, response);
		}
	}

}
