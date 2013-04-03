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
    <form method="post" action="/shop/order">
    <h1> 상품 상세보기</h1>
    <br>
    <p><a href="/shop/list"><- 쇼핑몰 목록으로</a></p>
    <input type="hidden" name="productId" value="${product.id}">
    <input type="hidden" name="userId" value="${user.id}">
    <input type="hidden" name="status" value="배송중">
    <table class="table table-striped" style="width: 50%; margin: 0 auto;">
        <tr>
            <td>상품명</td>
            <td>${product.name}</td>
        </tr>
        <tr>
            <td>가격</td>
            <td>${product.price}</td>
        </tr>
        <tr>
            <td>남은 수량</td>
            <td>${product.stock}</td>
        </tr>
        <tr>
            <td>상태</td>
            <td>${product.status}</td>
        </tr>
        <tr>
            <td>주문 수량</td>
            <td><input type="text" name="amounts"></td>
        </tr>
        <tr>
            <td>코멘트</td>
            <td><input type="text" name="comments"></td>
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