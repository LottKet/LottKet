<%@ page import="lotte.com.lottket.dto.ProductDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: BTC-N24
  Date: 2022-07-21
  Time: 오전 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<ProductDto> list = (List<ProductDto>)request.getAttribute("list");
%>
<%-- 이거 처음 불러올 때 body에 list를 준다 생각 --%>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<div class="contents-list">
    <form action="insertProduct.do">
        <div class="insert-content">
            제품이름 : <input type="text" name="productTitle"><br>
            제품카테고리 : <input type="text" name="productCategory"><br>
            가격 : <input type="text" name="productPrice"><br>
            재고 : <input type="text" name="productStock"><br>
            <div id="plus-image">
                <button type="button" onclick="plusImage()" value="추가">추가</button>
                <p>이미지 : <input type="text" name="productImage"><br></p>
            </div>
            <input type="submit" value="제품 추가">
        </div>
    </form>
    <div class="prodcut-list">
        <ul>
            <%
                int i=1;
                for(ProductDto productDto : list) {
            %>
            <li>
                <div class="product">
                    <input type="hidden" id="productId<%=i%>" value="<%=productDto.getProductId()%>">
                    제품이름 : <input type="text" id="productTitle<%=i%>" name="productTitle" value="<%=productDto.getProductTitle()%>"><br>
                    제품카테고리 : <input type="text" id="productCategory<%=i%>" ame="productCategory" value="<%=productDto.getProductCategory()%>"><br>
                    가격 : <input type="text" id="productPrice<%=i%>" name="productPrice" value="<%=productDto.getProductPrice()%>"><br>
                    재고 : <input type="text" id="productStock<%=i%>" name="productStock" value="<%=productDto.getProductStock()%>"><br>
                    <button type="button" onclick="updateProduct(<%=i%>)">상품 수정</button>
                    <button type="button" onclick="deleteProduct(<%=i%>)">상품 삭제</button>
                </div>
            </li>
            <%
                    i++;
                }
            %>
        </ul>
    </div>
</div>

<script>
    function updateProduct(index) {
        var form = document.createElement('form');
        let productId = document.getElementById("productId" + index).value;
        let productTitle = document.getElementById("productTitle" + index).value;
        let productCategory = document.getElementById("productCategory" + index).value;
        let productPrice = document.getElementById("productPrice" + index).value;
        let productStock = document.getElementById("productStock" + index).value;
        console.log(productId + " " + productTitle + " " + productCategory + " " + productPrice + " " + productStock);
        $.ajax({
            url:"updateProduct.do",
            type:"post",
            data: {
                "productId":productId,
                "productTitle":productTitle,
                "productCategory":productCategory,
                "productPrice":productPrice,
                "productStock":productStock
            },
            dataType:"json",
            success: function(result) {
                console.log(result);
            }
        });
        // form.setAttribute('method', 'post');
        // form.setAttribute('action', 'updateProduct.do');
        // document.characterSet = "utf-8";
        //     var hiddenField = document.createElement('input');
        //     hiddenField.setAttribute('productId', productId);
        //     hiddenField.setAttribute('productTitle', productTitle);
        //     hiddenField.setAttribute('productCategory', productCategory);
        //     hiddenField.setAttribute('productPrice', productPrice);
        //     hiddenField.setAttribute('productStock', productStock);
        //     form.appendChild(hiddenField);
        // document.body.appendChild(form);
        // form.submit();
    }
    function deleteProduct() {
        var form = document.createElement('form');
        let productId = document.getElementById("productId" + index);
        let productTitle = document.getElementById("productTitle" + index);
        let productCategory = document.getElementById("productCategory" + index);
        let productPrice = document.getElementById("productPrice" + index);
        let productStock = document.getElementById("productStock" + index);
        form.setAttribute('method', 'post');
        form.setAttribute('action', 'deleteProduct.do');
        document.characterSet = "utf-8";
            var hiddenField = document.createElement('input');
            hiddenField.setAttribute('productId', productId);
            hiddenField.setAttribute('productTitle', productTitle);
            hiddenField.setAttribute('productCategory', productCategory);
            hiddenField.setAttribute('productPrice', productPrice);
            hiddenField.setAttribute('productStock', productStock);
            form.appendChild(hiddenField);
        document.body.appendChild(form);
        form.submit();
    }

    function plusImage() {
        // let imageList = document.getElementById("plus-image");
        // let newP = document.createElement('p');
        // newP.innerHTML = "이미지 : <input type=\"text\" name=\"productImage\"><br>"
        // imageList.appendChild(newP);
        $("plus-image").append("<p><input type=\"text\" name=\"productImage\"></p><br>");
    }

    function reload() {
        location.reload();
    }
</script>
</body>
</html>
