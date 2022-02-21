package com.project.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.SubjectDao;
import com.project.model.Subject;


public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SubjectServlet() {
        super();
        
    }

    SubjectDao dao1=new SubjectDao();
	
	
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		String action = request.getParameter("action");
   		try {
   			switch (action) 
   			{
   			case "list":
   				 listSubject(request, response);
   				 break;
   			case "new":
				 createSubject(request, response);
				 break;
   			}
   			} catch (Exception e) {
   				e.printStackTrace();
   			}
   	}

   	
   	

   	private List<Subject> listSubject(HttpServletRequest request, HttpServletResponse response) {
   		List<Subject> listSubject = dao1.getAllSubject();
   		try {
   			
   			HttpSession session = request.getSession();
   			session.setAttribute("listSubject",listSubject);
   			//response.sendRedirect("displaySubject.jsp");
   			RequestDispatcher dispatcher = request.getRequestDispatcher("displaysubject.jsp");
   			dispatcher.forward(request, response);
   		} catch (Exception e) {
   			e.printStackTrace();
   		}
   		return listSubject;
   	}

   	private Subject createSubject(HttpServletRequest request, HttpServletResponse response) {
		String tname = request.getParameter("teachname");
		
			Subject SubjectModel = new Subject(tname);
			Subject newSubject;
			newSubject= SubjectDao.saveSubject(SubjectModel);
			listSubject(request, response);
		
			return newSubject;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
