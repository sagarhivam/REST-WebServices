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
<title>Delete Specific User</title>
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

<h2 align = "center">REST Web Services Example Demo</h2>
<br/><br/><br/><br/>

<h3>Enter the Id to delete User</h3>
<form action="WebService" method="post">
<div class = "form-group">
	<input type = "hidden" name = "action" value = "delete">
 <label for="exampleInputId">Id</label>
		<input type="text" class= "form-control" name="id" />
		</div>
	 <button type="submit" class="btn btn-primary">Delete User</button>	
	 </form>
	 <br/>
	 <br/>
	 <br/>
	 <h3><a href="index.jsp">Go Back </a></h3>
</body>
</html>