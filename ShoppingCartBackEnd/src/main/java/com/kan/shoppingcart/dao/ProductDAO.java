package com.kan.shoppingcart.dao;

import java.util.List;

import com.kan.shoppingcart.domain.Product;

public interface ProductDAO {
	public boolean save(Product product);
	public boolean update(Product product);
	public boolean delete(String id);
	public Product get(String id);
	public List<Product> list();
	//search for all products under 10k
	
		public List<Product> list(int amount);
		
		//search for all product where the cost is between 10k and 20k
		
		public List<Product> list(int minAmount, int MaxAmout);
		
		//search for all particular products 
		//where the cost is between 10k and 20k
		
		public List<Product> list(String productName, int minAmount, int MaxAmout);
		
}