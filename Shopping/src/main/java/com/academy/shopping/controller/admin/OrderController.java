package com.academy.shopping.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.model.domain.OrderDetail;
import com.academy.shopping.model.domain.OrderSummary;
import com.academy.shopping.model.order.OrderDetailService;
import com.academy.shopping.model.order.OrderSummaryService;

@Controller
@RequestMapping("/admin")//공통 uri
public class OrderController {
	String TAG = this.getClass().getName();
	@Autowired
	private OrderSummaryService orderSummaryService;
	
	
	
	
	//주문 목록 요청 처리
	@GetMapping("/order/list")
	public ModelAndView getList(HttpServletRequest request) {
		
		List orderSummaryList = (List) orderSummaryService.selectAll();
		ModelAndView mav = new ModelAndView("admin/order/order_list");
		mav.addObject("orderSummaryList",orderSummaryList);
		
		return mav;
	}
	
	//주문 상세 정보 요청 처리
	@GetMapping("/order/detail")
	public ModelAndView getDetail(HttpServletRequest request, int ordersummary_id) {
		//주문 상세 목록
		OrderSummary orderSummary = orderSummaryService.select(ordersummary_id);
		ModelAndView mav = new ModelAndView("admin/order/order_detail");
		mav.addObject("orderSummary",orderSummary);
		return mav;
	}
}
