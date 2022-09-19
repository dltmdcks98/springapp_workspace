package com.academy.shopping.model.domain;

import lombok.Data;

@Data
public class SubCategory {
	private int subcategory_id;
	private String category_name;
	
	private TopCategory topcategory;//자식 입장에서 1:1 association
}
