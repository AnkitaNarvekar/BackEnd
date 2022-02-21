<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fetch Details</title>
</head>
<body>

<%
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("index.jsp");
	}
%>
<center><h1>Learner's Academy</h1></center>
<h1>Welcome <% out.println(session.getAttribute("username")); %>
<div style="position:absolute;top:0;bottom:10px;right:10px; z-index:999" >
    <table>
    <tr>        
    <td>
	<form method="post" action="LogoutServlet">
	<input type="Submit" value="Logout" name="Logout">
	</form>
    </td>
    </tr>
    </table>
 </div>
<div style="text-align:center">
		 
			Student Management<br/>
			<a href="/testing/Student?action=list">List All Students</a><br/>
			<a href="createStudent.jsp">Add New Student</a><br/><br/>

			Teacher Management<br/>
			<a href="/testing/TeacherServlet?action=list">List All Teachers</a><br/>
			<a href="createTeacher.jsp">Add New Teacher</a><br/><br/>
		
			ClassRoom Management<br/>
			<a href="/testing/ClassRoomServlet?action=list">List All ClassRooms</a><br/>
			<a href="createClassRoom.jsp">Add New ClassRoom</a><br/><br/>
		
			Subject Management<br/>
			<a href="/testing/SubjectServlet?action=list">List All Subjects</a><br/>
			<a href="createSubject.jsp">Add New Subject</a><br/><br/>
</div>
	


</body>
</html>