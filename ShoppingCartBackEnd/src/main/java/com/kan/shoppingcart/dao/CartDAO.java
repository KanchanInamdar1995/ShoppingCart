package com.kan.shoppingcart.dao;

import java.util.List;

import com.kan.shoppingcart.domain.Cart;

public interface CartDAO {
	public boolean save(Cart cart);
	public boolean update(Cart cart);
	public boolean delete(int id);
	public List<Cart> list(String emailID);
}
<<<<<<< HEAD
=======

>>>>>>> e5b5c9181fd7718802a86ebb69546cbb54d218a4
