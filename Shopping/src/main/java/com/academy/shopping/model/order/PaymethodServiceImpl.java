package com.academy.shopping.model.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.shopping.exception.PaymethodException;
import com.academy.shopping.model.domain.Paymethod;

@Service
public class PaymethodServiceImpl implements PaymethodService {
	
	@Autowired
	private PaymethodDAO paymethodDAO;

	@Override
	public Paymethod select(int paymethod_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectAll() throws PaymethodException{
		// TODO Auto-generated method stub
		return paymethodDAO.selectAll();
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
