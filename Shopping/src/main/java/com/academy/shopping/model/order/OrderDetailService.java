package com.academy.shopping.model.order;

import java.util.List;

import com.academy.shopping.model.domain.OrderDetail;

public interface OrderDetailService {
	public List selectAll();
	public OrderDetail selectByOrderSummaryId(int ordersummary_id);
	public void insert(OrderDetail orderDetail);
	public void update(OrderDetail orderDetail);
	public void delete(OrderDetail orderDetail);
}
