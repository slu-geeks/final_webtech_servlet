<%--
  Created by IntelliJ IDEA.
  User: mehdi
  Date: 4/24/17
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${not empty errors}">
    <c:forEach items="${errors}" var="error">
        <p style="color: red;">${error}</p>
    </c:forEach>
</c:if>

<form method="post" action="/login">
    <p>username: <input type="text" name="username" /></p>
    <p>password: <input type="text" name="password" /></p>
    <input type="submit" value="login" />
</form>
</body>
</html>
