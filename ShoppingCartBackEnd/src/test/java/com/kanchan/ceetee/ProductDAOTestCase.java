package com.kanchan.ceetee;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kanchan.ceetee.dao.ProductDAO;
import com.kanchan.ceetee.dao.UserDAO;
import com.kanchan.ceetee.domain.Product;
import com.kanchan.ceetee.domain.User;

import junit.framework.Assert;

public class ProductDAOTestCase {

private static AnnotationConfigApplicationContext context;
	
	private static ProductDAO productDAO;
	
	private static Product product;
	
	
	@BeforeClass
	public static void initialize()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.kanchan");
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
		product.setId("PRD_MBL_003");
		product.setName("RedMe");
		product.setDescription("RedM3 Product ");
		//Mobile supposed be exist in the category table
		//we refered in product table - foreign
		product.setCategory_name("Mobile");
		product.setPrice(15000);
		//product.setAdded_date(added_date);  Take system date
		//in ProductDAOImpl
		//call save method and compare expected with actaul
		boolean actual =productDAO.save(product);
		
		Assert.assertEquals(true, actual);
	}
	
	@Test
	public void getProductSuccessTestCase()
	{
		
	  Assert.assertNotNull(productDAO.get("PRD_MBL_001"));
	}
	
	@Test
	public void getProductFailureTestCase()
	{
		
	  Assert.assertNull(productDAO.get("Books"));
	}
	
	
	@Test
	public void updateProductSuccessTestCase()
	{
		product = productDAO.get("PRD_MBL_001");
		//update the description.
		product.setCategory_name("Mobile");
		Assert.assertEquals(true,  productDAO.update(product));
	}
	

	@Test
	public void updateProductFailureTestCase()
	{
		//Books product is not exist in our table
		product = productDAO.get("Jio");
		//it supposed be return null
		Assert.assertNull(product);
		
	}
	
	
	//@Test
	public void deleteProductSuccessTestCase()
	{
		Assert.assertEquals(true,   productDAO.delete("PRD_WOMEN_Saree_001"));
	}
	
	@Test
	public void deleteProductFailureTestCase()
	{
		Assert.assertEquals(false,   productDAO.delete("Baby"));
	}
	
	@Test
	public void getAllCategoriesTestCase()
	{
		//compare how many records are there in db and how many
		//are coming from dao.
	 Assert.assertEquals(2,	productDAO.list().size());
	}
	
	
	
	
	
	
	

}
