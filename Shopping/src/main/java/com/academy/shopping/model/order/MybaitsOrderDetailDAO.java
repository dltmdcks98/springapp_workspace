package com.academy.shopping.model.order;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.academy.shopping.exception.OrderDetailException;
import com.academy.shopping.model.domain.OrderDetail;

@Repository
public class MybaitsOrderDetailDAO implements OrderDetailDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public OrderDetail selectByOrderSummaryId(int ordersummary_id) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("OrderDetail.selectByOrderSummaryId", ordersummary_id);
	}

	@Override
	public void insert(OrderDetail orderDetail) throws OrderDetailException {
		// TODO Auto-generated method stub
		int result = sqlSessionTemplate.insert("OrderDetail.insert",orderDetail);
		if(result==0) {
			throw new OrderDetailException("주문상세 정보가 등록되지 못했습니다.");
		}
	}

	@Override
	public void update(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.update("OrderDetail.update", orderDetail);
	}

	@Override
	public void delete(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		sqlSessionTemplate.delete("OrderDetail.delete", orderDetail);
	}
	
	
}
