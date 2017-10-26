<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<c:url value='/sources/css/foundation.css'/>" />
<link rel="stylesheet" href="<c:url value='/sources/css/bootstrap.min.css'/>" />
<title>Error Message</title>
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
<h2>${arrTemp}</h2>

<h3><a href = "index.jsp">Go to Homepage</a></h3>
</body>
</html>