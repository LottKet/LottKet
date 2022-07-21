let sessionProduct = JSON.parse(localStorage.getItem("recentProduct") || "[]"); //값 가져오기
let recentProduct1 = sessionProduct[sessionProduct.length -1]
let recentProduct2 = sessionProduct[sessionProduct.length -2]
let recentProduct3 = sessionProduct[sessionProduct.length -3]
let recentProduct4 = sessionProduct[sessionProduct.length -4]
let recentProduct5 = sessionProduct[sessionProduct.length -5]


let headerContents = '';
headerContents +=
    `
    <div class="inner" style="background:#eee">
      <div class="headerWrapper">
        <div class="util innerContent">
          <ul class>
            <li id="login_li"><a href="login.do">로그인</a></li>
            <li id="logout_li" style="display:none"> <a href="logout.do">로그아웃</a></li> <!--<a href="logout.do"> onclick="kakaoLogout()"-->
            <li><a href="admin.html">Admin</a></li>
          </ul>
        </div>

        <div class="main innerContent">
          <div class="div_logo">
            <h1>
              <a href="main.do" style="display: flex; align-items: center;">
                <img src="./img/logo.png" style="width:15%;">
                <span style="margin-left:3%; font-size:XX-LARGE;">롯켓마트</span>
              </a>
            </h1>
          </div>

          <div>
            <ul id="gnb">
              <li><a href="mypage.do">My Page</a></li>
              <li><a href="cart.do">장바구니</a></li>
            </ul>
          </div>

          <div class="searchArea on IMG">
            <i class="fa-solid fa-magnifying-glass"></i>
          </div>
        </div>
      </div>
    </div>
    <div class="nav_category">
          <a href='category.do?productCategory=과일'>과일</a>
          <a href="category.do?productCategory=채소">채소</a>
          <a href="category.do?productCategory=잡곡견과">잡곡·견과</a>
          <a href="category.do?productCategory=수산">수산</a>
          <a href="category.do?productCategory=정육계란">정육계란<a/>
          <a href="category.do?productCategory=유제품">유제품<a/>
          <a href="category.do?productCategory=냉동냉장">냉동냉장<a/>
          <hr>
    </div>
    
    <div style="width:110px; height:590px; font-weight:bold; position:fixed; right:80px; background-color: #ff4769; z-index:99; border-radius: 2em; ">
    <br>
        <span style="margin-left:14px; color:white;">최근 본 상품</span>
        <br><br>
        <ul style="margin-left:4px;">
            <li><img id="recentImg1" style="width:100px; height:100px; background-color: white;" ></li>
            <li><img id="recentImg2" style="width:100px; height:100px; background-color: white;" ></li>
            <li><img id="recentImg3" style="width:100px; height:100px; background-color: white;" ></li>
            <li><img id="recentImg4" style="width:100px; height:100px; background-color: white;" ></li>
            <li><img id="recentImg5" style="width:100px; height:100px; background-color: white;" ></li>
        </ul>
    </div>
`
document.getElementById('header').innerHTML = headerContents;
if (sessionStorage.getItem("id") != null) {
  document.getElementById("logout_li").style.display = "";
  document.getElementById("login_li").style.display = "none";
}

if (sessionStorage.getItem("id") == null) {
  document.getElementById("logout_li").style.display = "none";
  document.getElementById("login_li").style.display = "";
}


document.getElementById("recentImg1").src = recentProduct1.recentProductImg;
document.getElementById("recentImg2").src = recentProduct2.recentProductImg;
document.getElementById("recentImg3").src = recentProduct3.recentProductImg;
document.getElementById("recentImg4").src = recentProduct4.recentProductImg;
document.getElementById("recentImg5").src = recentProduct5.recentProductImg;

//
// let pathname = window.location.pathname;
// let fit_pathname = pathname.split('/');
// let file_name = fit_pathname[fit_pathname.length -1];
//
// if(file_name == 'detail.do' & localStorage.getItem("recentProduct") != null) {
//   sessionProduct = JSON.parse(localStorage.getItem("recentProduct") || "[]"); //값 가져오기
//   sessionProduct.push({
//     recentProductImg: "<%=productImageDto.get(0).getProductImageUrl()%>",
//     recentProductUrl: window.location.href
//   })
//   console.log(sessionProduct);
//   localStorage.setItem("recentProduct", JSON.stringify(sessionProduct));
//
// } else {
//   var productObj = [{recentProductImg: "<%=productImageDto.get(0).getProductImageUrl()%>", recentProductUrl: window.location.href}];

// }