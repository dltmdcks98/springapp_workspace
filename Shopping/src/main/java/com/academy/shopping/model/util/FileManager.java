package com.academy.shopping.model.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.academy.shopping.exception.FileException;
import com.academy.shopping.exception.UploadException;
import com.academy.shopping.model.domain.Product;

@Component
public class FileManager {
	
	//확장자 구하기
	public static String getExt(String path) {
		int index = path.lastIndexOf(".");//가장 마지막 .의 인덱스 구하기
		String ext= path.substring(index+1, path.length());
		return ext;
	}
	
	//파일과 관련된 유용한 기능을 구현한 객체
	public String save(Product product, String savePath) throws UploadException{
		MultipartFile multi= product.getPhoto();
		//파일 저장
		System.out.println(savePath);
		String ext = getExt(multi.getOriginalFilename());//파일명을 전달한 후, 확장자 변환
		long time=System.currentTimeMillis();
		
		try {
			multi.transferTo(new File(savePath+"/"+time+"."+ext));
		} catch (IllegalStateException e) {
			e.printStackTrace();
			throw new UploadException("업로드 실패",e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UploadException("업로드 실패",e);
		}
		System.out.println(multi.getOriginalFilename());
		
		return time+"."+ext;//파일명 변환
	}
	
	//엑셀파일 업로드
	public File saveExcel(String path, MultipartFile excel) {
		//서버에 올라온 엑셀을 읽어보자
		//1. 업로드부터 완료
		File file = null;
		try {
			excel.transferTo(file = new File(path+"/"+excel.getOriginalFilename()));
			System.out.println(file.getAbsolutePath());//파일의 절대경고
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;
	}
	
	//파일 삭제 
	public void removeFile(String path) throws FileException{
		File file = new File(path);//지정한 경로의 파일에 대한 객체를 생성
		 boolean result = file.delete();
		if(result==false) {
			throw new FileException("파일 삭제 실패");
		}
	}
	
	
	
	
	public static void main(String[] args) {
		String ext = getExt("d:://////.asdf.asdf.jpg");
		long time = System.currentTimeMillis();
		System.out.println(time+"."+ext);
	}
}
