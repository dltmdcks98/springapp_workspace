package com.academy.shopping.model.product;

import java.util.List;

import com.academy.shopping.model.domain.Product;

public interface ProductDAO {
	public List selectAll();
	public Product select(int product_id);
	public void insert(Product product);
	public void update(Product product);
	public void delete(Product product);
}
