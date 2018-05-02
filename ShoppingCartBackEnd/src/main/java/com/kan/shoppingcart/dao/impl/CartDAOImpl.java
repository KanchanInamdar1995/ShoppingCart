package com.kan.shoppingcart.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.kan.shoppingcart.dao.CartDAO;
import com.kan.shoppingcart.domain.Cart;
import com.kan.shoppingcart.domain.User;

public class CartDAOImpl implements CartDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public boolean save(Cart cart) {
		try {
			sessionFactory.openSession().save(cart);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Cart cart) {
		try {
			sessionFactory.openSession().update(cart);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(int id) {
		try {
			sessionFactory.openSession().delete(id);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Cart> list(String emailID) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
