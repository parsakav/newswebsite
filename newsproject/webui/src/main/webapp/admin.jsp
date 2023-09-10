<%@ page import="org.example.User" %><%--
  Created by IntelliJ IDEA.
  User: parsa
  Date: 08.09.21
  Time: 02:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    if(request.getSession().getAttribute("loggedinuser")==null){
        response.sendRedirect("login.jsp");
    } else {
        User u= (User) request.getSession().getAttribute("loggedinuser");

        if(u.getRole_id()!=1){
            response.sendRedirect("index.jsp");
        }
    }
%>

<h1>Add news</h1>
<br/>
<form action="AdminController" method="post" enctype="multipart/form-data">
News title: <input type="text" name="news"/>
Choose a pic:<input required name="filenews" type="file" accept="image/*"/>
    <input required type="submit" value="Submit"/>

</form>

<br/>
<a href="index.jsp">Home page</a>
</body>
</html>
