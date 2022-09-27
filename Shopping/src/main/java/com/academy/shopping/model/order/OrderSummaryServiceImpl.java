package com.academy.shopping.model.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.shopping.model.domain.Member;
import com.academy.shopping.model.domain.OrderSummary;

@Service
public class OrderSummaryServiceImpl implements OrderSummaryService {

	//주문 요약 관련 DAO
	@Autowired
	private OrderSummaryDAO orderSummaryDAO;
	
	//주문 상세 관련 DAO
	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	@Override
	public void order(OrderSummary orderSummary) {
		// insert 호출 전 OrderSummary DTO 안의 ordersummary_id 값은 : 0
		orderSummaryDAO.insert(orderSummary); 
		//insert 호출 이후에는 OrderSummary DTO 안의 ordersummary_id 값은 : 가장 최근에 일으킨 시퀀스 값으로 대체
		
		//구매한 물건 수 만큼
		orderDetailDAO.insert(null);
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderSummary selectByCustomerId(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderSummary select(int ordersummary_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(OrderSummary orderSummary) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(OrderSummary orderSummary) {
		// TODO Auto-generated method stub
		
	}
 
}
