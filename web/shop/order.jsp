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
<h1>나의 쇼핑정보</h1>
<br>
<p><a href="/shop/list"><- 쇼핑몰 목록으로</a></p>
<p>${user.id} 님의 잔액 ${user.money} 원</p>
<table class="table table-striped table-hover" style="width: 80%; margin: 0 auto; cursor: hand;">
    <thead>
    <tr>
        <th>ID</th>
        <th>상품명</th>
        <th>가격</th>
        <th>수량</th>
        <th>주문자</th>
        <th>상태</th>
        <th>코멘트</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orderJoins}"  var="orderjoin">
        <tr>
            <td>${orderjoin.id}</td>
            <td>${orderjoin.name}</td>
            <td>${orderjoin.price}</td>
            <td>${orderjoin.amounts}</td>
            <td>${orderjoin.userId}</td>
            <td>${orderjoin.status}</td>
            <td>${orderjoin.comments}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form action="/shop/login" method="delete">
    <input type="submit" value="로그아웃">
</form>
<p>현재 접속자수 : ${loginCount}</p>

<jsp:include page="footer.jsp"></jsp:include>

<script type="text/javascript">
    var viewContents = function(id) {
        location.href = '/shop/view?id=' + id;
    }
</script>
</body>
</html>