package com.academy.shopping.model.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;


@Data
public class Product {
	private int product_id;
	private String product_name;
	private String brand;
	private int price;
	private int discount;
	private String memo;
	private String detail;
	private String product_img;
	private MultipartFile photo; //업로드를 내부적으로 자동으로 처리해주는 객체
	private SubCategory subcategory;//1:1 association
}
