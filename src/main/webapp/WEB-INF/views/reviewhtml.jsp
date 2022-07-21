<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

<c:forEach var="reviewJoinUser" items="${reviewJoinUserDto}">
<div class="reviewList">
    <div class="uswersAndMoremenu">
        <div class="users">
            <%--            <img src="<%=reviewJoinUserDto.get(i).getUserProfileImage()%>"--%>
            <%--                                  style="border-radius:1.5em; margin-right:10px;">--%>
            <div class="identities">
                <div class="userNameWrap">
                    <img src="${reviewJoinUser.userProfileImage}"
                         style="border-radius:1.5em; margin-right:10px;">
                    <strong class="userName">&nbsp;&nbsp;<c:out value="${reviewJoinUser.userName}"/>&nbsp;&nbsp;</strong><span class="info">
                      <br><br> <c:out value="${reviewJoinUser.userGrade}"/>등급 &nbsp;&nbsp;&nbsp;등록일 :
                      <c:out value="${reviewJoinUser.reviewDate}"/></span></div>
                <div class="badges"></div>
            </div>
        </div>
    </div>
    <br>
    <span class="reviewList_avg">평점 : <c:out value="${reviewJoinUser.rating}"/></span>
    <br><br>

    <span class="reviewList_text"><c:out value="${reviewJoinUser.content}"/></span>
    <button type="button" style="margin-left:50px;" onclick='admin_reply("${reviewJoinUser.reviewId}")'>답글 작성</button>

    <div id="replydiv${reviewJoinUser.reviewId}" style="margin-left:80px; margin-top:20px; display:none;" >
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
</c:forEach>