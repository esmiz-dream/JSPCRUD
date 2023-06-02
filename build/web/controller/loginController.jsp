<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="common.LoginBean"%>
<%@page import="CRUD.*"%>
<%@page import="javax.servlet.*;"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	LoginBean loginbean = new LoginBean();
	loginbean.setEmail(email);
	loginbean.setPassword(password);
	out.println("requested as->" + loginbean.getEmail());
	out.println("requested as->" + loginbean.getPassword());
	User_CRUD crud = new User_CRUD();
	boolean status = crud.loginDao(loginbean);
	if (status) {
		session.setAttribute("user", loginbean.getName());
		out.println("loged as->" + loginbean.getName());
		
	%>
	reponse.sendRedirect("../index.jsp");
	<%
	} else {
	out.println("error loged as->");
	%>
	<jsp:forward page="../login.jsp"></jsp:forward>
	<%
	}
	%>

</body>
</html>