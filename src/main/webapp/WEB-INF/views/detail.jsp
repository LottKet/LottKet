<%@ page import="lotte.com.lottket.dto.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  ProductDto productDto = (ProductDto)request.getAttribute("productDto");
  List<ProductImageDto> productImageDto = (List<ProductImageDto>)request.getAttribute("productImageDto");
  List<ProductDetailDto> productDetailDto = (List<ProductDetailDto>)request.getAttribute("productDetailDto");
  List<ReviewJoinUser> reviewJoinUserDto = (List<ReviewJoinUser>)request.getAttribute("reviewJoinUserDto");
  List<ReviewJoinReply> reviewJoinReplyDto = (List<ReviewJoinReply>)request.getAttribute("reviewJoinReplyDto");
%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>롯켓 온</title>
  <link rel="icon" href="" type="<%=request.getContextPath()%>/image/x-icon">
  <script src="https://kit.fontawesome.com/a9c109155d.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/detail.css">
  <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
  <link rel="favicon" href="<%=request.getContextPath()%>/img/logo.png">

  <!-- Demo styles -->
  <style>


  </style>
</head>

<body>
<header id="header">
  <script src="<%=request.getContextPath()%>/js/header.js"></script>
</header>

<div class="contents">
  <div class="detail_wrap">
    <div class="detail_product_img">
      <ul style="display:flex; flex-direction: column;">
        <% for (int i=0; i<productImageDto.size(); i++) { %>
        <li>
          <img onclick="imgClick('<%=productImageDto.get(i).getProductImageUrl()%>')"
               src="<%=productImageDto.get(i).getProductImageUrl()%>">
        </li>
        <%
          }
        %>
      </ul>
    </div>
    <div class="detail_product_img2">
      <img id="imageMain" src="<%=productImageDto.get(0).getProductImageUrl()%>">
      <script>
        <%--var recetnProductImg = String(<%=productImageDto.get(0).getProductImageUrl()%>);--%>
        sessionStorage.setItem("recentProductImg", "<%=productImageDto.get(0).getProductImageUrl()%>" ); // 저장
        sessionStorage.setItem("recentProductUrl", window.location.href ); // 저장

        // if (sessionStorage.getItem("recentProduct") != null) {
        //   alert(sessionStorage.getItem("recentProduct"));
        // }
      </script>

      <script>


        let pathname = window.location.pathname;
        let fit_pathname = pathname.split('/');
        let file_name = fit_pathname[fit_pathname.length -1];

        if(file_name == 'detail.do' & localStorage.getItem("recentProduct") != null) {
          sessionProduct = JSON.parse(localStorage.getItem("recentProduct") || "[]"); //값 가져오기
          sessionProduct.push({
            recentProductImg: "<%=productImageDto.get(0).getProductImageUrl()%>",
            recentProductUrl: window.location.href
          })
          console.log(sessionProduct);
          localStorage.setItem("recentProduct", JSON.stringify(sessionProduct));

        } else {
          var productObj = [{recentProductImg: "<%=productImageDto.get(0).getProductImageUrl()%>", recentProductUrl: window.location.href}];
        }

        //
        // sessionProduct = JSON.parse(localStorage.getItem("recentProduct") || "[]"); //값 가져오기
        //
        // console.log(sessionProduct); //출력 확인
      </script>

