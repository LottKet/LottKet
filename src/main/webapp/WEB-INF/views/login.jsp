<%--
  Created by IntelliJ IDEA.
  User: BTC-N24
  Date: 2022-07-19
  Time: 오후 8:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>롯켓 마트</title>
  <link rel="icon" href="" type="image/x-icon">
  <script src="https://kit.fontawesome.com/a9c109155d.js" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="css/style.css">
  <%--파비콘 이러면 됨--%>
  <link rel="icon" type="image/ico" href="img/logo.png">
  <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link
          href="https://fonts.googleapis.com/css2?family=Fredoka+One&family=Nanum+Gothic:wght@800&family=Noto+Sans+KR:wght@700&family=Roboto:ital,wght@1,900&display=swap"
          rel="stylesheet">

  <!-- 소셜 카카오-->
  <script src="//developers.kakao.com/sdk/js/kakao.min.js" sync></script>
  <script src="//code.jquery.com/jquery-3.5.1.min.js"></script>

  <!-- Demo styles -->
  <style>
    button {
      background-color: #fee500;
      width: 100px;
      height: 100px;
      border-color: #fee500;

      font-family: 'Jua', sans-serif;
    }

  </style>
</head>
<script>


</script>

<script>
  Kakao.init('7a3a9cd4830c8f8ae415f16baa3d136f'); //발급받은 키 중 javascript키를 사용해준다.
  console.log(Kakao.isInitialized()); // sdk초기화여부판단
  //카카오로그인
  function kakaoLogin() {
    Kakao.Auth.login({
      success: function (response) {
        Kakao.API.request({
          url: '/v2/user/me',
          success: function (result) {
            sendRequest(result);
            console.log(result);
            const sessionData = result.kakao_account.email;
            const id = result.id;
            const name = result.kakao_account.profile.nickname;

            sessionStorage.setItem("id", id ); // 저장
            sessionStorage.setItem("name", name ); // 저장
            sessionStorage.setItem("email", sessionData ); // 저장

            if (sessionStorage.getItem("id") != null) {
              location.href = "main.do";
            }

          },
          fail: function (error) {
            console.log(error)
            console.log("여가");
          },
        })
      },
      fail: function (error) {
        console.log(error)
      },
    })
  }
  //카카오로그아웃
  function kakaoLogout() {
    if (Kakao.Auth.getAccessToken()) {
      Kakao.API.request({
        url: '/v1/user/unlink',
        success: function (response) {
          console.log(response)
        },
        fail: function (error) {
          console.log(error)
        },
      })
      Kakao.Auth.setAccessToken(undefined)
    }
  }

</script>
<body>
<header id="header">
  <script src="js/header.js"></script>
</header>

<script>

</script>
<div id="wrap" style="height:700px">

  <div id="app">
    <div style="margin-left:35%; margin-top:10%">
      <div style="display: flex">
        <button onclick="kakaoLogin()"><img
                src="https://static.lotteon.com/p/member/assets/img/login-icon-kakao.svg"></button>
        <button onclick="kakaoLogin()" style="width:400px; font-weight: bold; font-size: large;">카카오로 시작하기</button>
      </div>
      <br><br><br><br>
      <!-- <button onclick="kakaoLogout()" style="display:block; ">카카오 로그아웃</button> -->
      <img src="img/together.jpg" style="height:400px">
    </div>
  </div>

  <div id="info">
  </div>
</div>

<footer id="footer">
  <script src="js/footer.js"></script>
</footer>
</body>
<script>
  function sendRequest(response) {
    $.ajax({
      url: "<%=request.getContextPath()%>/signIn.do",
      type: "post",
      data:JSON.stringify(response),
      dataType:'text',
      contentType:"application/json;charset=UTF-8",
      success: function (result) {
        let obj = JSON.parse(result);
        const grade = obj.grade;
        const role = obj.role;
        sessionStorage.setItem("grade", grade ); // 저장
        sessionStorage.setItem("role", role ); // 저장
      }
    });
  }

</script>
</html>