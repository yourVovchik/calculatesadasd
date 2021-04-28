<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Change Name</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<form action="/changename" method="post">
    <div class="mb-3">
        <label for="newName" class="form-label">New Name</label>
        <input type="text" class="form-control" id="newName" name = "newName">
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