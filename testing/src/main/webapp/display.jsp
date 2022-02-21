<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="java.util.List"%>
<%@page import="com.project.model.Student"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Students</title>
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
            <caption><h2>List of Students</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                
            </tr>
        
       <%--  <%
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","");
            Statement st=con.createStatement();
            
            ResultSet rs=st.executeQuery("select * from studentd");
            while(rs.next())
            {
         %> --%>
         
      <%--     <tr> --%>
          <%--     <td><%out.print(rs.getString(1));%></td>
             <td><%out.print(rs.getString("sname"));%></td>
             <td><%out.print(rs.getString("semail"));%></td>
               </tr>    
             --%>        
       
       <%--   <%    }%>--%>
        
      
        
       
          <c:forEach var="Student" items="${listStudent}">
           <%-- <c:forEach var="Student" items=session.getAttribute("listStudent")>--%>
               <tr>
                    <td><c:out value="${Student.studid}" /></td>
                    <td><c:out value="${Student.studname}" /></td>
                    <td><c:out value="${Student.studemail}" /></td> </tr>
         
         
          <%-- <td><% out.println(session.getAttribute("listStudent.studid")); %></td>--%>
        
           
       </c:forEach>
    
        </table>
        
    </div> 
</body>
</html>