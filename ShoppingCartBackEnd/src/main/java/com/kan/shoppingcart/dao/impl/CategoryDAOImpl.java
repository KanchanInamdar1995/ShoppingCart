package com.kan.shoppingcart.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kan.shoppingcart.domain.Category;

public class CategoryDAOImpl {
	@Autowired
	private SessionFactory sessionFactory;
	public boolean save(Category category) {
		try {
			sessionFactory.openSession().save(category);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Category category) {
		try {
			sessionFactory.openSession().update(category);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean delete(String name) {
		try {
			sessionFactory.openSession().delete(name,Category.class);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
