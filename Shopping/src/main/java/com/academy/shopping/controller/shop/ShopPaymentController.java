package com.academy.shopping.controller.shop;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.academy.shopping.model.category.TopCategoryService;
import com.academy.shopping.model.domain.Cart;
import com.academy.shopping.model.domain.Product;

@Controller
public class ShopPaymentController {
	
	@Autowired
	private TopCategoryService topCategoryService;
	
	//장바구니 목록 요청
	@GetMapping("/shop/cart/list")
	public ModelAndView getCartList(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView("shop/payment/cart");
	
		//로그인 한후, 장바구니에 물건 담기가 성공했다는 것은 세션에 객체가 담겨져 있다는 의미
		//따라서 세션에 들어있는 Product 출력
		HttpSession session = request.getSession();
		
		//순서가 없는 Map에서 객체들을 반복문으로 꺼내는 방법
		Enumeration<String> en=session.getAttributeNames();//key 값만 들어있다.
		
		List cartList = new ArrayList();
		while(en.hasMoreElements()) {//요소가 있는 동안
			String key = en.nextElement();
			Object obj= session.getAttribute(key);
			if(obj instanceof Cart) {
				Cart cart = (Cart)obj;
				System.out.println("상품의 이름과 pk는 : "+cart.getProduct_name()+","+cart.getProduct_id());
				cartList.add(cart);//장바구니 명단에 채우기
			}
			
		}
		mav.addObject("cartList",cartList);
		
		return mav;
		
	}
	
	@GetMapping("/shop/cart/quantity")
	public ModelAndView getQantity(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		
		return mav;
	}
}
