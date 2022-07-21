<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="lotte.com.lottket.dto.*"%>
<%@ page import="java.text.DecimalFormat" %>
<%
request.setCharacterEncoding("utf-8");
List<ProductDto> productList = (List<ProductDto>) request.getAttribute("productList");
String category = (String) request.getAttribute("category");

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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>롯켓 온</title>
<link rel="icon" href=""
	type="<%=request.getContextPath()%>/image/x-icon">
<script src="https://kit.fontawesome.com/a9c109155d.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/category.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/category/title.css">
<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />
<link rel="favicon" href="<%=request.getContextPath()%>/img/logo.png">

<!-- Demo styles -->
<style>
</style>
</head>

<script>
	function get_query() {
		var url = document.location.href;
		var qs = url.substring(url.indexOf('?') + 1).split('&');
		for (var i = 0, result = {}; i < qs.length; i++) {
			qs[i] = qs[i].split('=');
			result[qs[i][0]] = decodeURIComponent(qs[i][1]);
		}
		return result;
	}
</script>


<body>
	<header id="header">
		<script src="<%=request.getContextPath()%>/js/header.js"></script>
	</header>

	<div id="container">

		<div id="content" class="content_cctg com_tmpl">
			<!-- 카테고리 타이틀-->
			<div class="cctg_subtit" id="area_disp_ctg_title">
				<h2>
					<a class="notranslate clickable"
						data-react-tarea="카테고리_중소세|카테고리 타이틀|카테고리명 선택"
						href="/disp/category.ssg?dispCtgId=6000093747"> <%= category %></a>
				</h2>

				<div class="aside_txt notranslate" id="item_count">
					<span class="tx_ko"><em>28,291</em> 개의 상품이 있습니다.</span>

					<div class="alg_right">

						<ul class="cm_sns">
							<ul class="cm_sns">

							</ul>
						</ul>
					</div>
				</div>
			</div>


			<div id="container">

				<div class="tmpl_sort_wrap" id="area_sort">
					<ul class="tmpl_check etc_multi_toggle_filter notranslate" id="top_shpp_filter">
						<li class="productPrice">
						    <span class="custom_rdo ">
						        <input type="radio" id="emart_de" name="shppClsFilter" class="clickable" data-react-tarea="대카테고리|자주쓰는 배송필터|이마트 쓱배송"
								    data-ilparam-type="shpp" data-ilparam-value="ssgem">
								    <label for="emart_de">
								        <span class="brd_txt">낮은 가격 순 조회</span>
								    </label>
						    </span>
						</li>

						<li class="regDate">
						    <span class="custom_rdo">
						        <input type="radio" id="beneFilter_SMon" name="shppClsFilter" class="clickable"
								    data-react-tarea="대카테고리|자주쓰는 배송필터|새벽배송" data-ilparam-type="shpp"
								    data-ilparam-value="smon" data-ilparam-text="새벽배송">
								    <label for="beneFilter_SMon">
								        <span class="brd_txt">최신 상품 순</span>
								    </label>
						    </span>
						</li>

						<li class="totalRate">
						    <span class="custom_rdo">
						        <input type="radio"
								id="sm_de" name="shppClsFilter" class="clickable"
								data-react-tarea="대카테고리|자주쓰는 배송필터|백화점 상품"
								data-ilparam-type="cls" data-ilparam-value="department">
								<label for="sm_de">평점 높은 순</label>
						</span></li>


					</ul>

					<ul class="tmpl_viewtype notranslate">

					</ul>
				</div>

				<div class="com_tmpl_content react-area" id="area_content">
					<div class="tmpl_itemlist" id="area_itemlist"
						data-areaid="item_list" data-globalid="category">
						<div id="ty_thmb_view" class="cunit_lst_v">

							<ul class="cunit_thmb_lst cunit_thmb_lst4 cunit_thmb_w1000" id="id_productList">

							<%
							    for(ProductDto product : productList){

							%>
								<li class="cunit_t232" data-unittype="item" data-advertacctid=""
									data-advertbidid="" data-adtgtid="0000007238370" data-adidx="1"
									data-advertbilngtypecd="" data-advertkindcd=""
									data-advertextensterydivcd="">
									<div class="cunit_prod " data-react-unit-type="item"
										data-react-unit-id="0000007238370" data-react-unit-inx="0"
										data-react-mdl-info="" data-react-advert-yn="N"
										data-react-advert-bid-id="" data-react-advert-tgt-id=""
										data-react-advert-bilng-type-cd=""
										data-react-advert-kind-cd=""
										data-react-advert-extens-tery-div-cd=""
										data-react-advert-advert-acct-grp-id=""
										data-react-unit-text="">
										<div class="prod_top"></div>
										<div class="thmb">
										    <%
										        String url = "detail.do?productid="+product.getProductId();
                                            %>
											<a href=<%=url%>
												target="_self" class="clickable"
												data-react-tarea="대카테고리|상품목록|상품_클릭|★3,360→1,980[7/15~7/27][크라운] 참크래커 280g_0000007238370"
												data-info="0000007238370" data-index="1"
												data-position="view" data-unit="img"
												data-react-tarea-dtl-cd="t00001">
												<img src=<%= product.getProductImageUrl() %>
												onerror="this.onerror=null;this.src='https://simg.ssgcdn.com/trans.ssg?src=/ui/ssg/img/common/img_ready_500x500.jpg&amp;w=232&amp;h=232&amp;t=9ba4c0524addb9b9ec561d5523b3baf3f90ae796'"
												class="i1" width="232" height="232"
												alt="★3,360→1,980[7/15~7/27][크라운] 참크래커 280g" loading="lazy">
												<img
												src="//sitem.ssgcdn.com/70/83/23/item/0000007238370_i2_290.jpg"
												onerror="this.onerror=null;this.src='https://simg.ssgcdn.com/trans.ssg?src=/ui/ssg/img/common/img_ready_500x500.jpg&amp;w=232&amp;h=232&amp;t=9ba4c0524addb9b9ec561d5523b3baf3f90ae796'"
												class="i2" width="232" height="232"
												alt="★3,360→1,980[7/15~7/27][크라운] 참크래커 280g"
												aria-hidden="true" loading="lazy">
												<div class="deiv_bdg notranslate" aria-label="배송방법">
													<span class="ssgdeliv"><span class="blind">쓱-배송</span></span>
												</div>
											</a>
											<div class="exp_area notranslate">
												<div class="util_bx">
													<a
														href="/item/itemView.ssg?itemId=0000007238370&amp;siteNo=6001&amp;salestrNo=2034"
														class="blank clickable" target="_blank"
														data-info="0000007238370" data-index="1"
														data-position="pop" data-unit="img"
														data-react-tarea="대카테고리|상품목록|상품_새창보기|★3,360→1,980[7/15~7/27][크라운] 참크래커 280g"><span
														class="blind">새창보기</span></a> <a href="javascript:void(0)"
														class="cart clickable" role="button"
														onclick="frontCommCart.put(this, '');"
														data-info="0000007238370" data-idx="1"
														data-position="cart" data-unit="img"
														data-react-tarea="대카테고리|상품목록|상품_장바구니|★3,360→1,980[7/15~7/27][크라운] 참크래커 280g"
														data-react-tarea-dtl-cd="t00002"><span class="blind">장바구니</span></a>
													<span style="display: none" class="disp_cart_data"
														data-cart-type="10" data-cart-inflo-site-no="6005"
														data-cart-ordqty="1">{"advertBidId":"","giftBtnShowType":"","giftBtnActType":"Y","itemChrctDivCd":"10","itemLnkd":"/item/itemView.ssg?itemId=0000007238370&amp;siteNo=6001&amp;salestrNo=2034","giftBtnMsg":"","bothSsgMorningShppYn":"N","goItemDetailYn":"N","drctPurchYn":"N","itemId":"0000007238370","dealItemYn":"N","advertExtensTeryDivCd":"","cleaningLabYn":"N","siteNo":"6001","useForcedSsg":"N","cartPsblType":"","uitemId":"00000","infloSiteNo":"6005","salestrNo":"2034","msgItemDetail":""}</span>
													<span class="cmlike _js_cmlike interestIt"> <input
														type="hidden" name="attnDivCd" value="10"> <input
														type="hidden" name="attnDivDtlCd" value="10"> <input
														type="hidden" name="siteNo" value="6001"> <input
														type="hidden" name="attnTgtIdnfNo1" value="0000007238370">
														<input type="hidden" name="attnTgtIdnfNo2" value="2034">
														<input type="hidden" name="uitemId" value="00000">
														<input type="hidden" name="notiTitle"
														value="★3,360→1,980[7/15~7/27][크라운] 참크래커 280g"> <input
														type="hidden" name="notiImgPath"
														value="//sitem.ssgcdn.com/70/83/23/item/0000007238370_i1_290.jpg">
														<input type="hidden" name="checked" value="N"> <input
														type="hidden" name="useForcedSsgYn" value="N">
														<button class="cmlike_btn _js_cmlike_btn clickable"
															data-position="clip"
															data-react-tarea="대카테고리|상품목록|상품_좋아요|_0000007238370"
															data-react-tarea-dtl-cd="t00003">
															<span class="cmlike_ico"> <i
																class="cmlike_primary_s"></i> <span class="sr_off"><span
																	class="blind">관심상품 취소</span></span> <span class="sr_on"><span
																	class="blind">관심상품 등록</span></span>
															</span>
														</button>
													</span>
												</div>
											</div>
										</div>
									</div>
									<div class="cunit_info">

										<div class="cunit_tp">
											<span class="cm_mall_ic ty_rect_s notranslate">
											    <i class="em"><span class="blind">이마트몰</span></i> <!-- ssg 푸드마켓  -->
											</span>
											<div class="dp_dv">
                                                <img src="<%=request.getContextPath()%>/img/freeDel.png" alt="사진 없음" width="40px" height="18px;">
												<!-- 신선보장 -->
												<!-- SSG설치 -->
												<!-- 오픈마켓  -->
											</div>


										</div>
										<div class="cunit_md notranslate">
											<div class="title">
												<a
													href="/item/itemView.ssg?itemId=0000007238370&amp;siteNo=6001&amp;salestrNo=2034"
													target="_self" class="clickable"
													data-react-tarea="대카테고리|상품목록|상품_클릭|★3,360→1,980[7/15~7/27][크라운] 참크래커 280g"
													data-info="0000007238370" data-index="1"
													data-position="view" data-unit="img"> <em class="tx_ko"> <%= product.getProductTitle() %> </em>
												</a>
											</div>
										</div>
										<div class="cunit_price">
											<div class="opt_price">
												<span class="blind">할인적용가</span> <em class="ssg_price"><%= priceToStr(product.getProductPrice()) %></em>
												<span class="ssg_tx">원</span>

											</div>
										</div>
										<div class="cunit_app">
											<div class="rating">
												<div class="rate_bg">
													<img src="<%=request.getContextPath()%>/img/fullStar.png" style="width: 18px;height: 15px;">
													<span class="rate_tx">(<em><%= product.getProductTotalRate()%> </em>점)
												</div>
												<span class="rate_tx">(<em>4.5</em>점)
												</span>
											</div>
										</div>


									</div>
								</li>

								<% } %>





							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>

		</div>

		<input type="text" id="category" value=<%= category %> >

		<footer id="footer">
			<script src="<%=request.getContextPath()%>/js/footer.js"></script>
		</footer>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>




</body>



</html>