<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1 style="margin-left: 200px;">가입하기</h1>
<br>
<form class="form-horizontal" action="/shop/join" method="post">
    <div class="control-group">
        <label class="control-label" for="inputId">ID</label>
        <div class="controls">
            <c:if test="${id != null}">
                <input type="text" id="inputId" placeholder="bungubbang" value="${id}" name="id">
            </c:if>
            <c:if test="${id == null}">
                <input type="text" id="inputId" placeholder="bungubbang" name="id">
            </c:if>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="money">최초 Money</label>
        <div class="controls">
            <input type="text" id="money" placeholder="100000" name="money">
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="inputPassword">Password</label>
        <div class="controls">
            <input type="password" id="inputPassword" placeholder="skp" name="password">
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <button type="submit" class="btn">Sign in</button>
        </div>
    </div>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>