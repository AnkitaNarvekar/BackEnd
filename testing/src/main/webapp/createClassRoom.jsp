
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New ClassRoom</title>
</head>
<body>
<%
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("index.jsp");
	}
%>
	<center>
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
		<h1>ClassRoom Management</h1>
		<h2>
			
			<a href="/testing/ClassRoomServlet?action=list">List All ClassRooms</a>
			<form action="/testing/ClassRoomServlet" method="post">
				<table border="1" cellpadding="10">
					<h1>Add New ClassRoom</h1>
					<tr>
						<th>Name</th>
						<td><input type="text" name="teachname"></td>
					</tr>
					
					<tr>
						<td colspan="2" align="center">
						<input type="hidden"  name="action" value="new"/>
						<input type="submit" value="Add ClassRoom" /></td>
					</tr>
				</table>
			</form>
		</h2>
	</center>

</body>
</html>
