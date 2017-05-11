<%--
  Created by IntelliJ IDEA.
  User: mehdi
  Date: 4/19/17
  Time: 12:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<html>
<head>
    <title>Services</title>
</head>
<body>

<c:if test="${not empty isRequestRegistered}">
    <c:choose>
        <c:when test="${isRequestRegistered}">
            <p style="color:green;">your request registered successfully ~</p>
        </c:when>
        <c:otherwise>
            <p style="color: red;">
            <p>your request didn't registered because of some problems!</p>
            <p>please contact us for further processing!</p>
            </p>
        </c:otherwise>
    </c:choose>

</c:if>

<form method="post" action="register-service">

    <c:forEach items="${petServices}" var="service" varStatus="i">
        <p>Service${i.index + 1}: (${service.serviceDescription}) <input type="radio" name="requestService"
                                                                         value="${service.serviceId}"/>
        </p>
    </c:forEach>
    <input type="submit" value="Request The Service"/>
</form>
</body>
</html>
