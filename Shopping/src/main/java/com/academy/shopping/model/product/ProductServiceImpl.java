package com.academy.shopping.model.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.academy.shopping.exception.FileException;
import com.academy.shopping.exception.ProductException;
import com.academy.shopping.exception.UploadException;
import com.academy.shopping.model.category.SubCategoryDAO;
import com.academy.shopping.model.domain.Product;
import com.academy.shopping.model.domain.SubCategory;
import com.academy.shopping.model.util.ExcelParser;
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
	
	@Autowired
	private ExcelParser excelParser;
	
	
	
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

	@Transactional(propagation = Propagation.REQUIRED)
	public void registByExcel(File file, String ori, String dest) {
		List<Product> productList=excelParser.getParseResult(file);
		
		
		for(Product product : productList) {
			//이미지를 서버에 저장(스프링과 상관없이 개발자의 javaSE 능력으로 해결)
			System.out.println("파일의 경로:"+ori+"/"+product.getProduct_img());
			
			FileOutputStream fos =null;
			FileInputStream fis =null;
			try {
				fis= new FileInputStream(ori+"/"+product.getProduct_img());//파일을 대상으로 빨아드림
				
				Long time = System.currentTimeMillis();
				String ext = fileManager.getExt(product.getProduct_img());//확장자
				String fileName= time+"."+ext;//최종적으로 결정된 파일명
				
				//기존 DTO에 생성된 파일명을 대체하자
				product.setProduct_img(fileName);
				
				fos= new FileOutputStream(dest+"/"+fileName);//개발자가 파일명을 생성해야함, empty한 파일 생성
				
				
				int data=-1;
				while(true) {
					data=fis.read();//1byte읽음
					if(data==-1)break;//멈추기 조건
					fos.write(data);//1byte출력
				}
				System.out.println("파일복사 완료");
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if(fos!=null) {
					try {
						fos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(fis!=null) {
					try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
			
			
			productDAO.insert(product);//레코드 한건 넣기
			
			try {
			//반복문 속도를 db insert를 못따라가서
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}
	
	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void remove(Product product,String dest) {
		// TODO Auto-generated method stub
		fileManager.removeFile(dest);//파일 삭제
		
		
		productDAO.delete(product);//db삭제
		
	}

}
