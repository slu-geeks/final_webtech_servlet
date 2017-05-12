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



<form method="post" action="register-service">

    <c:forEach items="${petServices}" var="service" varStatus="i">
        <p>Service${i.index + 1}: (${service.serviceDescription})
            <input type="radio" name="requestService"  value="${service.serviceId}"/>
        </p>
    </c:forEach>
    <input type="submit" value="Request The Service"/>
</form>
</body>
</html>
