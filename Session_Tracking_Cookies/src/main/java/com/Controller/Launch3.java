package com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class Launch3 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Cookie[] cookies=req.getCookies();
		Cookie coo=null;
		for(Cookie c:cookies)
		{
			if(c.getName().equals("check"))
			{
				coo=c;
			}
		}
		coo.setMaxAge(0);
		resp.addCookie(coo);
		resp.sendRedirect("login.html");
	}

}
