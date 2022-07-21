<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ko">

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>롯켓 온</title>
    <link rel="icon" href="" type="image/x-icon">
    <script src="https://kit.fontawesome.com/a9c109155d.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
    <link rel="favicon" href="img/logo.png">
    <script src="//code.jquery.com/jquery-3.5.1.min.js"></script>

    <!-- Demo styles -->
    <style>
        .cls_admin body {
            margin: 0;
        }

        .cls_admin ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            width: 15%;
            /* position: fixed; */
            height: 50%;
            overflow: auto;
        }

        .cls_admin li a {
            display: block;
            color: #000;
            padding: 8px 16px;
            text-decoration: none;
        }

        .cls_admin li a.active {
            background-color: #04AA6D;
            color: white;
        }

        .cls_admin li a:hover:not(.active) {
            background-color: #555;
            color: white;
        }

        <!--
        table

        -->
        #totalorder {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
            vertical-align: center;
            text-align: center
        }

        #totalorder td, #totalorder th {

            border: 1px solid #ddd;
            padding: 8px;
        }

        #totalorder tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        #totalorder tr:hover {
            background-color: #ddd;
        }

        #totalorder th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #04AA6D;
            color: white;
        }
    </style>
</head>

<body>
<header id="header">
    <script src="js/header.js"></script>
</header>

