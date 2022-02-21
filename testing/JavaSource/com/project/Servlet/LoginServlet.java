package com.project.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.LoginDao;



public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    LoginDao dao=new LoginDao();
    
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		
		//if(uname.equals("ankita") && pass.equals("ankita123"))
		boolean d = dao.check(uname, pass);
		if(d==true)
		{
			HttpSession session=request.getSession();
			session.setAttribute("username",uname);
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp?m=1");
			rd.forward(request, response);
		}
	}

}
