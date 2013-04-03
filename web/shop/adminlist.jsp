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
<h1>쇼핑몰 관리자페이지</h1>
<br>
<a href="/shop/admin">관리자 페이지</a><br><br>
<a href="/shop/create" class="btn">제품 등록</a>
<table class="table table-striped table-hover" style="width: 80%; margin: 0 auto; cursor: hand;">
    <thead>
    <tr>
        <th>ID</th>
        <th>상품명</th>
        <th>가격</th>
        <th>남은 수량</th>
        <th>상태</th>
        <th>수정</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}"  var="product">
        <tr>
            <td>${product.id}</td>
            <td style="width: 60%;" onclick="viewContents('${product.id}')">${product.name}</td>
            <td>${product.price}</td>
            <td>${product.stock}</td>
            <td>${product.status}</td>
            <td><a href="/shop/modify?id=${product.id}" class="btn">수정</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="footer.jsp"></jsp:include>

<script type="text/javascript">
    var viewContents = function(id) {
        location.href = '/shop/view?id=' + id;
    }
</script>
</body>
</html>