<%--
  Created by IntelliJ IDEA.
  User: Visa
  Date: 20.04.2021
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculate</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<form action="/calculate" method="post">
    <div class="mb-3">
        <label for="a" class="form-label">Number 1</label>
        <input type="number" class="form-control" id="a" name = "a">
    </div>
    <div class="mb-3">
        <label for="b" class="form-label">Number 2</label>
        <input type="number" class="form-control" id="b" name = "b">
    </div>
    <div class="mb-3">
        <label for="mark" class="form-label">Mark</label>
        <input type="text" class="form-control" id="mark" name = "mark" placeholder=" SUM / MUL / DIF / DIV">
    </div>
    <button type="submit" class="btn btn-primary">Count</button>
</form>
<c:if test="${requestScope.answer != null}">
    <div class="alert alert-primary" role="alert">
            ${requestScope.get("answer")}
    </div>
</c:if>
</body>
</html>
