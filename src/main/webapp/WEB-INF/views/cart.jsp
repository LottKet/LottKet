<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="lotte.com.lottket.dto.*" %>
<%@ page import="java.text.DecimalFormat" %>
<%
    request.setCharacterEncoding("utf-8");
    List<ShowcartDto> cartList=(List<ShowcartDto>)request.getAttribute("cartList");
    long userId = cartList.get(0).getUserid();
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
    <script src="https://kit.fontawesome.com/a9c109155d.js" crossorigin="anonymous"></script>
    <script src="js/jquery.js"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/mypage.css">

    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
    <link rel="favicon" href="img/logo.png">


    <!-- Demo styles -->
    <style>
        .map_wrap {
            position: relative;
            width: 100%;
            height: 350px;
        }

        .title {
            font-weight: bold;
            display: block;
        }

        .hAddr {
            position: absolute;
            left: 10px;
            top: 10px;
            border-radius: 2px;
            background: #fff;
            background: rgba(255, 255, 255, 0.8);
            z-index: 1;
            padding: 5px;
        }

        #centerAddr {
            display: block;
            margin-top: 2px;
            font-weight: normal;
        }

        .bAddr {
            padding: 5px;
            text-overflow: ellipsis;
            overflow: hidden;
            white-space: nowrap;
        }
    </style>
</head>

<body>
<header id="header">
    <script src="js/header.js"></script>
</header>

<div class="contentWrap" style="width:80%; margin-left:10%; margin-bottom:10%">
    <div class="searchWrap">
        <div class="title lineBlack">
            <h2>나의 장바구니</h2>
            <div class="onlySearchForm regularDate datePickerSearch">
                <div class="searchForm">
                </div>
            </div>
        </div>


        <div class="orderGroupWrap" id="cartBoard">
            <%
                for(int i=0; i<cartList.size(); i++){
                    ShowcartDto cartDto = cartList.get(i);
            %>
            <div class="topInformation grayBox" style="display:flex;">
                <div class="imgWrap">
                    <img style="width:300px; height:200px;" src="<%= cartDto.getImageurl()%>" class="loaded">
                </div>
                <div class="information" style="width:500px; margin-left:5%">
                    <span>상품ID</span>
                    <span class="date"><%= cartDto.getProducttitle()%></span>
                    <br>
                    <span>카트ID</span>
                    <span class="orderNumber"> <%= (Long)cartDto.getCartid()%> </span>
                    <br><br>
                    <span>상품 수량</span>
                    <span class="orderNumber"> <%= (Integer)cartDto.getAmount()%>개</span>
                    <br><br>
                    <div class="orderGoodsItem">
                        <div class="goodsWrap" is-cart="true">
                            <div class="textWrap">
                                <p class="title">
                                </p>
                                    <em class="count">total <%= priceToStr(cartDto.getAmount() *cartDto.getProductprice())%> 원</em></div>
                            </div>
                        </div>
                    </div>
                    <div class="orderStatusInfo">
                        <div class="orderStatusInfoButtons" odno="2022071619353482" btnlist="1020">
                            <button id="removeCart" onclick=" test(<%=cartDto.getCartid()%>)" >장바구니에서 제거</button>

                        </div>
                    </div>
                </div>
                <br><br><br><br>

            <%
                }
            %>
            <div id="totalcartexpense" style="align-content: center">
                <%
                    int totalcost = 0;
                    for(int i=0; i<cartList.size(); i++){
                        totalcost += cartList.get(i).getProductprice() * cartList.get(i).getAmount();

                    }
                %>
            </div>
        </div>

            <form method="post">
                <input type="hidden" id="cartUserId" value="<%= userId%>" >
                <input type="submit" class="deleteAllCart">장바구니 전체 삭제</input>
            </form>

        </div>
    </div>
</div>

