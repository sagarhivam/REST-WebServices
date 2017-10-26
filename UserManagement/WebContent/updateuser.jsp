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
<title>Add User</title>
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

<h3>Fill the following form to add user</h3>
<form action="WebService" method="POST">
<div class = "form-group">
<input type = "hidden" name = "action" value = "update">
 <label for="exampleInputId">Your Id</label>
		<input type="text" class= "form-control" name="id" />
		</div>
<div class = "form-group">
 <label for="exampleInputName">Your Name</label>
		<input type="text" class= "form-control" name="name" />
		</div>
<div class = "form-group">
 <label for="exampleInputDesignation">Your Designation</label>
		<input type="text" class= "form-control" name="designation" />
		</div>
<div class = "form-group">
 <label for="exampleInputEmail1">Your Salary</label>
		<input type="text" class= "form-control" name="salary" />
		</div>
	 <button type="submit" class="btn btn-primary">Update User</button>	
	 </form>
	 <br/>
	 <br/>
	 <br/>
	 <h3><a href="index.jsp">Go Back </a></h3>
</body>
</html>