<%--
  Created by IntelliJ IDEA.
  User: Visa
  Date: 20.04.2021
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<form action="/authorization" method="post">
    <div class="mb-3">
        <label for="login" class="form-label">Login</label>
        <input type="text" class="form-control" id="login" name = "login">
    </div>
    <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" class="form-control" id="password" name = "password">
    </div>
    <button type="submit" class="btn btn-primary">Enter</button>
</form>
<c:if test="${requestScope.checkAccount != null}">
    <div class="alert alert-primary" role="alert">
        ${requestScope.get("checkAccount")}
    </div>
</c:if>
</body>
</html>
