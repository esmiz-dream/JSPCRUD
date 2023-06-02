<%@page import="java.util.Iterator"%>
<%@page import="common.User_Bean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="CRUD.*"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/WEB-INF/fragments/dashbord.jsp" />
<%
User_CRUD crud = new User_CRUD();
List<User_Bean> list = crud.allUserByDao();
Iterator<User_Bean> userlist = list.iterator();
%>

<div class="content-wrapper" style="min-height: 600.4px;">
	<div class="card mx-auto" style="width: 90%">
		<div class="card-header">
			<h3 class="card-title">Users</h3>

			<div class="card-tools">
				<div class="input-group input-group-sm" style="width: 250px;">
					<input type="text" name="table_search"
						class="form-control float-right" placeholder="Search">

					<div class="input-group-append">
						<button type="submit" class="btn btn-default">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<!-- /.card-header -->
		<div class="card-body p-0">
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th style="width: 10px">Id</th>
						<th>Name</th>
						<td>Password</td>
						<td>Email</td>
						<td>Gender</td>
						<td>Country</td>
						<td>Action</td>
					</tr>
				</thead>
				<tbody>
					<%
					while (userlist.hasNext()) {
						User_Bean obj_user_bean = new User_Bean();
						obj_user_bean = userlist.next();
					%>
					<tr>
						<td><%=obj_user_bean.getId()%></td>
						<td><%=obj_user_bean.getName()%></td>
						<td><%=obj_user_bean.getPassword()%></td>
						<td><%=obj_user_bean.getEmail()%></td>
						<td><%=obj_user_bean.getSex()%></td>
						<td><%=obj_user_bean.getCountry()%></td>
						<td><a href="edit_user.jsp?id=<%=obj_user_bean.getId()%>"><i
								class="fas fa-edit"></i></a> <a
							href="controller/delete_user.jsp?id=<%=obj_user_bean.getId()%>"><i
								class="fas fa-trash" style="color: red; margin-left: 5px;"></i></a>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
		<!-- /.card-body -->
	</div>
</div>

<!-- Main Footer -->
<jsp:include page="/WEB-INF/fragments/footer.jsp" />