<script type="text/javascript">
    function test(cartId){

        let cartUserId=document.getElementById('cartUserId').value;
        $.ajax({
            url: "deletecart.do",
            type: "get",
            data:{"cartId":cartId, "userId" : cartUserId},
            dataType:'json',
            contentType:"application/json;charset=UTF-8",
            success: function (result) {
                document.getElementById("cartBoard").innerHTML = '';

                let str="";
                for(let i=0;i<result.length;i++){
                    let cartDto = result[i];

                    let productPrice=cartDto.amount * cartDto.productprice;
                    alert(cartDto.amount);
                    alert(cartDto.productprice);
                    let strPrice=productPrice.toString().replace(/\B(?<!\.\d*)(?=(\d{3})+(?!\d))/g, ",");

                    str+='<div class="topInformation grayBox" style="display:flex;">'+
                        '<div class="imgWrap"><img style="width:300px; height:200px;" src="'+cartDto.imageurl+'" class="loaded">'+
                        '</div> <div class="information" style="width:500px; margin-left:5%">'+
                        '<span>상품ID</span><span class="date">'+cartDto.producttitle+'</span>'+
                        '<br><span>카트ID</span><span class="orderNumber">'+cartDto.cartid+' </span><br><br>'+
                        '<span>상품 수량</span><span class="orderNumber">'+ cartDto.amount+'</span>'+
                        '<br><br><div class="orderGoodsItem"><div class="goodsWrap" is-cart="true">'+
                        '<div class="textWrap"><p class="title"></p>'+
                        '<em class="count">total '+ strPrice+' 원</em></div> </div>'+
                        '</div> </div><div class="orderStatusInfo">'+
                        '<div class="orderStatusInfoButtons" odno="2022071619353482" btnlist="1020">'+
                        '<button id="removeCart" onclick="test('+ cartDto.cartid +')" >장바구니에서 제거</button></div></div></div>'+
                        '<br><br><br><br>';
                    document.getElementById("cartBoard").innerHTML = str;
                }
            }
        });



    }

</script>

<%--<div id="map_wrap" class="map_wrap" style="display:none; height:800px; width:1500px; margin-left:5%; margin-top:5%;">
    <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>
    <div class="hAddr">
        <span class="title">지도중심기준 행정동 주소정보</span>
        <span id="centerAddr"></span>
    </div>
</div>--%>

<%--<script type="application/javascript">
    $(".deleteAllCart").click(function() {
        var element = $("#deleteOneCart");

        $.ajax({
            type: 'post',
            url: 'deleteallcart.do',
            data: 'userId='+$('.userId').val(),
            dataType: 'json',
            success:function (data){
                if(data.success == "YES" ){
                    element.remove();
                    alert('장바구니 전체 삭제되었습니다.');
                } else {
                    alert('false')
                };
            ;}
        });
    })


    $(".deleteOneCart").click(function() {
        var element = $(this);

        $.ajax({
            type: 'post',
            url: 'deletecart.do',
            data: 'cartId='+$('.cartId').val(),
            dataType: 'json',
            success:function (data){
                if(data.success == "YES" ){
                    element.remove();
                } else {
                    alert('해당 상품을 장바구니에서 제거할 수 없습니다.');
                };
            ;}
        });
    })
</script>