<%--      <script> sessionStorage.clear()</script>--%>

    </div>
    <div class="detail_product_img3">

      <div data-v-765eb084="">
        <div data-v-765eb084="" class="priceWrap">
          <div data-v-765eb084="" class="priceInfo">
            <div data-v-765eb084="" class="price"><span data-v-765eb084=""> <%=productDto.getProductTitle()%> </span>
            </div>
          </div>

          <div data-v-765eb084="" class="priceInfo" style="margin-bottom:8%;">
            <div data-v-765eb084="" class="price"><span data-v-765eb084="" class="discountRate"> 가격 : &nbsp;
                </span><span data-v-765eb084=""> <%=productDto.getProductPrice()%> 원 </span><em data-v-765eb084="">

            </em>
            </div>
          </div>

          <div data-v-765eb084="" class="priceInfo" style="margin-bottom:8%;">
            <div data-v-765eb084="" class="price"><span data-v-765eb084="" class="discountRate"> 평점 : &nbsp;
                </span><span data-v-765eb084=""> <%=String.format("%.1f",productDto.getProductTotalRate())%> 점 </span><em data-v-765eb084="">

            </em>
            </div>
          </div>

          <div data-v-765eb084="" class="priceInfo" style="margin-bottom:6%;">
            <div data-v-765eb084="" class="price"><span data-v-765eb084="" class="discountRate"> 재고 : &nbsp;
                </span><span data-v-765eb084=""> <%=productDto.getProductStock()%> 개 </span><em data-v-765eb084="">

            </em>
            </div>
          </div>

        </div>
      </div>

      <div style="display:flex; justify-content: space-around;">
        <div class="button_count">
          <button onclick="minus();">-</button><button id="quantity">1</button><button onclick="plus();">+</button>
        </div>
        <div class="button_order">
          <button data-v-2292bccc="" data-v-3927112e=""
                  data-object="type=add_to_cart&amp;coupon=&amp;value=4800&amp;price=3420&amp;quantity=1&amp;cat_id=BC34050100&amp;tr_grp_cd=SR&amp;tr_no=LD476977&amp;lrtr_no=null"
                  class="strokeRed util sizeLarge alignLeft" data-v-3351bf4b=""><span data-v-2292bccc="" class="inner">
                <!----><span data-v-2292bccc="" class="">
                  장바구니 담기
                </span>
            <!----></span></button>
        </div>
        <div class="button_order">
          <button data-v-2292bccc="" data-v-3927112e=""
                  data-object="type=add_to_cart&amp;coupon=&amp;value=4800&amp;price=3420&amp;quantity=1&amp;cat_id=BC34050100&amp;tr_grp_cd=SR&amp;tr_no=LD476977&amp;lrtr_no=null"
                  class="strokeRed util sizeLarge alignLeft" data-v-3351bf4b="" onclick="purchase()"><span data-v-2292bccc=""
                                                                                                 class="inner">
                <!----><span data-v-2292bccc="" class="">
                  바로 구매하기
                </span>
            <!----></span></button>
        </div>
      </div>
    </div>
  </div>


  <br><br>
  <hr>
  <br><br>
  <div style="width:1200px; text-align: center">

    <%
      for (int i=0; i<productDetailDto.size(); i++){
    %>
    <!-- <img src=""> -->
    <img style="width:70%; height:70%;" src="<%=productDetailDto.get(i).getProductDetailImageUrl()%>">
    <%
      }
    %>

  </div>

  <br><br>
  <hr>
  <br><br>
  <div class="detail_review" style="width:1200px; background-color:rgb(255, 255, 255);">
    <div style="width:1000px;">
      <div style="margin-bottom:50px;">
        <ul style="display:flex">
          <li>
            <h1 style="font-size:xx-large; font-weight: bold">리뷰</h1>
            <br><br>
          </li>

        </ul>
        <hr>
        <script>
          function insert_review() {
            document.getElementById("div_insert_review").style.display = "";
          }

        </script>
        <br>
        <h3 style="font-size:xx-large; font-weight: bold"><button onclick="insert_review()" style="background-color: #ff42c9; color:white; border-radius: 0.5em">댓글작성</button></h3>
      </div>
      <div id="div_insert_review" style="margin-left:10px; display:none">
        <span>wnsgur753</span>
        <img id="id_star1" style="width:20px;" src="<%=request.getContextPath()%>/img/fullStar.png" onclick="click_star(this.id)">
        <img id="id_star2" style="width:20px;" src="<%=request.getContextPath()%>/img/fullStar.png" onclick="click_star(this.id)">
        <img id="id_star3" style="width:20px;" src="<%=request.getContextPath()%>/img/fullStar.png" onclick="click_star(this.id)">
        <img id="id_star4" style="width:20px;" src="<%=request.getContextPath()%>/img/fullStar.png" onclick="click_star(this.id)">
        <img id="id_star5" style="width:20px;" src="<%=request.getContextPath()%>/img/fullStar.png" onclick="click_star(this.id)">
        <script>


          var myImage = document.querySelector('img');
          myImage.onclick = function() {
            var mySrc = myImage.getAttribute('src');
            if(mySrc === 'http://static.tumblr.com/1bd1b615e6da70dd71dc84fd2f47c80d/zpmncfu/oxNng9hfv/tumblr_static_95p88l86si88ks4w4wws04wk8.png') {
              myImage.setAttribute ('src','https://cdn-insomniac.s3.amazonaws.com/emoji_sexface.png');
            } else {
              myImage.setAttribute ('src','http://static.tumblr.com/1bd1b615e6da70dd71dc84fd2f47c80d/zpmncfu/oxNng9hfv/tumblr_static_95p88l86si88ks4w4wws04wk8.png');
            }
          };
        </script>
        <form style="margin-top:10px;" action="javascript:insertReview()">
          <p><textarea id="content" cols="50" rows="5" style="width:700px"></textarea></p>
          <p><input type="submit" value="Submit"></p>
        </form>
      </div>
      <br><br><br>

      <div id="commentdiv">
        <%
          for(int i=0; i<reviewJoinUserDto.size(); i++){
            SimpleDateFormat sDate = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = sDate.format(reviewJoinUserDto.get(i).getReviewDate());
        %>
        <div class="reviewList">
          <div class="uswersAndMoremenu">
            <div class="users">
              <%--            <img src="<%=reviewJoinUserDto.get(i).getUserProfileImage()%>"--%>
              <%--                                  style="border-radius:1.5em; margin-right:10px;">--%>
              <div class="identities">
                <div class="userNameWrap">
                  <img src="<%=reviewJoinUserDto.get(i).getUserProfileImage()%>"
                       style="border-radius:1.5em; margin-right:10px;">
                  <strong class="userName">&nbsp;&nbsp;<%=reviewJoinUserDto.get(i).getUserName()%>&nbsp;&nbsp;</strong><span class="info">
                      <br><br> <%=reviewJoinUserDto.get(i).getUserGrade()%>등급 &nbsp;&nbsp;&nbsp;등록일 :
                      <%=strDate%></span></div>
                <div class="badges"></div>
              </div>
            </div>
          </div>
          <br>
          <span class="reviewList_avg">평점 : <%=reviewJoinUserDto.get(i).getRating()%></span>
          <br><br>

          <span class="reviewList_text"><%=reviewJoinUserDto.get(i).getContent()%></span>
          <button type="button" style="margin-left:50px;" onclick='admin_reply("<%=reviewJoinUserDto.get(i).getReviewId()%>")'>답글 작성</button>

          <div id="replydiv<%=reviewJoinUserDto.get(i).getReviewId()%>" style="margin-left:80px; margin-top:20px; display:none;" >
            <span>관리자아이디 넣어주세염</span>
            <form style="margin-top:10px;">
              <p><textarea cols="50" rows="5" style="width:700px"></textarea></p>
              <p style="padding-bottom: 15px;
                 padding-top: 10px"><input type="submit" value="Submit"></p>
            </form>
          </div>
        </div>
        <hr style="color:gray; margin-top:15px;">
        <br><br>

      </div>
        <%
          }
        %>
    </div>
  </div>

