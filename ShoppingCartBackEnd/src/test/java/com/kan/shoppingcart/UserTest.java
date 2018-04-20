package com.kan.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.kan");
		context.refresh();
		//context.getBean("user");
		context.getBean("product");
		System.out.println("Bean is successfully created");
	}

}
