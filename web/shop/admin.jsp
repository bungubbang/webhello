<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body style="text-align: center">
<h1>관리자 페이지</h1>
<br>
<a href="/shop/order" class="btn">주문 관리</a>
<a href="/shop/adminlist" class="btn">상품 관리</a>


<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>