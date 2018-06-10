<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h2>Categories</h2>
  <form action="category/save" method="post">
    <div class="form-group">
      <label for="categoryName">Category Name:</label>
      <input type="text" class="form-control" id="categoryName" placeholder="Enter Category Name" name="name" value=${selectedCategory.name}>
    </div>
    <div class="form-group">
      <label for="categoryName">Category Description:</label>
      <input type="text" class="form-control" id="categoryName" placeholder="Category Description" name="description" value = ${selectedCategory.description}>
    </div>
    
    
    
    
    <button type="submit" class="btn btn-default">Save</button>
  </form>
</div>



	<!--   display all the categories -->

	<div class="container">
  <h2>Category Table</h2>
              
  <table class="table">
    <thead>
      <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Date</th>
        <th>Modification</th>
      </tr>
    </thead>
    <tbody>
     <c:forEach var="category" items="${categories}">
     <tr>
        		<td>${category.name}</td>
				<td>${category.description}</td>
				<td>${category.added_date}</td>
				
				<td> <a href="category/delete/?name=${category.name}"> delete</a> 
				| <a href="category/edit/?name=${category.name}"> edit</a> </td>

      </tr>
      </c:forEach>
      
    </tbody>
  </table>
</div>

</body>
</html>