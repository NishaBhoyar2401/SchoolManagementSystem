package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.bean.Login;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String user1=request.getParameter("user");
		String pass=request.getParameter("pwd");
		HttpSession session=request.getSession(true);
		LoginService ls=new LoginServiceImpl();
		Login l=ls.ValidateUser(user1, pass);
		PrintWriter out=response.getWriter();
		System.out.println(l);
		System.out.println(user1);
		RequestDispatcher rd;
		if(l!=null){
			System.out.println(l);
			if(l.getUsername().equals(user1)) 
			{
				if(session!=null) {
				System.out.println("Login Sucessfull");
				rd=request.getRequestDispatcher("Welcome.jsp");
				rd.forward(request, response);
				}
				else {
					rd=request.getRequestDispatcher("Login.jsp");
				}
			}
			else if(l.getUsername().equals(user1))
			{
				response.setContentType("text/html");
				rd=request.getRequestDispatcher("Welcome.jsp");
				rd.forward(request,response);
			}
			
		else 
		{
			out.print("Role Not assigned");
		}
		
	}else {
		out.print("invalid Login");
		response.setContentType("text/html");
		rd=request.getRequestDispatcher("Login.jsp");
		rd.include(request, response);
	}

	}
}
