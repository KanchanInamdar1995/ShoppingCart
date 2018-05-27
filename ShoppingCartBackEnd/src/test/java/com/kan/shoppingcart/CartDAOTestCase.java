package com.kan.shoppingcart;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kan.shoppingcart.dao.CartDAO;
import com.kan.shoppingcart.domain.Cart;


public class CartDAOTestCase {



private static AnnotationConfigApplicationContext context;
	
	private static CartDAO cartDAO;
	
	private static Cart cart;
	@BeforeClass
	public static void initialize()
	{
	context=new AnnotationConfigApplicationContext();
	context.scan("com.kan");
	context.refresh();
	cartDAO = (CartDAO)context.getBean("cartDAO");
	cart = (Cart) context.getBean("cart");
			
	}
	//@Test
	public void saveCartTestCase()
	{
		cart= new Cart();
		cart.setEmailID("Shruti96@gmail.com");
		cart.setId(1);
		cart.setPrice(2500);
		cart.setProductName("Denim Jacket");
		cart.setQuantity(2);
		cart.setStatus('N');
		boolean result= cartDAO.save(cart);
		Assert.assertEquals("save user",true,result);
	}
//	//@Test
//	public void validateCredentialsSuccess()
//	{
//		user = userDAO.validate("Shruti@gmail.com", "shruti@123");
//		Assert.assertNotNull("validate test case" , user);
//	}
//	//@Test
//	public void validateCredentialsFailure()
//	{
//		user = userDAO.validate("Shruti@gmail.com", "shruti@1234");
//	
//	}
	@Test
	public void deleteCartTestCase()
	{
		boolean actual = cartDAO.delete(1);
		Assert.assertEquals(" delete cart test case",true, actual);
	}
	}
