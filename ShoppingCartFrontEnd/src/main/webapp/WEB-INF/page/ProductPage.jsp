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
<c:forEach items="${listProducts}" var="product">
		<div class = "col-sm-4 col-md-4">
			<a href="<c:url value="productDesc/${product.id}"/>">
			<img src = "<c:url value="resources/${product.id}.jpg"/>" width="100" height="150" alt = "Generic thumbnail">
			</a>
 			<p>
      	 		<h3>${product.name}</h3>
      	 		<h3>${product.price}</h3>
      		</p>
		</div>
</c:forEach>

</body>
</html>

