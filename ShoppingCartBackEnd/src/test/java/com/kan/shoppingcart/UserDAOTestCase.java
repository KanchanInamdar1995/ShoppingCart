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
		user.setEmailID("Kanchan95@gmail.com");
		user.setName("Kanchan");
		user.setPassword("kanchan1995");
		user.setRole('C');
		user.setMobile("9075640385");
		user.setAddress("Thane");
		boolean result= userDAO.save(user);
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
	}


