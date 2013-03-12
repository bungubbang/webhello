<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="myboard.entity.Board" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
        <title>Board</title>
        <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
  </head>
  <body style="text-align: center">

   <%
       List<Board> boards = (List<Board>) request.getAttribute("boards");
   %>
   <h1>JSP 게시판</h1>
   <br>
   <p><a href="/board/createForm">게시물 작성</a></p>
   <form action="/board/login" method="delete">
       <input type="submit" value="로그아웃">
   </form>
   <p>현재 접속자수 : ${loginCount}</p>
   <table class="table table-striped table-hover" style="width: 50%; margin: 0 auto; cursor: hand;">
       <thead>
            <tr>
                <th>ID</th>
                <th>TITLE</th>
                <th>WRITER</th>
                <th>MODIFY</th>
                <th>DELETE</th>
            </tr>
       </thead>
       <tbody>
            <c:forEach items="${boards}"  var="board">
            <tr>
                <td>${board.getId()}</td>
                <td style="width: 60%;" onclick="viewContents('${board.getId()}')">${board.getTitle()}</td>
                <td>${board.getWriter()}</td>
                <td onclick="modifyContents('${board.getId()}')">+</td>
                <td onclick="deleteContents('${board.getId()}')">-</td>
            </tr>
            </c:forEach>
       </tbody>
   </table>

   <jsp:include page="boardfooter.jsp"></jsp:include>

    <script type="text/javascript">
        var viewContents = function(id) {
            location.href = '/board/view?id=' + id;
        }

        var modifyContents = function(id) {
            location.href = '/board/modifyForm?id=' + id;
        }

        var deleteContents = function(id) {
            location.href = '/board/delete?id=' + id;
        }
    </script>
  </body>
</html>