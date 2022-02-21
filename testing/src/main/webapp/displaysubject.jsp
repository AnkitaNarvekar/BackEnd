<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List"%>
<%@page import="com.project.model.Subject"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Subjects</title>
</head>
<body>

<%
	if(session.getAttribute("username")==null)
	{
		response.sendRedirect("index.jsp");
	}
%>


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
 
<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Subjects</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
            </tr>
        
        <c:forEach var="Subject" items="${listSubject}">
           
               <tr>
                    <td><c:out value="${Subject.subid}" /></td>
                    <td><c:out value="${Subject.subname}" /></td>
                </tr>
         
       </c:forEach>
    
       
      
    
        </table>
        
    </div> 
</body>
</html>