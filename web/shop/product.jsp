<%@ page import="shop.domain.Product" %>
<%@ page import="shop.domain.ShopUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Board View</title>
    <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body style="text-align: center">
<form method="post" action="/shop/create">
    <h1> 제품 등록 </h1>
    <br>
    <p><a href="/shop/adminlist"><- 관리자 상품 목록으로</a></p>
    <input type="hidden" name="status" value="판매중">
    <table class="table table-striped" style="width: 50%; margin: 0 auto;">
        <tr>
            <td>상품명</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>가격</td>
            <td><input type="text" name="price"></td>
        </tr>
        <tr>
            <td>수량</td>
            <td><input type="text" name="stock"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="주문"></td>
        </tr>
    </table>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>