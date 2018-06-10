<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>User Registration Form</title>
</head>
<body>

<div class="container">
  <h2>User Registration</h2>
  <form action="save"method="post">
    <div class="form-group">
      <label for="eid">Email Id</label>
      <input type="text" class="form-control" id="eid" placeholder="Enter Email ID" name="emailID">
    </div>
    <div class="form-group">
      <label for="name">Name</label>
      <input type="text" class="form-control" id="name" placeholder="Enter Name" name="name">
    </div>
    <div class="form-group">
      <label for="mobile">Mobile</label>
      <input type="text" class="form-control" id="mobile" placeholder="Enter Mobile Number" name="mobile">
    </div>
    <div class="form-group">
      <label for="pass">Password</label>
      <input type="password" class="form-control" id="pass" placeholder="Enter Password" name="password">
    </div>
     <div class="form-group">
      <label for="cpass">Confirm Password</label>
      <input type="password" class="form-control" id="cpass" placeholder="Enter Password" name="ConfirmPassword">
    </div>
    <div class="form-group">
      <label for="address">Address</label>
      <input type="text" class="form-control" id="address" placeholder="Enter Address" name="address">
    </div>
    <div class="form-group">
      <label for="role">Role</label>
      <input type="text" class="form-control" id="role" placeholder="Enter Role(A,S,C)" name="role">
    </div>
    

    
    
    <button type="submit" class="btn btn-default">Register</button>
  </form>
</div>


</body>
</html>