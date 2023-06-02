<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
    <%@page import="CRUD.*" %>
    <%@page import="java.util.ArrayList" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="Header.jsp" %>
<%
User_CRUD crud=new User_CRUD();
ArrayList<String> user=new ArrayList<String>();
user=crud.getUserById(Integer.parseInt(request.getParameter("id")));

%>

<h1>Add New User</h1>  
<form action="controller/edit_user.jsp" method="post">  
<table>  
<input name="id" value=<%= user.get(0) %> type="hidden" />
<tr><td>Name:</td><td><input type="text" name="name" value=<%= user.get(1) %> /></td></tr>  
<tr><td>Password:</td><td>  
<input type="password" name="password" value=<%= user.get(2) %>  /></td></tr>  
<tr><td>Email:</td><td><input type="text" name="email" value=<%= user.get(3) %> /></td></tr>  
<tr><td>Sex:</td><td>
<c:set var="sex" scope="session" value="" /> 

<input type="radio" name="sex" value="male" checked/>Male  
<input type="radio" name="sex" value="female" checked/>Female </td></tr>  

<tr><td>Country:</td><td>  
<select name="country" style="width:155px">  
<option >India</option>  
<option>Pakistan</option>  
<option>Afghanistan</option>  
<option>Berma</option>  
<option>Other</option>  
</select>  
</td></tr>  
<tr><td colspan="2"><input type="submit" value="Add User"/></td></tr>  
</table>  
</form> 

<jsp:include page="Footer.jsp" >
<jsp:param value="Add User" name="page"/>
</jsp:include>
</body>
</html>