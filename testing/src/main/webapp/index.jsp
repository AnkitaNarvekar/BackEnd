
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
    
    	<div class="container">
    	<div class="col-lg-12">
    		<div class="col-lg-6">
    
        <form style="text-align:center" name="form" method="post" action="LoginServlet">
        <h1>Learner's Academy</h1>
            Username:<input type="text" name="username" /><br/><br/>
            Password:<input type="password" name="password" /><br/><br/>
            <input type="Submit" value="Login" /><br/><br/>
           
        </form>
        
        <%
            if(request.getParameter("m")!=null)
            {
                out.print("Invalid username/password! Please try again!!");
            }
            %>
            
           </div>
    	</div>
    </div>
    </body>
</html>
