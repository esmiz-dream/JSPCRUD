<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="common.Db_connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="common.User_Bean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
 
List<User_Bean> list=new ArrayList<User_Bean>();
Db_connection obj_db=new Db_connection();
Connection conn=obj_db.getConnection();
PreparedStatement ps=conn.prepareStatement("select * from user");
ResultSet rs=ps.executeQuery();

while(rs.next())
{
	User_Bean obj_user_bean=new User_Bean(); 
	obj_user_bean.setId(rs.getInt("id"));
	obj_user_bean.setName(rs.getString("name"));
	obj_user_bean.setPassword(rs.getString("password"));
	obj_user_bean.setEmail(rs.getString("email"));
	obj_user_bean.setSex(rs.getString("sex"));
	obj_user_bean.setCountry(rs.getString("country"));
	list.add(obj_user_bean);
 
}

%>
</body>
</html>