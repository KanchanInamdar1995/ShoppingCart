package com.kanchan.ceetee;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kanchan.ceetee.dao.CartDAO;
import com.kanchan.ceetee.dao.CategoryDAO;
import com.kanchan.ceetee.domain.CartItem;

public class CartDAOTest 
{

	static CartDAO cartDAO;
	
	@BeforeClass
	public static void preExecution()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.kanchan");
		context.refresh();
		
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}
	
	//@Test
	public void addCartTest()
	{
		CartItem cartItem=new CartItem();
		cartItem.setCartItemId(1);
		cartItem.setProductId("1003");
		cartItem.setProductName("RedMe");
		cartItem.setQuantity(2);
		cartItem.setStatus("NP");
		cartItem.setemailID("Rakesh@gmail.com");
		cartItem.setPrice(15000);
		
		assertTrue("Problem in Creating CartItem",cartDAO.addToCart(cartItem));
	}
}
