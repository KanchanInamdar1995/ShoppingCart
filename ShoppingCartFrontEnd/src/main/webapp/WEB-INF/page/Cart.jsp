 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">

<table align="center" class="table" >
	<tr bgcolor='pink'><td colspan='6'> <center>Your Cart</center></td></tr>
	<tr bgcolor='orange'>
		<td>Product Name</td>
		<td>Price</td>
		<td>Quantity</td>
		<td>SubTotal</td>
		<td></td>
		<td>Operation</td>
	</tr>
		
		<c:if test="${not empty listCartItems}">
		<c:forEach items="${listCartItems}" var="cartItem">
		<form action="<c:url value="/updateCartItem/${cartItem.cartItemId}"/>" method="get">
		<tr bgcolor='cyan'>
			<td>${cartItem.productName}</td>
			<td>${cartItem.price}</td>
			<td><input type="text" name="qty" value="${cartItem.quantity}"/></td>
			<td>${cartItem.price * cartItem.quantity}</td>
			<td><img src="<c:url value="/resources/${cartItem.productId}.jpg"/>" width="50" height="50"/></td>
			<td>
			<a href="<c:url value="/deleteCartItem/${cartItem.cartItemId}"/>">Delete</a>
			<input type="submit" value="Update"/>
			</td>
		</tr>
		</form>
		</c:forEach>
		</c:if>
		<c:if test="${empty listCartItems}">
			<tr bgcolor='cyan'><td colspan="6"><center>You Have No Items in Cart</center></td></tr>
		</c:if>
		<tr bgcolor="red">
			<td colspan="3">Total Cost</td>
			<td>${totalCost}</td>
			<td colspan="2"></td>
		</tr>
		<tr bgcolor="cyan">
			<td colspan="3"><a href="<c:url value="/productPage"/>"><b>Continue Shopping</b></a></td>
			<td colspan="3"><a href="<c:url value="/orderConfirm"/>"><b>Checkout</b></a></td>
		</tr>
		
	
</table>

</div>

 