
$("#emart_de").on('click',function(){
         let category = $('#category').text();

         alert("aa");

        $.ajax({
              url: "<%=request.getContextPath()%>/category/productPrice.do",
              type: "get",
              data:{"productCategory":category, "search": ""},
              dataType:'json',
              contentType:"application/json;charset=UTF-8",
              success: function (result) {
                console.log(result);
                document.getElementById("id_productList").innerHTML = '';

                let str="";
                for(let i=0;i<result.length;i++){
                    let dto= result[i];
                    console.log(dto.productTitle);

                    if(i%4==0) str+=`<ul style="display:flex">`;

                    str+=
                        "<li onclick='detail()'>"+
                        "<img src="+dto.productImageUrl+">"+
                         "<span>"+dto.productTitle+"</span>"+
                         "<span>"+dto.productPrice+"</span>"+
                         "<span><img src='<%=request.getContextPath()%>/img/fullStar.png' style='width: 25px;height: 25px;float: left;'>"+dto.productTotalRate+"</span>"+
                        "</li>";

                 document.getElementById("id_productList").innerHTML = str;
                }
              }
            });


    });

    $(".regDate").on('click',function(){
            let category = $('#list_id_h1').text();
            $.ajax({
                  url: "<%=request.getContextPath()%>/category/regDate.do",
                  type: "get",
                  data:{"productCategory": category, "search": ""},
                  dataType:'json',
                  contentType:"application/json;charset=UTF-8",
                  success: function (result) {
                    console.log(result);
                    document.getElementById("id_productList").innerHTML = '';

                    let str="";
                    for(let i=0;i<result.length;i++){
                        let dto= result[i];
                        console.log(dto.productTitle);

                        if(i%4==0) str+=`<ul style="display:flex">`;

                        str+=
                            "<li onclick='detail()'>"+
                            "<img src="+dto.productImageUrl+">"+
                             "<span>"+dto.productTitle+"</span>"+
                             "<span>"+dto.productPrice+"</span>"+
                             "<span><img src='<%=request.getContextPath()%>/img/fullStar.png' style='width: 25px;height: 25px;float: left;'>"+dto.productTotalRate+"</span>"+
                            "</li>";

                     document.getElementById("id_productList").innerHTML = str;
                    }
                  }
                });


        });

        $(".totalRate").on('click',function(){
                let category = $('#list_id_h1').text();
                    $.ajax({
                          url: "<%=request.getContextPath()%>/category/totalRate.do",
                          type: "get",
                          data:{"productCategory":category, "search": ""},
                          dataType:'json',
                          contentType:"application/json;charset=UTF-8",
                          success: function (result) {
                            console.log(result);
                            document.getElementById("id_productList").innerHTML = '';

                            let str="";
                            for(let i=0;i<result.length;i++){
                                let dto= result[i];
                                console.log(dto.productTitle);

                                if(i%4==0) str+=`<ul style="display:flex">`;

                                str+=
                                    "<li onclick='detail()'>"+
                                    "<img src="+dto.productImageUrl+">"+
                                     "<span>"+dto.productTitle+"</span>"+
                                     "<span>"+dto.productPrice+"</span>"+
                                     "<span><img src='<%=request.getContextPath()%>
      /img/fullStar.png' style='width: 25px;height: 25px;float: left;'>"
                                          + dto.productTotalRate
                                          + "</span>" + "</li>";

                                    document
                                          .getElementById("id_productList").innerHTML = str;
                                 }
                              }
                           });

                  });

      function detail() {
         alert("detail");
      }