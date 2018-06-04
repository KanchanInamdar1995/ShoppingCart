package com.kan.shoppingcart;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kan.shoppingcart.dao.ProductDAO;
import com.kan.shoppingcart.dao.UserDAO;
import com.kan.shoppingcart.domain.Product;
import com.kan.shoppingcart.domain.User;

import junit.framework.Assert;

public class ProductDAOTestCase {

private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private static Product product;
	
	
	@BeforeClass
	public static void initialize()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.kan");
		context.refresh();
		
		try {
			productDAO = (ProductDAO)context.getBean("productDAO");
			product = (Product) context.getBean("product");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	
	
	//write the test cases
	
	//@Test
	public void saveProductTestCase()
	{
		product.setId("PRD_MBL_002");
		product.setName("iPhone 6");
		product.setDescription("iPhone Product");
		//Mobile supposed be exist in the category table
		//we refered in product table - foreign
		product.setCategory_name("Mobile");
		product.setPrice(40000);
		//product.setAdded_date(added_date);  Take system date
		//in ProductDAOImpl
		//call save method and compare expected with actaul
		boolean actual =productDAO.save(product);
		
		Assert.assertEquals(true, actual);
	}
	@Test
	public void getProductSuccessTestCase()
	{
		
	  Assert.assertNotNull(productDAO.get("PRD_MBL_002"));
	}
	@Test
	public void getProductFailureTestCase()
	{
		
	  Assert.assertNull(productDAO.get("Books"));
	}
	//@Test
	public void updateProductSuccessTestCase()
	{
		product = productDAO.get("PRD_MBL_002");
		//update the description.
		product.setPrice(50000);
		Assert.assertEquals(true,  productDAO.update(product));
	}
	@Test
	public void updateProductFailureTestCase()
	{
		//Books product is not exist in our table
		product = productDAO.get("PRD_MBL_010");
		//it supposed be return null
		Assert.assertNull(product);
		
	}
	//@Test
	public void deleteProductSuccessTestCase()
	{
		Assert.assertEquals(true,   productDAO.delete("PRD_MBL_004"));
	}
	
	@Test
	public void deleteProductFailureTestCase()
	{
		Assert.assertEquals(false,   productDAO.delete("PRD_MBL_010"));
	}
	@Test
	public void getAllProductsTestCase()
	{
		//compare how many records are there in db and how many
		//are coming from dao.
	 Assert.assertEquals(3,	productDAO.list().size());
	}
	}