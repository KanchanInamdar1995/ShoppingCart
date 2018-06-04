	package com.kan.shoppingcart.dao.impl;

import java.sql.Date
;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kan.shoppingcart.dao.CartDAO;
import com.kan.shoppingcart.domain.Cart;
import com.kan.shoppingcart.domain.User;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private Cart cart;
	private int getMaxValue() {

		// check what is the max value of id in cart table.

		try {
			int maxValue = (Integer) sessionFactory.getCurrentSession().createQuery("select max(id) from Cart").uniqueResult();
			return maxValue + 1;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 1;
		}

	}
	public boolean save(Cart cart) {
		try {
			cart.setAdded_date(new Date(System.currentTimeMillis()));
			// set status as 'N'
						cart.setStatus('N');

						// set quantity is 1 if not given by the custotmer
						if (cart.getQuantity() == 0) {
							cart.setQuantity(1);
						}
			cart.setId(getMaxValue());

			sessionFactory.getCurrentSession().save(cart);
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean update(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int id) {
		try {
			cart=get(id);
			if(cart==null)
			{
				return false;
			}
			
			sessionFactory.getCurrentSession().delete(cart);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public Cart get(int id) {
		// TODO Auto-generated method stub
		return	(Cart) sessionFactory.getCurrentSession().get(Cart.class, id);
	}

//	public List<Cart> list(String emailID) {
//
//		// select * from cart where emailID = ? and status = 'N'
//
//		return sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("emailID", emailID))
//				.add(Restrictions.eq("status", "N")).list();
//
//	}
	/**
	 * get all cart items which are not at delivery
	 */
	public List<Cart> list(String emailID) {

		// select * from cart where emailID = ? and status = 'N'

		return sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.add(Restrictions.eq("emailID", emailID))
				.add(Restrictions.not(Restrictions.eq("status", 'L'))).list();

	}

	public boolean update(List<Cart> carts, char status) {
		try {
			for(Cart cart : carts)
			{
				cart.setStatus(status);
				update(cart);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}


}