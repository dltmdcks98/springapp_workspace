package com.academy.shopping.model.category;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.academy.shopping.exception.TopCategoryException;
import com.academy.shopping.model.domain.TopCategory;

@Repository
public class MybatisTopCategory implements TopCategoryDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		
		return sqlSessionTemplate.selectList("TopCategory.selectAll");
	}	

	@Override
	public TopCategory select(int topcategory_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(TopCategory topCategory)throws TopCategoryException {
		int result= sqlSessionTemplate.insert("TopCategory.insert", topCategory);
		if(result==0) {
			throw new TopCategoryException("상위카테고리 등록실패");
		}
		
	}

	@Override
	public void update(TopCategory topCategory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TopCategory topCategory) {
		// TODO Auto-generated method stub
		
	}
	
}
 