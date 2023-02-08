<%
    if(session.getAttribute("login")!=null)
    {
        response.sendRedirect("index.jsp");
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Java MVC Login & Register Script Using MySql</title>
        <script language="javascript">	
	function validate()
	{
            var first_name= /^[a-z A-Z]+$/; //pattern allowed alphabet a-z or A-Z 
            var last_name= /^[a-z A-Z]+$/; //pattern allowed alphabet a-z or A-Z 
            
            var fname = document.getElementById("fname"); //textbox id fname
            var uname = document.getElementById("uname"); //textbox id email
            var password = document.getElementById("password"); //textbox id password
				
            if(!first_name.test(fname.value) || fname.value=='') //apply if condition using test() method match the parameter for pattern allow alphabet only
            {
		alert("Enter Firstname Alphabet Only....!"); //alert message
                fname.focus();
                fname.style.background = '#f08080'; //set textbox color
                return false;                    
            }
	}		
	</script>
    </head>
    <body>
        
        <center>
            
            <h2>Register</h2>
            
            <form method="post" action="RegisterController" onsubmit="return validate();">
                
                Full Name   <input type="text" name="txt_name" id="fname"></br></br>
                User Name    <input type="text" name="txt_username" id="uname"></br></br>
                Password    <input type="password" name="txt_password" id="password"></br></br>
                Role       <select name="txt_role" id="role">
                                <option value="manager">Manager</option>
                                <option value="user">User</option>
                            </select></br></br>
                
                <input type="submit" name="btn_register" value="Register">
                
                <h3>You have a account? <a href="index.jsp">Login</a></h3>
                
            </form>
            
            <h3 style="color:red">
                <%
                    if(request.getAttribute("RegisterErrorMsg")!=null)
                    {
                        out.println(request.getAttribute("RegisterErrorMsg")); //get register fail error message from "RegisterController"
                    }
                %>
            </h3>
            
        </center>
    
    </body>
    
</html>
