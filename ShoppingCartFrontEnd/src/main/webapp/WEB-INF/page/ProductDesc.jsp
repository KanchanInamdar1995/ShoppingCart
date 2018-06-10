
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
<div class="container">
	<table class="table" align="center">
	<tr>
		<td rowspan="6">
		<img src="<c:url value="/resources/${ProductInfo.id}.jpg"/>" width="300" height="500"/>
		</td>
		<td>Product ID</td><td>${ProductInfo.id}</td>
	</tr>
	<tr>
		<td>Price</td>
		<td>${ProductInfo.price}</td>
	</tr>
	<tr>
		<td>Product Name</td>
		<td>${ProductInfo.name}</td>
	</tr>	
	<tr>
		<td>Category</td>
		<td>${ProductInfo.category}</td>
	</tr>
	<tr>
		<td>Description</td>
		<td>${ProductInfo.description}</td>
	</tr>
	<tr>
		<td colspan="2">
		
			<form action="<c:url value="/addToCart/${ProductInfo.id}"/>" method="get">
				<table>
					<tr><td>Quantity</td>
						<td>
						<select name="quantity">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
						</td>
						<td>
						<input type="submit" value="AddToCart" class="btn btn-success btn-block"/>
						</td>
				</table>
			</form>
		
		</td>
	</tr>
	
	</table>
</div>
</body>
</html>