</div>

<footer id="footer">
  <script src="<%=request.getContextPath()%>/js/footer.js"></script>
</footer>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
  function imgClick(index) {
    document.getElementById('imageMain').src = index;
  }

  function minus() {

    if (parseInt($("#quantity").text().toString()) - 1 < 1) {
      alert('수량은 1개 이상입니다.')
    } else {
      document.getElementById('quantity').innerText = parseInt($("#quantity").text().toString()) - 1;
    }
  }

  function plus() {
    document.getElementById('quantity').innerText = parseInt($("#quantity").text().toString()) + 1;
  }

  function insertReview(){
    let content = $("#content").val();
    document.getElementById("div_insert_review").style.display = "none";
    document.getElementById("content").value="";
    $.ajax({
      url:"<%=request.getContextPath()%>/insertReview.do",
      data:{content:content, productId:<%=productDto.getProductId()%>},
      method:"get",
      success:function(data){
        console.log(data);
        $("#commentdiv").html(data);
      }
    });
  }

  function admin_reply(index) {
    document.getElementById("replydiv"+index).style.display = "";
  }

  function purchase(){
    let quantity = parseInt($("#quantity").text().toString());
    let productid = <%=productDto.getProductId()%>;
    console.log(quantity, productid,sessionStorage.getItem("id"));
    location.href="order/orderSheet.do?productId="+productid+"&userId="+sessionStorage.getItem("id")+"&orderAmount="+quantity;
  }
</script>

</body>

</html>