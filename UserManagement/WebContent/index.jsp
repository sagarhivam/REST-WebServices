
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="<c:url value='/sources/css/foundation.css'/>" />
<link rel="stylesheet" href="<c:url value='/sources/css/bootstrap.min.css'/>" />
<title>REST Web Services</title>
<style>
body, html
{
margin:10px;
padding:5px;
background-color:#f1f1f1;
text-align:center;
}
</style>
</head>
<body>
<h2 align = "center">REST Web Services Example Demo</h2>
<br/><br/><br/><br/>
<h3>In this example, what we will do is:</h3><br/>
<ol class = "list-group">
<li class = "list-group-item"><a href = "addUser.jsp">Add Users</a></li>
<li class = "list-group-item"><a href = "deleteuser.jsp">Delete User</a></li>
<li class = "list-group-item"><a href ="updateuser.jsp">Update User</a></li>
<li class = "list-group-item"><a href = "WebService">View all Users</a></li>
<li class = "list-group-item"><a href = "viewuser.jsp">View User(ID Specific)</a></li>
</ol>
<br/>
</body>
</html>
