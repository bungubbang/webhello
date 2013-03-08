<%--
  Created by IntelliJ IDEA.
  User: bungubbang
  Date: 13. 3. 7.
  Time: 오후 7:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<h1 style="margin-left: 200px;">Login</h1>
<br>
<form class="form-horizontal" action="/board/login" method="post">
    <div class="control-group">
        <label class="control-label" for="inputId">ID</label>
        <div class="controls">
            <% if(request.getAttribute("id") != null) { %>
            <input type="text" id="inputId" placeholder="bungubbang" value="<%= request.getAttribute("id") %>" name="id">
            <% } else { %>
            <input type="text" id="inputId" placeholder="bungubbang" name="id">
            <% } %>
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
            <label class="checkbox">
                <input type="checkbox" name="rememberId"> Remember me
            </label>
            <button type="submit" class="btn">Sign in</button>
        </div>
    </div>
</form>
</body>
</html>