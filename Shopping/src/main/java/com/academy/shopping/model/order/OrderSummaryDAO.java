package com.academy.shopping.model.order;

import java.util.List;

import com.academy.shopping.model.domain.Member;
import com.academy.shopping.model.domain.OrderDetail;
import com.academy.shopping.model.domain.OrderSummary;

import lombok.Data;

public interface OrderSummaryDAO {
	public List selectAll();
	public void insert(OrderSummary orderSummary);
	
	public OrderSummary selectByCustomerId(Member member);//회원용
	
	public OrderSummary select(int ordersummary_id);//관리자용
	public void update(OrderSummary orderSummary);
	public void delete(OrderSummary orderSummary);
	
}
