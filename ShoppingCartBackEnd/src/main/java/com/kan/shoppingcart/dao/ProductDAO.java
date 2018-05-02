package com.kan.shoppingcart.dao;

import com.kan.shoppingcart.domain.Product;

public interface ProductDAO {
	public boolean save(Product product);
	public boolean update(Product product);
	public boolean delete(String id);
	public Product get(String id);
}

