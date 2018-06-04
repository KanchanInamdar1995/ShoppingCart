package com.kan.shoppingcart.dao;

import java.util.List;

import com.kan.shoppingcart.domain.Category;

public interface CategoryDAO {

	public boolean save(Category category);
	public boolean update(Category category);
	public boolean delete(String name);
	public Category get(String name);
	public List<Category> list();
}
