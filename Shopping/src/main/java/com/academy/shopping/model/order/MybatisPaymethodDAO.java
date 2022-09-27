package com.academy.shopping.model.order;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academy.shopping.exception.PaymethodException;
import com.academy.shopping.model.domain.Paymethod;

@Repository
public class MybatisPaymethodDAO implements PaymethodDAO {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	@Override
	public Paymethod select(int paymethod_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectAll() throws PaymethodException {
		// TODO Auto-generated method stub
		List paymethodList = sqlSessionTemplate.selectList("Paymethod.selectAll");
		if(paymethodList==null) {
			throw new PaymethodException("결제수단 목록 출력 오류");
		}
		return paymethodList;
	}

	@Override
	public void insert(Paymethod paymethod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Paymethod paymethod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Paymethod paymethod) {
		// TODO Auto-generated method stub
		
	}
	
}
