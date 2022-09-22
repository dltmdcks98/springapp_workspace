package com.academy.shopping.model.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.academy.shopping.model.domain.Product;
import com.academy.shopping.model.domain.SubCategory;

//엑셀 파일을 분석하는 객체
@Component
public class ExcelParser {

	
	public List getParseResult(File file) {
		
		//엑셀을 간접적으로 해석하여 insert DAO 에게 시킬것
		//2003년 이후 버전에서의 전담객체 XSSF~~~
		
		//1)엑셀파일 접근 해제
		List productList = new ArrayList();//Product DTO를 담기 위함  
		try {
			
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			System.out.println("엑셀 접근 성공");
			
			//엑셀 파일의 구성 시트 접근 
			XSSFSheet sheet=workbook.getSheetAt(0);

			//하나의 row 접근
			int totalRow = sheet.getPhysicalNumberOfRows();//실제 사용자가 입력한 레코드 수
			System.out.println("현재 사용중인 row  수는 :"+totalRow);

			for(int j=1; j<totalRow; j++) {
				XSSFRow row=sheet.getRow(j);//한줄의 row 접근
				
				Product product = new Product();
				//하나의 row에 소속된 각 셀을 접근하자
				for(int i=0;i<row.getPhysicalNumberOfCells();i++) {
					XSSFCell cell=row.getCell(i);
				
					switch (i) {
					case 0:product.setProduct_name(cell.getStringCellValue());break;
					case 1:product.setBrand(cell.getStringCellValue());break;
					case 2:product.setPrice((int)cell.getNumericCellValue());break;
					case 3:product.setDiscount((int)cell.getNumericCellValue());break;
					case 4:product.setMemo(cell.getStringCellValue());break;
					case 5:product.setDetail(cell.getStringCellValue());break;
					case 6:product.setProduct_img(cell.getStringCellValue());break;
					case 7:
						SubCategory subCategory = new SubCategory();//자식 생성
						subCategory.setSubcategory_id((int)cell.getNumericCellValue());//자식에 pk넣기
						product.setSubcategory(subCategory);//product에 subcategory다시 대입
					}
				}
				productList.add(product);
			}
			System.out.println(productList);
			
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return productList;
	}
}
