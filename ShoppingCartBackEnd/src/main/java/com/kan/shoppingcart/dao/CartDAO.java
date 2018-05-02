package com.kan.shoppingcart.dao;

import com.kan.shoppingcart.domain.Cart;

public interface CartDAO {
	public boolean save(Cart cart);
	public boolean update(Cart cart);
	public boolean delete(String id);
	public Cart get(String id);
}

