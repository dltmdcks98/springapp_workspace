<%@page import="com.academy.shopping.model.domain.OrderSummary"%>
<%@page import="com.academy.shopping.model.domain.Paymethod"%>
<%@page import="com.academy.shopping.model.domain.Member"%>
<%@page import="com.academy.shopping.model.util.CurrencyFormatter"%>
<%@page import="com.academy.shopping.model.domain.Cart"%>
<%@page import="com.academy.shopping.model.domain.Product"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	OrderSummary orderSummary = (OrderSummary)request.getAttribute("orderSummary");
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
	       		<h2><%=orderSummary.getMember().getCustomer_name() %>주문이 완료되었습니다.</h2>
	       		<table width="100%" border="1px">
	       			<tr>
	       				<td>주문번호</td>
	       				<td><%=orderSummary.getOrdersummary_id() %></td>
	       			</tr>
	       			<tr>
	       				<td>총 결제금액</td>
	       				<td><%=orderSummary.getTotalpay() %></td>
	       			</tr>
	       			<tr>
	       				<td colspan="2"><a href="/shop">쇼핑계속하기</a></td>
	       			</tr>
	       		</table>
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