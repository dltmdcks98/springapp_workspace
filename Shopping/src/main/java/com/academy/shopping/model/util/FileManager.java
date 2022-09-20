package com.academy.shopping.model.util;

import org.springframework.stereotype.Component;

@Component
public class FileManager {
	//확장자 구하기
	public static String getExt(String path) {
		int index = path.lastIndexOf(".");//가장 마지막 .의 인덱스 구하기
		String ext= path.substring(index+1, path.length());
		return ext;
	}
	
	//파일과 관련된 유용한 기능을 구현한 객체
	public void save() {
		
	}
	public static void main(String[] args) {
		System.out.println(getExt("d:://////.asdf.asdf.jpg"));
	}
}
