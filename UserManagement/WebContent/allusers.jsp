
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
<title>List of all Users</title>
<style>
body, html
{
margin:10px;
padding:5px;
background-color:#f1f1f1;
}
</style>
</head>
<body>
<table class= "table">
<thead>
<tr><th>Employee Id</th><th>Employee Name</th><th>Designation</th><th>Salary</th></thead></tr>
<tbody>
<c:if test="${not empty arrTemp }">
  <c:forEach items="${arrTemp}" var="post">
   <tr>
     <th scope= "row">${post.id}</th>
     <td>${post.name}</td>
     <td>${post.designation}</td>
     <td>${post.salary}</td>
   </tr>
  </c:forEach>
  </c:if>
 <c:if test="${not empty id}">
<tr>
<th scope= "row">${id}</th>
     <td>${name}</td>
     <td>${designation}</td>
     <td>${salary}</td>
   </tr>
   </c:if>
  </tbody>
</table>

<h3><a href="index.jsp">Go Back </a></h3>
</body>
</html>