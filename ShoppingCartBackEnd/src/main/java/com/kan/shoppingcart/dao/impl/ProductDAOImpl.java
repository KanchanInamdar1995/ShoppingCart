package com.kan.shoppingcart.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kan.shoppingcart.dao.ProductDAO;
import com.kan.shoppingcart.domain.Product;
import com.kan.shoppingcart.domain.User;
@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Product product;
	public boolean save(Product product) {
		try {
			product.setAdded_date(new Date(System.currentTimeMillis()));
			sessionFactory.getCurrentSession().save(product);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		// TODO Auto-generated method stub
		return true;
	}

	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		// TODO Auto-generated method stub
		return true;
	}

	public boolean delete(String name) {
		try {
			//if the product exist, then only delete
			Product product = get(name);
			if(product==null)
			{
				return false;
			}
			sessionFactory.getCurrentSession().delete(product);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Product get(String id) {
		return	(Product) sessionFactory.getCurrentSession().get(Product.class,id);
	}

	public List<Product> list() {
		return	sessionFactory.getCurrentSession().createQuery("from Product").list();
	}

	public List<Product> list(int amount) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> list(int minAmount, int MaxAmout) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> list(String productName, int minAmount, int MaxAmout) {
		// TODO Auto-generated method stub
		return null;
	}

}