<script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7a3a9cd4830c8f8ae415f16baa3d136f&libraries=services">
</script>
<script>
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
            level: 1 // 지도의 확대 레벨
        };

    // 지도를 생성합니다
    var map = new kakao.maps.Map(mapContainer, mapOption);

    // 주소-좌표 변환 객체를 생성합니다
    var geocoder = new kakao.maps.services.Geocoder();

    var marker = new kakao.maps.Marker(), // 클릭한 위치를 표시할 마커입니다
        infowindow = new kakao.maps.InfoWindow({
            zindex: 1
        }); // 클릭한 위치에 대한 주소를 표시할 인포윈도우입니다

    // 현재 지도 중심좌표로 주소를 검색해서 지도 좌측 상단에 표시합니다
    searchAddrFromCoords(map.getCenter(), displayCenterInfo);

    // 지도를 클릭했을 때 클릭 위치 좌표에 대한 주소정보를 표시하도록 이벤트를 등록합니다
    kakao.maps.event.addListener(map, 'click', function (mouseEvent) {
        searchDetailAddrFromCoords(mouseEvent.latLng, function (result, status) {
            if (status === kakao.maps.services.Status.OK) {
                var detailAddr = !!result[0].road_address ? '<div>도로명주소 : ' + result[0].road_address.address_name +
                    '</div>' : '';
                detailAddr += '<div>지번 주소 : ' + result[0].address.address_name + '</div>';

                var content = '<div class="bAddr">' +
                    '<span class="title">법정동 주소정보</span>' +
                    detailAddr +
                    '</div>';

                // 마커를 클릭한 위치에 표시합니다
                marker.setPosition(mouseEvent.latLng);
                marker.setMap(map);

                // 인포윈도우에 클릭한 위치에 대한 법정동 상세 주소정보를 표시합니다
                infowindow.setContent(content);
                infowindow.open(map, marker);
                //   alert(result[0].address.address_name);

                Swal.fire({
                    title: 'Are you sure?',
                    text: result[0].address.address_name,
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: '네 여기로 보내주세요!'
                }).then((result) => {
                    if (result.isConfirmed) {
                        Swal.fire(
                            '주소가 변경되었습니다!',
                            'Your file has been deleted.',
                            'success'
                        )
                        document.getElementById()
                    }
                })
            }
        });
    });

    // 중심 좌표나 확대 수준이 변경됐을 때 지도 중심 좌표에 대한 주소 정보를 표시하도록 이벤트를 등록합니다
    kakao.maps.event.addListener(map, 'idle', function () {
        searchAddrFromCoords(map.getCenter(), displayCenterInfo);
    });

    function searchAddrFromCoords(coords, callback) {
        // 좌표로 행정동 주소 정보를 요청합니다
        geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);
    }

    function searchDetailAddrFromCoords(coords, callback) {
        // 좌표로 법정동 상세 주소 정보를 요청합니다
        geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
    }

    // 지도 좌측상단에 지도 중심좌표에 대한 주소정보를 표출하는 함수입니다
    function displayCenterInfo(result, status) {
        if (status === kakao.maps.services.Status.OK) {
            var infoDiv = document.getElementById('centerAddr');

            for (var i = 0; i < result.length; i++) {
                // 행정동의 region_type 값은 'H' 이므로
                if (result[i].region_type === 'H') {
                    infoDiv.innerHTML = result[i].address_name;
                    break;
                }
            }
        }
    }


    function wrapWindowByMask() {
        //화면의 높이와 너비를 구한다.
        var maskHeight = $(document).height();
        var maskWidth = $(window).width();

        //마스크의 높이와 너비를 화면 것으로 만들어 전체 화면을 채운다.
        $('#SearchLayer').css({
            'width': maskWidth,
            'height': maskHeight
        });
    }

    /// 화면의 중앙에 레이어띄움
    function where(input) {
        wrapWindowByMask();
        $("#map_wrap").css("position", "absolute");
        $("#map_wrap").css("top", Math.max(0, (($(window).height() - $("#map_wrap").outerHeight()) / 2) + $(window)
            .scrollTop() - 100) + "px");
        $("#map_wrap").css("left", Math.max(0, (($(window).width() - $("#map_wrap").outerWidth()) / 2) + $(window)
            .scrollLeft()) + "px");
        $('#map_wrap').show();
        $('#map_wrap').show();

        setTimeout(function () {
            $('html').click((e) => {
                if (e.target.id !== 'map_wrap' && $(e.target).parents('#map_wrap').length === 0) {
                    location.reload();
                }
            });
        }, 1000);
    }

</script>--%>



<footer id="footer">
    <script src="js/footer.js"></script>
</footer>

</body>

</html>
