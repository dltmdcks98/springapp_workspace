package com.academy.shopping.aop;
/*
 * 쇼핑몰에서 상위 카테고리는 어디서건 보여줄 정보이므로
 * 어플리케이션에 횡단적 관심사에 해당
 * 따라서 상위 카테고리 목록을 가져오는 코드를 별도의 객체로 정의하여,
 * AOP 의 Aspect로 정의해놓고, 필요할때마다 이 코드를 관여시킨다.
 */
public class TopCategoryAspect {
	
	//이 메서드는, 쇼핑몰의 상위 카테고리를 필요로하는 모든 메서드에서 공통적으로 동작할 예정
	public Object getCategoryList() {
		System.out.println("컨트롤러가 동작할때 관여");
		return null;
	}
	
}
