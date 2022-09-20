package com.academy.shopping.model.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.shopping.exception.SubCategoryException;
import com.academy.shopping.model.domain.SubCategory;

@Service
public class SubCategoryServiceImpl implements SubCategoryService{
	
	@Autowired
	private SubCategoryDAO subCategoryDAO;
	
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SubCategory select(int subcategory_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectByTopCategoryId(int topcategory_id) {
		// TODO Auto-generated method stub
		return subCategoryDAO.selectByTopCategoryId(topcategory_id);
	}

	@Override
	public void insert(SubCategory subCategory)throws SubCategoryException {
		subCategoryDAO.insert(subCategory);
	}

	@Override
	public void update(SubCategory subCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SubCategory subCategory) {
		// TODO Auto-generated method stub
		
	}
	
}
