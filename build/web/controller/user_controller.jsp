<%@page import="java.util.List"%>
<%@page import="common.User_Bean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="CRUD.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	String sex = request.getParameter("sex");
	String country = request.getParameter("country");

	User_CRUD user_insert = new User_CRUD();
	if (user_insert.addUser(name, password, email, sex, country) == 1) {
		out.print("1 user added");
	} else {
		out.print("user data not recorded");
	}
	%>




</body>
</html>