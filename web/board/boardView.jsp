<%@ page import="myboard.entity.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Board View</title>
    <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body style="text-align: center">

    <h1> JSP 게시판 상세보기</h1>
    <br>
    <p><a href="/board/list"><- 게시판 목록으로</a></p>
    <table class="table table-striped" style="width: 50%; margin: 0 auto;">
        <tr>
            <td>제목</td>
            <td>${board.getTitle()}</td>
        </tr>
        <tr>
            <td>작성자</td>
            <td>${board.getWriter()}</td>
        </tr>
        <tr>
            <td>내용</td>
            <td>${board.getContent()}</td>
        </tr>
    </table>
    <jsp:include page="boardfooter.jsp"></jsp:include>
</body>
</html>