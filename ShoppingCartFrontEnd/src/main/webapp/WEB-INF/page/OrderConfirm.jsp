<%@include file="home.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">

<table align="center" class="table" >
	<tr bgcolor='pink'><td colspan='5'> <center>Your Order</center></td></tr>
	<tr bgcolor='orange'>
		<td>Product Name</td>
		<td>Price</td>
		<td>Quantity</td>
		<td>SubTotal</td>
		<td></td>
	</tr>
		
		<c:if test="${not empty listCartItems}">
		<c:forEach items="${listCartItems}" var="cartItem">
		<tr bgcolor='cyan'>
			<td>${cartItem.productName}</td>
			<td>${cartItem.price}</td>
			<td>${cartItem.quantity}</td>
			<td>${cartItem.price * cartItem.quantity}</td>
			<td><img src="<c:url value="/resources/${cartItem.productId}.jpg"/>" width="50" height="50"/></td>
		</tr>
		</c:forEach>
		</c:if>
		<tr bgcolor="red">
			<td colspan="3">Total Cost</td>
			<td>${totalCost}</td>
			<td colspan="2"></td>
		</tr>
</table>
<form action="paymentConfirmation" method="post">
<table align="center" width="50%">
	<tr bgcolor="orange"><td colspan="2"><center>Payment Details</center></td></tr>
	<tr bgcolor="cyan"><td colspan="2"><center><input type="radio" name="mode" value="CS">Cash
	<input type="radio" name="mode" value="CC">Credit Card</center></td></tr>
	<tr bgcolor="gray"><td colspan="2"><center><input type="submit" value="Proceed to Pay" class="btn btn-info"></center></td></tr>
</table>
</form>
</div>

