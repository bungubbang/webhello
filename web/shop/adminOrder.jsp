<%@ page import="java.util.List" %>
<%@ page import="shop.domain.Product" %>
<%@ page import="shop.domain.ShopUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shop</title>
    <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
</head>
<body style="text-align: center">
<h1>쇼핑관리자 페이지</h1>
<br>
<p><a href="/shop/admin"><- 관리자페이지</a></p>
<table class="table table-striped table-hover" style="width: 90%; margin: 0 auto; cursor: hand;">
    <thead>
    <tr>
        <th>ID</th>
        <th>상품명</th>
        <th>가격</th>
        <th>수량</th>
        <th>주문자</th>
        <th>상태</th>
        <th>수정</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orderJoins}"  var="orderjoin">
        <tr>
            <form action="/shop/order/update" method="POST">
            <td>${orderjoin.id}</td>
            <td>${orderjoin.name}</td>
            <td>${orderjoin.price}</td>
            <td>${orderjoin.amounts}</td>
            <td>${orderjoin.userId}</td>
            <td>
                ${orderjoin.status}<br>
                <select name="status" value="${orderjoin.status}">
                    <option value="배송중">배송중</option>
                    <option value="배송완료">배송완료</option>
                </select>
            </td>
            <td>
                <input type="hidden" name="id" value="${orderjoin.id}">
                <input type="submit" value="주문">
            </td>
            </form>
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

    $(document).ready(function(){
        var statusLength = $('[name=status]').length;
        for(i=0; i< statusLength; i++){

        }
    });
</script>
</body>
</html>