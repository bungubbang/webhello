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
<form method="post" action="/shop/modify">
    <h1> 상품 수정하기</h1>
    <br>
    <p><a href="/shop/adminlist"><- 상품관리 목록으로</a></p>
    <input type="hidden" name="id" value="${product.id}">
    <table class="table table-striped" style="width: 50%; margin: 0 auto;">
        <tr>
            <td>상품명</td>
            <td><input type="text" name="name" value="${product.name}"></td>
        </tr>
        <tr>
            <td>가격</td>
            <td><input type="text" name="price" value="${product.price}"></td>
        </tr>
        <tr>
            <td>남은 수량</td>
            <td><input type="text" name="stock" value="${product.stock}"></td>
        </tr>
        <tr>
            <td>상태</td>
            <td><input type="text" name="status" value="${product.status}"></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="수정" class="btn">
                <a href="/shop/delete?id=${product.id}" class="btn btn-alert">삭제</a>
            </td>
        </tr>
    </table>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>