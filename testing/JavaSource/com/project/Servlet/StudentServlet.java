package com.project.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.StudentDao;
import com.project.model.Student;

@WebServlet("/")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
	
    private StudentDao dao;

    public void init() {
        dao = new StudentDao();
    }


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String action = request.getServletPath();
		//String action = request.getParameter("action");
		//if(action==("/testing/Student?action=list"))
		//{
		String action = request.getParameter("action");
		try {
			switch (action) 
			{
				case "list":
					listStudent(request, response);
					break;
					
				case "new":
					 createStudent(request, response);
					 break;
			
			}} catch (Exception e) {
				e.printStackTrace();
			}
		//}
		
	}

	
	/*private void listStudent(HttpServletRequest request, HttpServletResponse response) {
		try 
		{
			List < Student > listStudent = dao.getAllStudent();
	        request.setAttribute("listStudent", listStudent);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
	        dispatcher.forward(request, response);
			
		} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}*/
		
	private List<Student> listStudent(HttpServletRequest request, HttpServletResponse response) {
		List<Student> listStudent = dao.getAllStudent();
		try {
			HttpSession session = request.getSession();
			session.setAttribute("listStudent",listStudent);
			RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listStudent;
	}
	
	private Student createStudent(HttpServletRequest request, HttpServletResponse response) {
		String sname = request.getParameter("studname");
		String semail = request.getParameter("studemail");
		
			Student studentModel = new Student(sname, semail);
			Student newStudent;
			newStudent= StudentDao.saveStudent(studentModel);
			listStudent(request, response);
		
			return newStudent;
	}

	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
	
	
