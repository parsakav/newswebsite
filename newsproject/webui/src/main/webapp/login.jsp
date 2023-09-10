<%--
  Created by IntelliJ IDEA.
  User: parsa
  Date: 07.09.21
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>


</head>
<body>
<%
if(request.getSession().getAttribute("loggedinuser")!=null){
    response.sendRedirect("index.jsp");
}
%>
<%
String loginstatus= (String) request.getAttribute("login");
request.setAttribute("login",null);

if(loginstatus!=null){
%>

<%=loginstatus%>
<%loginstatus=null;
}%>

<form action="LoginController" method="post">
    <label for="name">Username: </label>
    <input  required id ="name" type="text" name="name" placeholder="Please type your username"/>
    <br/>
    <label  for="pass">Password: </label>

    <input required type="password"  id="pass" name="pass" placeholder="Please type your password"/>
<%--    <br>
    <label for="role">Password</label>

    <input id="role" type="text" name="role" placeholder="Are you user or admin?please type"/>--%>
<br>
<input type="submit" name="Login"value="Login">

</form>

<br/>
<a href="index.jsp">Home page</a>
</body>
</html>
