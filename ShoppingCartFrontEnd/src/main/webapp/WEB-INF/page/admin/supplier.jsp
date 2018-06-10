<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Supplier</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>


	<div class="container">
  <h2>Suppliers Detail</h2>
  <form action="supplier/save" method="post">

    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="emailID" value="${selectedSupplier.emailID}">
    </div>
    <div class="form-group">
      <label for="supplier">Supplier Name:</label>
      <input type="text" class="form-control" id="supplier name" placeholder="Enter Supplier Name" name="name" value="${selectedSupplier.name}">
    </div>
     
    
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
    </div>
   <div class="form-group">
      <label for="pwd">Confirm Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="confirm_password">
    </div>
    <div class="form-group">
      <label for="mobile">Mobile:</label>
      <input type="text" class="form-control" id="mobile" placeholder="Enter Contact Number" name="mobile" value="${selectedSupplier.mobile}">
    </div>
    <div class="form-group">
      <label for="address">Address:</label>
      <input type="textarea" class="form-control" id="address" placeholder="Enter address" name="address" value="${selectedSupplier.address}">
    </div>
    
    <button type="submit" class="btn btn-default">Save</button>
  </form>
</div>


	<!--  display the list of suppliers -->
	<div class="container">
  <h2>Supplier Table</h2>       
  <table class="table">
    <thead>
      <tr>
        <th>Email Id</th>
        <th>Name</th>
        <th>Mobile</th>
        <th>Address</th>
        <th>Date</th>
        <th>Modification</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="supplier" items="${suppliers}">
      
      <tr>
      
       <td>${supplier.emailID}</td>
				<td>${supplier.name}</td>
				<td>${supplier.mobile}</td>
				<td>${supplier.address}</td>
				<td>${supplier.added_date}</td>

				<td><a href="supplier/delete?emailID=${supplier.emailID}">
						Delete</a> <a href="supplier/edit?emailID=${supplier.emailID}">
						| Edit</a></td>
      </tr>
      </c:forEach>
      
    </tbody>
  </table>
</div>

</body>
</html>