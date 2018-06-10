package com.kanchan.ceetee.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kanchan.ceetee.dao.CategoryDAO;
import com.kanchan.ceetee.dao.ProductDAO;
import com.kanchan.ceetee.dao.UserDAO;
import com.kanchan.ceetee.domain.Category;
import com.kanchan.ceetee.domain.Product;
import com.kanchan.ceetee.domain.User;

@Controller
public class AdminController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Category category;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private User user;
	
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private Product product;
	
	
	@Autowired
	private HttpSession httpSession;
	
	@GetMapping("/manage_categories")
	public ModelAndView manageCategories()
	{
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isAdminClickedManageCategories", true);
		//load all the categories and set to httpSession
		List<Category> categories =  categoryDAO.list();
		httpSession.setAttribute("categories", categories);
		
		return mv;
	}
	
	@GetMapping("/manage_suppliers")
	public ModelAndView manageSuppliers()
	{
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isAdminClickedManageSupplires", true);
		
		List<User> suppliers = userDAO.list('S');
		httpSession.setAttribute("suppliers", suppliers);
		
		return mv;
	}
	
	@GetMapping("/manage_products")
	public ModelAndView manageProducts()
	{
		ModelAndView mv = new ModelAndView("home");
		mv.addObject("isAdminClickedManageProducts", true);
		
		List<Product> products =  productDAO.list();
		httpSession.setAttribute("products", products);

		
		return mv;
	}

}





