package com.academy.shopping.model.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.shopping.exception.ProductException;
import com.academy.shopping.model.domain.Product;
import com.academy.shopping.model.util.FileManager;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private FileManager fileManager;
	
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product select(int product_id) {
		// TODO Auto-generated method stub
		return null;
	}

	//regist = DAO의 insert + file Upload
	@Override
	public void regist(Product product) throws ProductException {
		fileManager.save();//file upload
	
		productDAO.insert(product);//DB저장
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		
	}

}
