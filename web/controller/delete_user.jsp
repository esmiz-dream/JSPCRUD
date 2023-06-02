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
	int status = crud.delete_user(Integer.parseInt(request.getParameter("id")));

	if (status == 1) {
		out.print("deleted");
	} else {
		out.print("not deleted");
	}
	%>

</body>
</html>