<div class="cls_admin">
    <div>
        <ul>
            <li><a class="active" href="#home">상품 관리</a></li>
            <li><a href="#news">매출현황</a></li>
            <li><a href="#contact">주문 목록 조회</a></li>
        </ul>
    </div>
    <div class="tabs">
        <div class="select_option">
            <%
                Date date = new Date();
                SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
                String strdate = simpleDate.format(date);
                date.setYear(date.getYear() - 1);
                String lastdate = simpleDate.format(date);
            %>
            <br>

            <input id="startdate" type="date" value=<%=lastdate%>>
            <input id="enddate" type="date" value=<%=strdate%>>
            <label for="productcategory">카테고리</label>
            <select id="productcategory" size="1">
                <option value="null">전체조회</option>
                <option value="과일">과일</option>
                <option value="채소">채소</option>
                <option value="잡곡견과">잡곡견과</option>
                <option value="수산">수산</option>
                <option value="정육계란">정육계란</option>
                <option value="유제품">유제품</option>
                <option value="냉장냉동">냉장냉동</option>
            </select>
            <button type="button" id="btn">조회</button>

        </div>
        <div class="statistics tab" style="width: 75%; height: 500px; display:block; background-color: #eee">
            <select id="date" size="1" style="margin-left: 90%">
                <option value="day">일별</option>
                <option value="week">주간</option>
                <option value="month">월별</option>
            </select>
            <!-- 구글 차트 호출 -->
            <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

            <!-- 차트 그리기 -->
            <div id="chart_main" style="height: 50%;"></div>
            <div id="category" style="width: 33.3%; float:left"></div>
            <div id="chart_age" style="width: 33.4%; float:left"></div>
            <div id="chart_gender" style="width: 33.3%; float:left"></div>

            <script type="text/javascript">

                google.charts.load('current', {packages: ['corechart', 'line']});
                google.charts.setOnLoadCallback(drawLogScales);

                function drawLogScales(newdata) {

                    var d;
                    if (newdata == null) {
                        d = [[1, 2], [2, 3], [3, 0], [4, 1], [5, 6]];
                    } else {
                        d = newdata;
                    }


                    var data = new google.visualization.DataTable();
                    data.addColumn('string', '시간');
                    data.addColumn('number', '매출');

                    d.forEach(element => data.addRow([element.date, element.total]));

                    var options = {
                        animation: {
                            startup: true,
                            duration: 1000,
                            easing: 'out'
                        },
                        hAxis: {
                            title: '시간',
                            logScale: true
                        },
                        vAxis: {
                            title: '매출',
                            logScale: false
                        },
                        colors: ['#a52714']
                    };

                    var chart = new google.visualization.LineChart(document.getElementById('chart_main'));
                    chart.draw(data, options);
                }
            </script>
            <script type="text/javascript">
                google.charts.load('current', {'packages': ['corechart']});
                google.charts.setOnLoadCallback(drawChart);

                function drawChart(newdata) {
                    var d;
                    if (newdata == null) {
                        d = [
                            ['야채', 11],
                            ['과일', 2],
                            ['유제품', 2],
                            ['가공품', 2],
                            ['수산', 7]
                        ]
                    } else {
                        d = newdata;
                    }
                    var data = new google.visualization.DataTable();
                    data.addColumn('string', '품목');
                    data.addColumn('number', '판매량');

                    d.forEach(element => data.addRow([element.title, element.orderamount]));

                    var options = {
                        title: '품목',
                        pieSliceText: 'label',
                    };

                    var chart = new google.visualization.PieChart(document.getElementById('category'));

                    chart.draw(data, options);
                }
            </script>
            <script>
                google.charts.load('current', {packages: ['corechart', 'bar']});
                google.charts.setOnLoadCallback(drawBasic);

                function drawBasic(newdata) {
                    var d;
                    if (newdata == null) {
                        d = [
                            ['10대', 333000],
                            ['20대', 8175000],
                            ['30대', 3792000],
                            ['40대', 2695000],
                            ['50대', 2099000],
                            ['60대', 1526000]
                        ]
                    } else {
                        d = [
                            ['10대', newdata.ten],
                            ['20대', newdata.twen],
                            ['30대', newdata.thir],
                            ['40대', newdata.four],
                            ['50대', newdata.fifth],
                            ['60대', newdata.sixth]
                        ];
                    }
                    var data = new google.visualization.DataTable();
                    data.addColumn('string', '나이대');
                    data.addColumn('number', '판매량');

                    data.addRows(d);
                    var options = {
                        title: '연령대별 판매량',
                        chartArea: {width: '50%'},
                        animation: {
                            startup: true,
                            duration: 1000,
                            easing: 'out'
                        },
                        hAxis: {
                            title: '판매량',
                            minValue: 0
                        },
                        vAxis: {
                            title: '연령대'
                        }
                    };

                    var chart = new google.visualization.BarChart(document.getElementById('chart_age'));

                    chart.draw(data, options);
                }
            </script>
            <script>
                google.charts.load('current', {packages: ['corechart', 'bar']});
                google.charts.setOnLoadCallback(drawTopX);

                function drawTopX(newdata) {
                    var d;
                    if (newdata == null) {
                        d = [
                            ['남자', 110 , '남자'],
                            ['여자', 100 , '여자']
                        ]
                    } else {
                        d = [['남자', newdata.male , '남자', '#f00'], ['여자', newdata.female , '남자', '#00f']];
                    }
                    var data = new google.visualization.DataTable();


                    data.addColumn('string', '성별');
                    data.addColumn('number', '판매량');
                    data.addColumn({ role: 'annotation' });
                    data.addColumn({ role: 'style' })
                    data.addRows(d);


                    var options = {

                        axes: {
                            x: {
                                0: {side: 'top'}
                            }
                        },
                        animation: {
                            startup: true,
                            duration: 1000,
                            easing: 'out'
                        },

                        legend: { position: 'none' },
                        bar: { groupWidth: "10%" }
                    };

                    var materialChart = new google.charts.Bar(document.getElementById('chart_gender'));
                    materialChart.draw(data, options);
                }
            </script>
            <script>

                $(document).ready(function () {
                    init();
                });


                function getJson() {
                    let json = {
                        "startdate": $("#startdate").val(),
                        "enddate": $("#enddate").val(),
                        "productcategory": $("#productcategory").val(),
                        "date": $("#date").val()
                    }
                    return json;
                }

                function init() {
                    selectPopulalityProduct();
                    selectDateTotal();
                    selectGenderStatistics();
                    selectAgeStatistics();
                    selectTotalOrders();
                }

                $('#btn').click(function () {
                    init();
                })

                $('#date').change(function () {
                    selectDateTotal();
                })

                function selectAgeStatistics() {

                    $.ajax({
                        type: "POST",
                        url: "selectAgeStatistics.do",
                        data: JSON.stringify(getJson()),
                        contentType: 'application/json',
                        success: function (data) {
                            drawBasic(data);
                        },
                        error: function () {
                            console.log("error");
                        }
                    })
                }

                function selectDateTotal() {

                    $.ajax({
                        type: "POST",
                        url: "selectDateTotal.do",
                        data: JSON.stringify(getJson()),
                        contentType: 'application/json',
                        success: function (data) {
                            drawLogScales(data);
                        },
                        error: function () {
                            console.log("error");
                        }
                    })
                }

                function selectGenderStatistics() {
                    $.ajax({
                        type: "POST",
                        url: "selectGenderStatistics.do",
                        data: JSON.stringify(getJson()),
                        contentType: 'application/json',
                        success: function (data) {
                            drawTopX(data);
                        },
                        error: function () {
                            console.log("error");
                        }
                    })
                }


                function selectPopulalityProduct() {
                    $.ajax({
                        type: "POST",
                        url: "selectPopulalityProduct.do",
                        data: JSON.stringify(getJson()),
                        contentType: 'application/json',
                        success: function (data) {

                            drawChart(data);
                        },
                        error: function () {
                            console.log("error");
                        }
                    })
                }


            </script>

        </div>
        <div class="ordertotal" style="margin-left:15%;padding:1px 16px;height:700px; display:none;">
            <script>
                function selectTotalOrders() {
                    $.ajax({
                        type: "POST",
                        url: "selectTotalOrders.do",
                        data: JSON.stringify(getJson()),
                        contentType: 'application/json',
                        success: function (data) {
                            var tr = "";
                            $.each(data, function () {
                                tr += '<tr><td>' + this.orderId +
                                    '</td><td>' + this.userId +
                                    '</td><td>' + this.productId +
                                    '</td><td>' + this.orderAmount +
                                    '</td><td>' + this.orderDate +
                                    '</td><td>' + this.orderAddress +
                                    '</td><td>' + this.orderDetailAddress +
                                    '</td><td>' + this.orderTotalPrice +
                                    '</td><td>' + this.payment +
                                    '</td><td>' + this.valid +
                                    '</td><td>' + this.deliveryRequirement +
                                    '</td></tr>';
                            });
                            $("#totalorder").append(tr);	// 테이블에 추가
                        },
                        error: function () {
                            console.log("error");
                        }
                    })
                }
            </script>
            <table id="totalorder">
                <col width="5%">
                <col width="5%">
                <col width="5%">
                <col width="5%">
                <col width="10%">
                <col width="15%">
                <col width="15%">
                <col width="10%">
                <col width="5%">
                <col width="5%">
                <col width="10%">
                <tr>
                    <th>
                        주문ID
                    </th>
                    <th>
                        유저ID
                    </th>
                    <th>
                        상품ID
                    </th>
                    <th>
                        주문량
                    </th>
                    <th>
                        주문일자
                    </th>
                    <th>
                        주소
                    </th>
                    <th>
                        상세주소
                    </th>
                    <th>
                        총액
                    </th>
                    <th>
                        결제방법
                    </th>
                    <th>
                        유효성
                    </th>
                    <th>
                        배송방법
                    </th>
                </tr>

            </table>
        </div>
    </div>
</div>

<footer id="footer">
    <script src="js/footer.js"></script>
</footer>

</body>

</html>
