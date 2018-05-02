package com.kan.shoppingcart.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kan.shoppingcart.dao.UserDAO;
import com.kan.shoppingcart.domain.User;
@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	// Get the Sesion Factory
	
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private User user;
	public boolean save(User user) {
		// get session from Session Factory
		// from SessionFactory
		// 1) Open new Session
		// 2) continue with Current Session
		try {
			user.setAdded_date(new Date (System.currentTimeMillis()));
			sessionFactory.getCurrentSession().save(user);
		} catch (Exception e) {
			return false;
		}
		// above line : opening session saving user in user table.

		// TODO Auto-generated method stub
		return true;
	}

	public boolean delete(String emailID) {
		try {
			user=get(emailID);
			if(user==null)
			{
				return false;
			}
			
			sessionFactory.getCurrentSession().delete(user);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (HibernateException e) {
			// if any exceptions, the complete error stack trace
			// will print on the console.
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public User get(String emailID) {
		//select * from User where emailID = ?
		
	return	(User) sessionFactory.getCurrentSession().get(User.class, emailID);
		
	}

	public List<User> list() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}
	@SuppressWarnings("deprecation")
	public User validate(String emailID, String password) {
		//will discuss tomorrow
		// TODO Auto-generated method stub
		return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("emailID", emailID))
				.add(Restrictions.eq("password", password)).uniqueResult();

}
}