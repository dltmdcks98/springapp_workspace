package com.academy.shopping.model.product;

import java.io.File;
import java.util.List;

import com.academy.shopping.model.domain.Product;

public interface ProductService {
	public List selectAll();
	public List selectByTopId(int topcategory_id);
	public List selectBySubId(int subcategory_id);
	public Product select(int product_id);
	public void regist(Product product, String savePath); //DAO +File Upload
	public void registByExcel(File file,String ori, String dest);//엑셀파일을 매개변수로 넘김
	public void update(Product product);
	public void delete(Product product);
}
