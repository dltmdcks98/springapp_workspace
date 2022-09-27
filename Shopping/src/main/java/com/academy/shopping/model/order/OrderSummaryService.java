package com.academy.shopping.model.order;

import java.util.List;

import com.academy.shopping.model.domain.Member;
import com.academy.shopping.model.domain.OrderSummary;

public interface OrderSummaryService {
	//주문처리
	public void order(OrderSummary orderSummary);//컨트롤러가 호출 : 주문요약+주문상세+배송정보
	
	public List selectAll();//관리자가 호출
	public OrderSummary selectByCustomerId(Member member);
	public OrderSummary select(int ordersummary_id);//주문한건 가져오기
	public void update(OrderSummary orderSummary);
	public void delete(OrderSummary orderSummary);
	
}
