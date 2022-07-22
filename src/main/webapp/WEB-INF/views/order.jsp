<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="lotte.com.lottket.dto.*"%>
<%@ page import="java.text.DecimalFormat" %>
<%
request.setCharacterEncoding("utf-8");
OrderDto order = (OrderDto) request.getAttribute("order");
%>

<%!
public String priceToStr(long price){

    DecimalFormat decFormat = new DecimalFormat("###,###");

    String str = decFormat.format(price);
    System.out.println(str);

    return str;
}
%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>롯켓 온</title>
<link rel="icon" href="" type="image/x-icon">
<script src="https://kit.fontawesome.com/a9c109155d.js"
	crossorigin="anonymous"></script>
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/mypage.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/order.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/orderTitle.css">

<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />
<link rel="favicon" href="img/logo.png">


<!-- Demo styles -->
<style>
#cardCl{
background-color : #ECECEB;
border-radius : 8px;
}
.card_change:hover{
background-color : #F1F1F0;
border-radius : 8px;
}
#orderTitle{
    text-align: center;
    margin-bottom: 30px;
}
</style>
</head>

<body>
	<header id="header">
		<script src="<%=request.getContextPath()%>/js/header.js"></script>
	</header>



	<div id="content" class="checkout__wrap">
	<div id="orderTitle"><h1> 주문 / 결제 </h1></div>
		<div class="box__contents">
			<div class="section__left">
				<div class="section__checkout-info section__person-info">
					<div class="box__card box__card-person box__card-person--simple">
						<div class="box__inner">
							<div class="text__title">주문자 정보</div>
							<div class="box__form-control person-info__name">
								<div class="box__label">
									<label for="xo_id_buyer_name"
										class="sprite__checkout--after text__label">주문자</label>
								</div>
								<div class="box__input ">
								<input type="hidden" id="userid" name="userId" value=<%=order.getUserId() %> >
								<input type="hidden" id="get_amount" name="orderAmount" value=<%= order.getOrderAmount() %> >
								<input type="hidden" id="get_productId" name="productId" value=<%= order.getProductId() %> >
								<input type="hidden" id="get_totalPrice" name="productId" value=<%= order.getOrderTotalPrice()-order.getSalePrice() %> >

									<input type="text" id="xo_id_buyer_name" title="주문자"
										placeholder="이름을 입력해 주세요." class="input_txt" name="name"
										value=<%= order.getUserName()%> readonly>
								</div>
							</div>
							<div class="box__form-control person-info__tel">
								<div class="box__label">
									<label for="xo_id_buyer_phone_number"
										class="sprite__checkout--after text__label">배송 요청사항</label>
								</div>
								<div class="box__input ">
									<input type="tel" id="xo_id_buyer_phone_number dr"
										class="input_txt input_tel" title="배송 요청사항"
										placeholder="배송 요청사항을 입력해주세요" value=<%= order.getDeliveryRequirement() %> onchange='deliveryRequirement()'>
								</div>
							</div>


						</div>
					</div>
				</div>
				<div class="section__checkout-info section__delivery-info">
					<div class="box__card box__card-address box__card-address--new">
						<div class="box__inner">
							<div class="box__address-title">
								<h3 class="sprite__checkout--before text__title-address prev">배송지</h3>

							</div>
							<p id="text__address--new1" class="text__address--new">새로운 배송지를 추가해보세요!</p>
							<div class="box__button-group">
							<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
								<button onclick="openDaum()" type="button"
                                                           class="sprite__checkout--before button button__address-add"
                                                           id="xo_id_add_new_address" data-montelena-acode="200007105">배송지
                                                           추가</button>


                              <script>
                                  function openDaum() {
                                    new daum.Postcode({
                                      oncomplete: function(data) {
                                        console.log(data);
                                        document.getElementById("text__address--new1").innerText = data.address;
                                      }
                                    }).open();
                                  }
                                </script>

							</div>
							<div class="box__form-control person-info__tel">
                            								<div class="box__label" style="margin-right: 40px;">
                            									<label for="xo_id_buyer_phone_number"
                            										class="sprite__checkout--after text__label"></label>
                            								</div>
                            								<div class="box__input " style="margin-top: 8px">
                            									<input type="tel" id="detailAddress" style="width: 510px;"
                            										class="input_txt input_tel" title="배송 요청사항"
                            										placeholder="세부 주소를 입력해주세요" onchange='deliveryRequirement()'>
                            								</div>
                            							</div>



						</div>
					</div>
				</div>
				<section class="section__checkout-info section__paycase-info">
					<div class="box__card box__paycase-info">
						<div class="box__inner">
							<div class="text__title">결제수단</div>
							<div class="box__info box__payment-wrap">
								<div class="box__payment box__payment-default"
									id="xo_id_section_normal_pay">
									<div class="box__title box__custom-form">
										<input type="radio" name="payChk"
											id="xo_id_radio_button_large_method_normal"
											class="input__radio" data-montelena-acode="200007161"
											value="Normal" checked><label
											for="xo_id_radio_button_large_method_normal"
											class="text__pay-title">일반 결제</label>
									</div>
									<div class="box__pay-view" style="display: block;">
										<div class="box__pay-inner">
											<ul class="payway_lst list__tab list__tab-v2">
												<li class="list-item"><input type="radio"
													name="pay_chk" id="pay_chk_CreditCard" class="input__rdo"
													data-montelena-acode="200007162"
													data-montelena-medium_method="CreditCard"
													value="CreditCard" checked=""><label
													for="pay_chk_CreditCard">신용/체크카드</label></li>
												<li class="list-item"><input type="radio"
													name="pay_chk" id="pay_chk_VirtualAccount"
													class="input__rdo" data-montelena-acode="200007162"
													data-montelena-medium_method="CreditCard"
													value="VirtualAccount"><label
													for="pay_chk_VirtualAccount"></label></li>
											</ul>
											<div class="pay_openbx box__method-creditcard"
												style="display: block;">
												<div class="pay_open">
													<ul class="pay_lst_chk" role="tablist">
														<li role="none presentation" class="card_change" onclick= 'payment("현대카드", this)'>
														    <a role="tab" aria-selected="false" data-montelena-acode="200007163" data-montelena-medium_method="Unknown" >
														        <span class="sprite__payment ico_hd"></span>
														        <strong>현대카드</strong>
														    </a>
														</li>

														<li role="none presentation" class="card_change" onclick= 'payment("KB국민카드", this)' >
														    <a role="tab" aria-selected="false" data-montelena-acode="200007163" data-montelena-medium_method="Unknown" >
															    <span class="sprite__payment ico_kb"></span>
															    <strong>KB국민카드</strong>
															</a>
													    </li>

														<li role="none presentation" class="card_change" onclick= 'payment("신한카드", this)'>
														    <a role="tab" aria-selected="false" data-montelena-acode="200007163" data-montelena-medium_method="Unknown" >
														        <span class="sprite__payment ico_sh"></span>
														        <strong>신한카드</strong>
														    </a>
														</li>

														<li role="none presentation" class="card_change" onclick= 'payment("삼성카드" , this)'>
														    <a role="tab" aria-selected="false" data-montelena-acode="200007163" data-montelena-medium_method="Unknown" >
															    <span class="sprite__payment ico_ss"></span>
															    <strong>삼성카드</strong>
															</a>
													    </li>

														<li role="none presentation" class="card_change" onclick= 'payment("롯데카드", this)'>
														    <a role="tab" aria-selected="false" data-montelena-acode="200007163" data-montelena-medium_method="Unknown" >
															    <span class="sprite__payment ico_lotte"></span>
															    <strong>롯데카드</strong>
															</a>
													    </li>

														<li role="none presentation" class="card_change" onclick='payment("우리카드", this)'>
														    <a role="tab" aria-selected="false" data-montelena-acode="200007163" data-montelena-medium_method="Unknown" >
														        <span class="sprite__payment ico_wrbank"></span>
														        <strong>우리카드</strong>
														    </a>
														</li>

														<li role="none presentation" class="card_change" onclick= 'payment("하나카드", this)'>
														    <a role="tab" aria-selected="false" data-montelena-acode="200007163" data-montelena-medium_method="Unknown" >
															    <span class="sprite__payment ico_hana"></span>
															    <strong>하나카드</strong>
															</a>
														</li>

														<li role="none presentation" class="card_change" onclick= 'payment("비씨카드", this)'>
														    <a role="tab"
															aria-selected="false" data-montelena-acode="200007163"
															data-montelena-medium_method="Unknown" >
															    <span class="sprite__payment ico_bc"></span>
															    <strong>비씨카드</strong>
															</a>
														</li>

														<li role="none presentation" class="card_change" onclick= 'payment("NH농협카드", this)'>
														    <a role="tab"
															    aria-selected="false" data-montelena-acode="200007163"
															    data-montelena-medium_method="Unknown" >
															    <span
																class="sprite__payment ico_nh"></span>
																<strong>NH농협카드</strong>
															</a>
														</li>

														<li role="none presentation" class="card_change" onclick= 'payment("씨티카드", this)'>
														    <a role="tab"
															    aria-selected="false" data-montelena-acode="200007163"
															    data-montelena-medium_method="Unknown" >
															    <span
																class="sprite__payment ico_citi"></span>
																<strong>씨티카드</strong>
															</a>
														</li>

														<li role="none presentation" class="card_change" onclick= 'payment("G+하나카드", this)'>
														    <a role="tab"
															aria-selected="false" data-montelena-acode="200007163"
															data-montelena-medium_method="Unknown" >
															    <span
																class="sprite__payment ico_hanag"></span>
																<strong>G+하나카드</strong>
															</a>
														</li>

														<li role="none presentation" class="card_change" onclick= 'payment("G+우리e카드", this)'>
														    <a role="tab"
															    aria-selected="false" data-montelena-acode="200007163"
															    data-montelena-medium_method="Unknown" >
															<span
																class="sprite__payment ico_wrbank"></span>
																<strong>G+우리e카드</strong>
															</a>
														</li>
														<li role="none presentation" class="card_change" onclick= 'payment("카카오뱅크", this)'>
														    <a role="tab"
															aria-selected="false" data-montelena-acode="200007163"
															data-montelena-medium_method="Unknown" >
															<span
																class="sprite__payment ico_kakao"></span>
															<strong>카카오뱅크</strong>
															</a>
														</li>
													</ul>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
			<div class="section__right">
				<div class="section__right-inner">
					<div class="section__checkout-info section__order-info">
						<div class="box__card box__order-info">
							<div class="box__inner">
								<div class="text__title">
									주문상품 <span class="text__count">1</span>개
								</div>
								<div class="box__goods js-goods-space">
									<ul class="list__goods-view">
										<li class="list-item"><h4
												class="sprite__checkout--before text__company-title">
												<a class="link__minishop"
													href="http://minishop.gmarket.co.kr/goodtree1"
													target="_blank"><%= order.getProductCategory() %></a>
											</h4>
											<div class="box__goods-info">
												<div class="box__thmb">
													<a class="link__goods"
														href="http://item.gmarket.co.kr/Item?goodsCode=2506631602"
														target="_blank"><img
														src=<%= order.getProductImageUrl() %>
														width="86" height="86" alt="똥볶이 할멈 1~3권 세트"
														class="image__goods"></a>
												</div>
												<div class="box__info ">
													<div class="box__goods-name">
														<a
															href="http://item.gmarket.co.kr/Item?goodsCode=2506631602"
															class="text__goods-name" target="_blank"><%= order.getProductTitle() %></a>
													</div>
													<div class="box__option"></div>
													<div class="box__price">
														<span class="text__value"><%= priceToStr(order.getProductPrice()) %></span><span
															class="text__unit">원</span><span class="text__amount">
															/ <%=order.getOrderAmount() %> 개 </span>
													</div>
												</div>
											</div>
											<div class="box__delivery-charge">
												<span class="text__delivery">배송비</span><span
													class="text__delivery-charge">무료배송</span>
											</div></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="section__checkout-info section__payment-info">
						<div class="box__card box__payment-info">
							<div class="box__inner">
								<ul class="list__detail-price">
									<li class="list-item"><div class="box__option">
											<span class="text__title">상품금액</span><span class="text__num"><%= priceToStr(order.getOrderTotalPrice())%><span
												class="text__unit">원</span></span>
										</div></li>
									<li class="list-item list-discount"><div
											class="box__option">
											<button type="button" class="button__pay-option"
												aria-expanded="false" data-montelena-acode="200007074">
												<span class="text__title sprite__checkout--after">할인금액</span><span
													class="text__num">-<%= priceToStr(order.getSalePrice()) %><span class="text__unit">원</span></span>
											</button>
										</div>
										<ul class="box__sub-option">
											<li class="list-sub-option"><span class="text__title">판매자할인</span><span
												class="text__num">-1111<span class="text__unit">원</span></span></li>
										</ul></li>
									<li class="list-item"><div class="box__option">
											<button type="button" class="button__pay-option"
												aria-expanded="false" data-montelena-acode="200007075">
												<span class="text__title ">배송비</span><span class="text__num">0<span
													class="text__unit">원</span></span>
											</button>
										</div></li>
								</ul>
								<ul class="list__detail-price box__total-price">
									<li class="list-item list__total-price"><div
											class="box__option">
											<span class="text__title">총 결제금액</span><span
												class="text__num"><%= priceToStr(order.getOrderTotalPrice()-order.getSalePrice()) %><span class="text__unit">원</span></span>
										</div></li>
								</ul>
								<button type="button" class="button__total-price"
									data-montelena-acode="200007077">결제하기</button>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<input type="hidden" id="payment_card" >

	<footer id="footer">
		<script src="<%=request.getContextPath()%>/js/footer.js"></script>
	</footer>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

	<script type="text/javascript">
	    $('.button__total-price').on('click',function(){
	        let userid= document.getElementById('userid').value;
	        let orderAmount= document.getElementById('get_amount').value;
	        let productId= document.getElementById('get_productId').value;
	        let orderAddress=document.getElementById('text__address--new1').innerText;
	        let orderDetailAddress = document.getElementById('detailAddress').value;
	        let orderTotalPrice = document.getElementById('get_totalPrice').value;
	        let payment = document.getElementById('payment_card').value;
	        let deliveryRequirement = document.getElementById('xo_id_buyer_phone_number dr').value;

	        if(orderAddress == '새로운 배송지를 추가해보세요!') {
	            alert('배송지를 입력해주세요');
	            return;
            }
            else if( orderDetailAddress == ''){
                alert('상세 주소를 입력해주세요');
                return;
            }
            else if ( payment == ''){
                alert('결제수단을 선택해주세요');
                return;
            }
            else{
	        var form =document.createElement('form');
	        form.setAttribute('method','post');
	        form.setAttribute('action','<%=request.getContextPath()%>/makeOrder.do');
	        document.charset="utf-8";

	        let map = new Map();

	        map.set('userId',userid);
	        map.set('orderAmount',orderAmount);
	        map.set('productId',productId);
	        map.set('orderAddress',orderAddress);
	        map.set('orderDetailAddress',orderDetailAddress);
	        map.set('orderTotalPrice',orderTotalPrice);
	        map.set('payment',payment);
	        map.set('deliveryRequirement',deliveryRequirement);

	        for(let [key, value] of map){
	            var hiddenField= document.createElement('input');
                hiddenField.setAttribute('type','hidden');
                hiddenField.setAttribute('name',key);
                hiddenField.setAttribute('value',value);
                form.appendChild(hiddenField);
	        }

	        document.body.appendChild(form);
	        form.submit();
	        }
	    });

	    function payment(card, el){
	        let arr = document.getElementsByClassName('card_change');

            for(let i=0;i<arr.length;++i){
                arr[i].removeAttribute('id');
            }
	        el.id='cardCl';
	        $('#payment_card').val(card);


	    }
	</script>

</body>

</html>
