<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<jsp:include page="/WEB-INF/fragments/dashbord.jsp" />

<div class="content-wrapper justify-center" style="min-height: 600.4px;">
	<div class="card mx-auto" style="width: 90%">
		<div class="card-header">
			<h3 class="card-title">Add New User</h3>
		</div>
		<!-- /.card-header -->
		<!-- form start -->
		<form action="controller/user_controller.jsp" method="post">
			<div class="card-body">
				<div class="form-group">
					<label for="nameinput">Name</label> <input type="text"
						class="form-control" id="nameinput" name="name"
						placeholder="Enter name" required>
				</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Email address</label> <input
						type="email" class="form-control" id="exampleInputEmail1"
						name="email" placeholder="Enter email" required>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input
						type="password" class="form-control" name="password"
						id="exampleInputPassword1" placeholder="Password" required>
				</div>
				<div class="form-group">
					<label>Country</label> <select class="form-control" name="country"
						required>
						<option>India</option>
						<option>Pakistan</option>
						<option>Afghanistan</option>
						<option>Berma</option>
						<option>Other</option>
					</select>
				</div>

				<div class="form-group clearfix">
					<label>Gender</label><br>
					<div class="icheck-success d-inline">
						<input type="radio" name="sex" value="male" id="radioSuccess1">
						<label for="radioSuccess1">Male </label>
					</div>
					<div class="icheck-success d-inline">
						<input type="radio" name="sex" value="female" id="radioSuccess2">
						<label for="radioSuccess2">Female </label>
					</div>
				</div>
				<div class="form-group">
					<label for="exampleInputFile">File input</label>
					<div class="input-group">
						<div class="custom-file">
							<input type="file" class="custom-file-input"
								id="exampleInputFile" name="photo"> <label
								class="custom-file-label" for="exampleInputFile">Upload
								Photo</label>
						</div>
						<div class="input-group-append">
							<span class="input-group-text">Upload</span>
						</div>
					</div>
				</div>
				<div class="form-check">
					<input type="checkbox" class="form-check-input" id="exampleCheck1"
						required> <label class="form-check-label"
						for="exampleCheck1">Check me out</label>
				</div>
			</div>
			<!-- /.card-body -->

			<div class="card-footer">
				<button type="submit" class="btn btn-primary" value="Add User">Submit</button>
			</div>
		</form>
	</div>
</div>

<!-- Main Footer -->
<jsp:include page="/WEB-INF/fragments/footer.jsp" />