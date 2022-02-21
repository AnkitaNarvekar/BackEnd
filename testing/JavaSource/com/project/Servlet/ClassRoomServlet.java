package com.project.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.ClassRoomDao;
import com.project.model.ClassRoom;




public class ClassRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ClassRoomDao daoc=new ClassRoomDao();
   
    public ClassRoomServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch (action) 
			{
			case "list":
				 listClassRoom(request, response);
				 break;
			
			case "new":
				 listClassRoom(request, response);
				 break;
			
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	private List<ClassRoom> listClassRoom(HttpServletRequest request, HttpServletResponse response) {
		List<ClassRoom> listClassRoom = daoc.getAllClassRoom();
		try {
			
			HttpSession session = request.getSession();
			session.setAttribute("listClassRoom",listClassRoom);
			//response.sendRedirect("displayClassRoom.jsp");
			RequestDispatcher dispatcher = request.getRequestDispatcher("displayclass.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listClassRoom;
	}
	
	private ClassRoom createClassRoom (HttpServletRequest request, HttpServletResponse response) {
		String tname = request.getParameter("teachname");
		
			ClassRoom ClassRoomModel = new ClassRoom(tname);
			ClassRoom newClassRoom;
			newClassRoom= ClassRoomDao.saveClassRoom(ClassRoomModel);
			listClassRoom(request, response);
		
			return newClassRoom;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
