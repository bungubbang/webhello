<%@ page import="java.util.List" %>
<%@ page import="shop.domain.Product" %>
<%@ page import="shop.domain.ShopUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shop</title>
    <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body style="text-align: center">
<h1>쇼핑몰</h1>
<br>
<p>${user.id} 님의 잔액 ${user.money} 원</p>
<table class="table table-striped table-hover" style="width: 50%; margin: 0 auto; cursor: hand;">
    <thead>
    <tr>
        <th>ID</th>
        <th>상품명</th>
        <th>가격</th>
        <th>상태</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}"  var="product">
        <tr>
            <td>${product.id}</td>
            <td style="width: 60%;" onclick="viewContents('${product.id}')">${product.name}</td>
            <td>${product.price}</td>
            <td>${product.status}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form action="/shop/login" method="delete">
    <input type="submit" value="로그아웃">
</form>

<jsp:include page="footer.jsp"></jsp:include>

<script type="text/javascript">
    var viewContents = function(id) {
        location.href = '/shop/view?id=' + id;
    }
</script>
</body>
</html>