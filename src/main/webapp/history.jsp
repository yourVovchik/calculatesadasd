<%--
  Created by IntelliJ IDEA.
  User: Visa
  Date: 20.04.2021
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>History</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<c:forEach items="${requestScope.operations}" var="operation">
    <div class="alert alert-primary" role="alert">
        ${operation.a} ${operation.operationMark} ${operation.b} = ${operation.answer}
    </div>
</c:forEach>
</body>
</html>
