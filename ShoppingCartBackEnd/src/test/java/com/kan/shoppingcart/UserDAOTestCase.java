package com.kan.shoppingcart;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kan.shoppingcart.dao.UserDAO;
import com.kan.shoppingcart.domain.User;

public class UserDAOTestCase {



private static AnnotationConfigApplicationContext context;
	
	private static UserDAO userDAO;
	
	private static User user;
	@BeforeClass
	public static void initialize()
	{
	context=new AnnotationConfigApplicationContext();
	context.scan("com.kan");
	context.refresh();
	userDAO = (UserDAO)context.getBean("userDAO");
	user = (User) context.getBean("user");
			
	}
	@Test
	public void saveUserTestCase()
	{
		user= new User();
	
		user.setEmailID("sonali12@gmail.com");
		user.setName("Sonali");
		user.setPassword("Sonalee23");
		user.setRole('C');
		user.setMobile("9636543249");
		user.setAddress("Vimaan Nagar");
		boolean result= userDAO.save(user);
		Assert.assertEquals("save user",true,result);
	}
	@Test
	public void validateCredentialsSuccess()
	{
		//if the credentials are correct - will return user object
		//else will return null
		user = userDAO.validate("Shruti96@gmail.com", "shruti1996");
		
		//expecting is not null   --will compare with actual -- user
		Assert.assertNotNull("validate test case" , user);
	}
	@Test
	public void validateCredentialsFailure()
	{
		//if the credentials are correct - will return user object
		//else will return null
		user = userDAO.validate("Pooja@gmail.com", "pooja@1234");
		
		//expecting is not null   --will compare with actual -- user
		Assert.assertNull("validate test case" , user);
	}
	@Test
	public void deleteUserTestCase()
	{
		boolean actual = userDAO.delete("kalyani28@@gmail.com");
		Assert.assertEquals(" delete user test case",true, actual);
	}
	//the method which u get can only be updated
	@Test
	public void getUserTestCase()
	{
	user=	userDAO.get("Shruti96@gmail.com");
	Assert.assertNotNull(user);
	}
	@Test
	public void updateUserTestCase()
	{
	user=	userDAO.get("Shruti96@gmail.com");
	user.setAddress("Seawood darawe");
	
	
	boolean actual = userDAO.update(user);
	Assert.assertEquals(true, actual);
	}
	}
