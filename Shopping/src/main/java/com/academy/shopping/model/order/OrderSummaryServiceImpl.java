package com.academy.shopping.model.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.academy.shopping.exception.EmailException;
import com.academy.shopping.exception.OrderDetailException;
import com.academy.shopping.exception.OrderSummaryException;
import com.academy.shopping.model.domain.Member;
import com.academy.shopping.model.domain.OrderDetail;
import com.academy.shopping.model.domain.OrderSummary;
import com.academy.shopping.model.util.MailFormReader;
import com.academy.shopping.model.util.MailSender;

@Service
public class OrderSummaryServiceImpl implements OrderSummaryService {

	//주문 요약 관련 DAO
	@Autowired
	private OrderSummaryDAO orderSummaryDAO;
	
	//주문 상세 관련 DAO
	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private MailFormReader mailFormReader;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void order(OrderSummary orderSummary)throws OrderSummaryException,OrderDetailException,EmailException {
		// insert 호출 전 OrderSummary DTO 안의 ordersummary_id 값은 : 0
		orderSummaryDAO.insert(orderSummary); 
		//insert 호출 이후에는 OrderSummary DTO 안의 ordersummary_id 값은 : 가장 최근에 일으킨 시퀀스 값으로 대체
		System.out.println("주문성공후 시퀀스 값"+orderSummary.getOrdersummary_id());
		//구매한 물건 수 만큼
		for(int i=0; i<orderSummary.getOrderDetailList().size(); i++) {
			OrderDetail orderDetail = orderSummary.getOrderDetailList().get(i);
			
			//OrderDetail이 필요로하는 부모읜 foreign key 값을 대입
			orderDetail.setOrdersummary_id(orderSummary.getOrdersummary_id());
			orderDetailDAO.insert(orderDetail);
		}
		
		//이메일 발송
		String content = mailFormReader.getStringFromMailForm("test");
		mailSender.send(content);
		System.out.println("서비스에서의 mailform경로"+mailFormReader.getPath());
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return orderSummaryDAO.selectAll();
	}

	@Override
	public OrderSummary selectByCustomerId(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderSummary select(int ordersummary_id) {
		
		return orderSummaryDAO.select(ordersummary_id);
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
