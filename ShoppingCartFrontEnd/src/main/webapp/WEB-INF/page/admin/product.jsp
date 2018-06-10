<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <title>Bootstrap Example</title>
  
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<!-- create a form to save product -->


<div class="container">
  <h2>Product</h2>
  <form action="product/save/" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="pid">Product_Id</label>
      <input type="text" class="form-control" id="pid" placeholder="Enter Product ID" name="id">
    </div>
    <div class="form-group">
      <label for="pname">Product Name</label>
      <input type="text" class="form-control" id="pname" placeholder="Enter Product Name" name="name">
    </div>
    <div class="form-group">
      <label for="price">Price</label>
      <input type="text" class="form-control" id="price" placeholder="Enter Product Price" name="price" >
    </div>
    <div class="form-group">
      <label for="des">Description</label>
      <input type="text" class="form-control" id="des" placeholder="Describe Product" name="description">
    </div>
    <div class="form-group">
    <label for="category">Select Category</label>
    <select multiple class="form-control" id="category" name="cateoryName">
      <c:forEach var="category" items="${categories}">
<option value="${category.name}">${category.name}  </option> 
</c:forEach>

    </select>
  </div>
  <div class="form-group">
    <label for="productImg">Product Image</label>
  <input type="file" name ="productImage">
  
  </div>
    
    
    <button type="submit" class="btn btn-default">Save</button>
  </form>
</div>

<div class="container">
  <h2>Product details</h2>          
  <table class="table">
    <thead>
      <tr>
        <th>Product_Id</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Modification</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="p" items="${products}" >
      <tr>
       
<td>${p.id}</td>
<td>${p.name}</td>
<td>${p.description}</td>
<td>${p.price}</td>
<td> 
<a href="product/delete?id=${p.id}">Delete</a> <a href="product/edit?id=${p.id}"> | Edit</a>

   </td>


 </tr>


</c:forEach>
     
    </tbody>
  </table>
  <a href="productPage">Products</a>
  
</div>





</body>
</html>