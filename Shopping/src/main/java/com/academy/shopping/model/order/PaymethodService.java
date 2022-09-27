package com.academy.shopping.model.order;

import java.util.List;

import com.academy.shopping.model.domain.Paymethod;

public interface PaymethodService {
	public Paymethod select(int paymethod_id);
	public List selectAll();
	public void insert(Paymethod paymethod);
	public void delete(Paymethod paymethod);
	public void update(Paymethod paymethod);
}
