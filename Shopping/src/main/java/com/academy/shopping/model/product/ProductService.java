package com.academy.shopping.model.product;

import java.util.List;

import com.academy.shopping.model.domain.Product;

public interface ProductService {
	public List selectAll();
	public List selectByTopId(int topcategory_id);
	public List selectBySubId(int subcategory_id);
	public Product select(int product_id);
	public void regist(Product product, String savePath); //DAO +File Upload
	public void update(Product product);
	public void delete(Product product);
}
