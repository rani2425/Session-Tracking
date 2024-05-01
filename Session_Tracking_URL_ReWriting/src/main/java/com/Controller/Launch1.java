package com.Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ConnectionFactory.ConnectionFactory;
import com.Dao.UserDao;

@WebServlet("/signup")
public class Launch1 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("uname");
		String pass = req.getParameter("upass");
		
		Connection con = ConnectionFactory.getCon();
		UserDao uDao = new UserDao();
		
		String res = uDao.signupUser(name, pass, con);
		if(res.equals("inserted"))
		{
			resp.sendRedirect("login.html");
		}
		else
		{
			System.out.println("Enter correct username password");
			resp.sendRedirect("signup.html");
		}
	}
	
	
	

}
