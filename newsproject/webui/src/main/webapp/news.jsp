<%@ page import="org.example.News" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: parsa
  Date: 08.09.21
  Time: 03:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>News</title>
</head>
<body>

<%
    if(request.getSession().getAttribute("loggedinuser")==null){
        response.sendRedirect("index.jsp");
    }
%>
<br/>
<%
List<News> news= (List<News>) request.getAttribute("news");
for(News n :news) {
    System.out.println(n.getFilepath());
    out.println("<img src="+n.getFilepath()+" />");


%>
<%--<%
%>
<img src="<%=n.getFilepath()%>" />--%>
<br>
<br>
<%=n.getTitle()%>
<%}%>
<br>
<a href="index.jsp">Home page</a>

</body>
</html>
