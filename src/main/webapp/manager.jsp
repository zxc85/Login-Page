<center>
 
<h2>
    <%
    if(session.getAttribute("login")==null || session.getAttribute("login")=="") //check if condition for unauthorize user not direct access welcome.jsp page
    {
        response.sendRedirect("index.jsp");
    }
    %>
    
    Welcome <%=session.getAttribute("role")%> <%=session.getAttribute("name")%>, <%=session.getAttribute("login")%> to a restricted website
</h2>

<h3>
    <a href="logout.jsp">Logout</a>
</h3>

</center>

