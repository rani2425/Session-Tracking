package com.Controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ConnectionFactory.ConnectionFactory;
import com.Dao.UserDao;

@WebServlet("/login")
public class Launch2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("uname");
		String pass = req.getParameter("upass");
		
		Connection con = ConnectionFactory.getCon();
		UserDao uDao = new UserDao();
		
		String res = uDao.loginUser(name, pass, con);
		
		Cookie cookie = new Cookie("check", name);
		cookie.setMaxAge(30*60);
		
		if(res.equals("exists"))
		{
			resp.addCookie(cookie);
			resp.sendRedirect("home.jsp");
		}
		else
		{
			System.out.println("not exists");
			resp.sendRedirect("login.html");
		}
		
	}

}








