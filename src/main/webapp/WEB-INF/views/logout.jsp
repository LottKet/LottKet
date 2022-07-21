<%--
  Created by IntelliJ IDEA.
  User: BTC-N24
  Date: 2022-07-19
  Time: 오후 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>롯켓 마트</title>
    <link rel="icon" href="" type="image/x-icon">
    <script src="https://kit.fontawesome.com/a9c109155d.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="WEB-INF/views/css/style.css">
    <link rel="favicon" href="WEB-INF/views/img/logo.png">
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
    Kakao.init('7a3a9cd4830c8f8ae415f16baa3d136f'); //발급받은 키 중 javascript키를 사용해준다.
    console.log(Kakao.isInitialized()); // sdk초기화여부판단

    function kakaoLogout() {
        if (Kakao.Auth.getAccessToken()) {
            Kakao.API.request({
                url: '/v1/user/unlink',
                success: function (response) {
                    console.log('kakaologout.');
                      window.location = 'main.do';
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
</body>
<script>
    sessionStorage.clear();
    window.onload = function () {
        kakaoLogout();
    }
</script>
</html>