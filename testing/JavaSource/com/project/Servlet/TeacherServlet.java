package com.project.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.TeacherDao;
import com.project.model.Teacher;



public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    TeacherDao dao1=new TeacherDao();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch (action) 
			{
			case "list":
				 listTeacher(request, response);
				 break;
			
			case "new":
				 createTeacher(request, response);
				 break;
				 
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	
	

	private List<Teacher> listTeacher(HttpServletRequest request, HttpServletResponse response) {
		List<Teacher> listTeacher = dao1.getAllTeacher();
		try {
			
			HttpSession session = request.getSession();
			session.setAttribute("listTeacher",listTeacher);
			//response.sendRedirect("displayteacher.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("displayteacher.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listTeacher;
	}
	
	
	
	private Teacher createTeacher(HttpServletRequest request, HttpServletResponse response) {
		String tname = request.getParameter("teachname");
		
			Teacher TeacherModel = new Teacher(tname);
			Teacher newTeacher;
			newTeacher= TeacherDao.saveTeacher(TeacherModel);
			listTeacher(request, response);
		
			return newTeacher;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
