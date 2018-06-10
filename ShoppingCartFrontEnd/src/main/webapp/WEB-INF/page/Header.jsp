<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
h3
{
font-family:Monotype Corsiva;
font-size:15;
color:red
}
.footer {
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   background-color: red;
   color: white;
   text-align: center;
}

.auto-style1 {
	text-align: center;
	background-color: #800080;
}
.auto-style2 {
	background-color: #800080;
}
.auto-style3 {
	background-color: #008080;
}
.auto-style4 {
	background-color: #C0C0C0;
}
.auto-style5 {
	font-variant: small-caps;
	font-size: medium;
	font-family: Verdana, Geneva, Tahoma, sans-serif;

</style>
</head>
<body>

<nav class="navbar navbar-inverse">
<div class="container">
	<div class="navbar-header">
      <a class="navbar-brand" href="#">Gadget Guru</a>
    </div>
    
    <ul class="nav navbar-nav">
      <c:if test="${!sessionScope.loggedIn}">
      <li class="active"><a href="/">Home</a></li>
      <li><a href="login">LOGIN</a></li>
      <li><a href="register">REGISTER</a></li>
      <li><a href="contactus">CONTACT US</a></li>
      <li><a href="aboutus">ABOUT US</a></li>
      </c:if>
      <c:if test="${sessionScope.loggedIn}">
      	<c:if test="${sessionScope.role=='A'}">
      		<li><a href="#">Home</a></li>
      		<li><a href="product">MANAGE PRODUCT</a></li>
      	</c:if>
      	<c:if test="${sessionScope.role=='C'}">
      		<li><a href="#">Home</a></li>
      		<li><a href="<c:url value="/productPage"/>">Products</a></li>
      	</c:if>
      </c:if>
    </ul>
    
    <div class="nav nav-bar navbar-right">
    	<c:if test="${sessionScope.loggedIn}">
    	<a href="<c:url value="/showCart"/>">
          <span class="glyphicon glyphicon-shopping-cart"></span>
        </a>
    	<font color="White" face="calibri" size='3'>${CartItems}&nbsp;Welcome ${sessionScope.username}</font>
    	<a href="perform_logout">LOGOUT</a>
    	</c:if>
    </div>
</div>
</nav>