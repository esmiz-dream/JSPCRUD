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
        <form action="AddUser" method="POST">
            <div class="card-body">
                <div class="form-group">
                    <label for="nameinput">Name</label> <input type="text"
                                                               class="form-control" id="nameinput" name="name"
                                                               placeholder="Enter name" >
                    <span id="nameinput" style="color:red; padding-left:20px;"> ${errName}</span>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label> <input
                        type="text" class="form-control" id="exampleInputEmail1"
                        name="email" placeholder="Enter email" >
                    <span id="erremail" style="color:red; padding-left:20px;"> ${errEmail}</span>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">Password</label> <input
                        type="password" class="form-control" name="password"
                        id="exampleInputPassword1" placeholder="Password" >
                    <span id="errpassword" style="color:red; padding-left:20px;"> ${errPassword}</span>
                </div>
                <div class="form-group">
                    <label>Country</label> <select class="form-control" name="country">
                        <option>India</option>
                        <option>Pakistan</option>
                        <option>Afghanistan</option>
                        <option>Berma</option>
                        <option>Other</option>
                    </select>
                    <span id="errcountry" style="color:red; padding-left:20px;"> ${errCountry}</span>
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
                    </div><br>
                    <span id="errsex" style="color:red; padding-left:20px;"> ${errSex}</span>
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
                        <span id="errphoto" style="color:red; padding-left:20px;"> ${errPhoto}</span>
                    </div>
                </div>
                <div class="form-check">
                    <input type="checkbox"  name="checkme" value="agree" class="form-check-input" id="exampleCheck1"
                           > <label class="form-check-label"
                           for="exampleCheck1">Check me to confirm police</label><br>
                    <span id="errCheckMe" style="color:red; padding-left:20px;"> ${errCheckMe}</span>
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