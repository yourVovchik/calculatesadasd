<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Change Name</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<form action="/changePassword" method="post">
    <div class="mb-3">
        <label for="oldPassword" class="form-label">Password</label>
        <input type="password" class="form-control" id="oldPassword" name = "oldPassword">
    </div>
    <div class="mb-3">
        <label for="newPassword" class="form-label">New password</label>
        <input type="password" class="form-control" id="newPassword" name = "newPassword">
    </div>
    <button type="submit" class="btn btn-primary">Enter</button>
</form>
<c:if test="${requestScope.attempt != null}">
    <div class="alert alert-primary" role="alert">
            ${requestScope.get("attempt")}
    </div>
</c:if>
</body>
</html>