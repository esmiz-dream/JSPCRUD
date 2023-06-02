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
	User_CRUD crud = new User_CRUD();
	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String email = request.getParameter("email");
	String sex = request.getParameter("sex");
	String country = request.getParameter("country");
	int status = crud.updateUser(id, name, password, email, sex, country);
	if (status == 1) {
		out.print("recored updated");
	} else {
		out.print("failed to update recored");
	}
	%>
</body>
</html>