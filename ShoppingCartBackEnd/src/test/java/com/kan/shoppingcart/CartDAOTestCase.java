package com.kan.shoppingcart;
import static org.junit.Assert.*;

import java.util.List;

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
	@Test
	public void addToCartTestCase()
	{
		Cart cart= new Cart();
		cart.setEmailID("piyush1995@gmail.com");
		//cart.setId(2);
		cart.setPrice(34999);
		cart.setProductName("Denim Jacket");
		//cart.setQuantity(2);
		//cart.setStatus('N');
		boolean result= cartDAO.save(cart);
		Assert.assertEquals("save user",true,result);
	}
	@Test
	public void updateCartTestCase()
	{
		
	Cart cart=	cartDAO.get(1);
	cart.setQuantity(5);
	Assert.assertEquals(true,  cartDAO.update(cart));
	
	}
	@Test
	public void getCartSuccessTestCase()
	{
	Assert.assertNotNull( cartDAO.get(1));
	}
	@Test
	public void getCartFailureTestCase()
	{
	Assert.assertNull( cartDAO.get(10));
	}
	//@Test 
	public void deleteCartTestCase()
	{
		Assert.assertEquals(true,	cartDAO.delete(3));
	}
	//@Test
	public void productDispatchedTestCase()
	{
	cart=	cartDAO.get(3);
	cart.setStatus('D');
	Assert.assertEquals(true,cartDAO.update(cart));
	
	}
	@Test
	public void dispatchAllTheProductsTestCase()
	{
	List<Cart> carts = 	cartDAO.list("shruti02@gmail.com");
	Assert.assertEquals(true,cartDAO.update(carts,'D'));
		
	}
	@Test 
	public void deliverAllTheProductsTestCase()
	{
	List<Cart> carts = 	cartDAO.list("piyush1995@gmail.com");
	Assert.assertEquals(true,cartDAO.update(carts,'L'));
		
	}
	}


