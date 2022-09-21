package com.academy.shopping.model.product;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.academy.shopping.exception.ProductException;
import com.academy.shopping.exception.UploadException;
import com.academy.shopping.model.category.SubCategoryDAO;
import com.academy.shopping.model.domain.Product;
import com.academy.shopping.model.domain.SubCategory;
import com.academy.shopping.model.util.FileManager;

@Service
public class ProductServiceImpl implements ProductService{
	
	//하위 카테고리 목록을 가져올 DAO
	@Autowired
	private SubCategoryDAO subCategoryDAO;
	
	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private FileManager fileManager;
	
	@Override
	public List selectAll() {
		return productDAO.selectAll();
	}
	
	@Override
	public List selectByTopId(int topcategory_id) {
		List<SubCategory> subCategoryList = subCategoryDAO.selectByTopCategoryId(topcategory_id);//SubCategory들의 목록을 반환
		
		List productList= new ArrayList();//서브카테고리마다 소속된 상품들을 누적시킬 리스트
		for(int i=0; i<subCategoryList.size();i++) {
			SubCategory subCategory = subCategoryList.get(i);
			List<Product> list=productDAO.selectBySubId(subCategory.getSubcategory_id());
			for(Product product:list) {//풀어서
				productList.add(product);//넣기
			}
		}
		
		return productList;
	}
	
	@Override
	public List selectBySubId(int subcategory_id) {
		return productDAO.selectBySubId(subcategory_id);
	}
	@Override
	public Product select(int product_id) {
		// TODO Auto-generated method stub
		return productDAO.select(product_id);
	}

	//regist = DAO의 insert + file Upload
	//2중 하나라도 안되면 무효
	@Transactional(propagation=Propagation.REQUIRED)
	public void regist(Product product,String savePath) throws UploadException, ProductException {
		String filename = fileManager.save(product,savePath);//file upload
		product.setProduct_img(filename);//새롭게 생성된 파일명 저장
		
		productDAO.insert(product);//DB저장
			
	}

	@Override
	public void registByExcel(File file) {
		
		//엑셀을 간접적으로 해석하여 insert DAO 에게 시킬것
		//2003년 이후 버전에서의 전담객체 XSSF

		
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
