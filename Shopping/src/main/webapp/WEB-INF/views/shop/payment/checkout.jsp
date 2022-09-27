<%@page import="com.academy.shopping.model.domain.Paymethod"%>
<%@page import="com.academy.shopping.model.domain.Member"%>
<%@page import="com.academy.shopping.model.util.CurrencyFormatter"%>
<%@page import="com.academy.shopping.model.domain.Cart"%>
<%@page import="com.academy.shopping.model.domain.Product"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	Member member = (Member)request.getAttribute("member");
	List<Cart> cartList = (List)request.getAttribute("cartList") ;
	List<Paymethod> paymethodList = (List)request.getAttribute("paymethodList");
%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ashion Template">
    <meta name="keywords" content="Ashion, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ashion | Template</title>
	<%@ include file="../inc/css.jsp" %>
</head>

<body>
	<%@ include file="../inc/topbar.jsp" %>
	
    <!-- Breadcrumb Begin -->
    <div class="breadcrumb-option">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb__links">
                        <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                        <span>Shop</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->
 
	 <!-- Checkout Section Begin -->
	  <section class="checkout spad">
	       <div class="container">
	           <div class="row">
	               <div class="col-lg-12">
	                   <h6 class="coupon__link"><span class="icon_tag_alt"></span> <a href="#">Have a coupon?</a> Click
	                   here to enter your code.</h6>
	               </div>
	           </div>
	           <form id="pay-form">
	               <div class="row">
	                   <div class="col-lg-8">
	                       <h5>구매자</h5>
	                       <div class="row">
	                           <div class="col-lg-6 col-md-6 col-sm-6">
	                               <div class="checkout__form__input">
	                                   <p>회원 ID <span>*</span></p>
	                                   <input type="text" value="<%=member.getCustomer_id()%>">
	                               </div>
	                           </div>
	                           <div class="col-lg-6 col-md-6 col-sm-6">
	                               <div class="checkout__form__input">
	                                   <p>이름 <span>*</span></p>
	                                   <input type="text" value="<%=member.getCustomer_name()%>">
	                               </div>
	                           </div>
	                           <div class="col-lg-6 col-md-6 col-sm-6">
	                               <div class="checkout__form__input">
	                                   <p>Email <span>*</span></p>
	                                   <input type="text" value="<%=member.getCustomer_email()%>"> 
	                               </div>
	                           </div>
	                       </div>
	                       </div>
	                       <div class="col-lg-4">
	                           <div class="checkout__order">
	                               <h5>결재 정보</h5>
	                               <div class="checkout__order__product">
	                                   <ul>
	                                       <li>
	                                           <span class="top__text">구매 상품</span>
	                                           <span class="top__text__right">Total</span>
	                                       </li>
	                                       <%int total =0; %>
	                                       <%for(int i=0;i<cartList.size();i++){ %>
	                                       <%Cart cart = cartList.get(i);%>
	                                       <li><%=i+1 %>. <%=cart.getProduct_name() %><br /> 구매 개수 : <%=cart.getQuantity() %> </br><span><%=CurrencyFormatter.getCurrency(cart.getDiscount()*cart.getQuantity()) %>원</span></li>
	                              			<%total += cart.getDiscount()*cart.getQuantity(); %>
	                              			<%} %>
	                                   </ul>
	                               </div>
	                               <div class="checkout__order__total">
	                                   <ul>
	                                       <li>구매금액 </br><span><%=CurrencyFormatter.getCurrency(total) %>원</span></li>
	                                       <li>최종 결제금액 </br><span><%=CurrencyFormatter.getCurrency(total) %>원</span></li>
	                                   </ul>
	                               </div>
	                               <div class="checkout__order__widget">
	                               	<%for(int i=0; i<paymethodList.size(); i++) {%>
	                               	<%Paymethod paymethod = paymethodList.get(i);%>
	                                   <label for="o-acc<%=i%>">
	                                      <%=paymethod.getPayname() %>
	                                       <input type="radio" id="o-acc<%=i%>" name="paymethod.paymethod_id" value="<%=paymethod.getPaymethod_id()%>">
	                                       <span class="checkmark"></span>
	                                   </label>
	                                  <%} %>

	                                   
	                               </div>
	                               <button type="button" class="site-btn" onClick="pay()">Place oder</button>
	                           </div>
	                       </div>
	                   </div>
	                   	<input type="hidden" name="totalbuy" value="<%=total%>"> 
	           			<input type="hidden" name="totalpay" value="<%=total%>"> 
	               </form>
	           </div>
	       </section>
	  <!-- Checkout Section End -->
	
<!-- Instagram Begin -->
<%-- <%@ include file="../inc/insta.jsp" %> --%>

<%@ include file="../inc/footer.jsp" %>
<%@ include file="../inc/search.jsp" %>

<!-- Js Plugins -->
<%@ include file="../inc/plugin.jsp" %>
<script type="text/javascript">
function pay(){
	if(confirm("입력하신 정보로 결제를 진행할까요?")){
		//위의 정보 말고 포인트, 쿠폰, 배송정보 등 다양한 정보가 있으므로  post로 진행
		$("#pay-form").attr({
			action:"/shop/pay",
			method:"post"
		});
		$("#pay-form").submit();
	}
}

</script>
</body>

</html>