<%--
  Created by IntelliJ IDEA.
  User: parsa
  Date: 08.09.21
  Time: 03:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
<%
    String txt=null;
    if(request.getSession().getAttribute("loggedinuser")==null){
txt="You are already logged out";
    } else{
        txt="Successful";
    }
%>
<%
request.getSession().setAttribute("loggedinuser",null);

%>
<h1>
<%=txt%>
</h1>
<br/>
<a href="index.jsp">Home page</a>
</body>
</html>
