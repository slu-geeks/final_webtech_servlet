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

<!doctype html>

<html>
<head>
    <title>Add New Account</title>

</head>

<body>

<c:if test="${not empty errors}">
    <c:forEach items="${errors}" var="error">
        <p style="color: red;">${error}</p>
    </c:forEach>
</c:if>

<form method="post" action="/signup" enctype="multipart/form-data">
    <p>username: <input type="text" name="username" value="mehdi"/></p>
    <p>password: <input type="password" name="password" value="123"/></p>
    <p>address: <input type="text" name="address" value="baguio"/></p>
    <p>first name: <input type="text" name="firstName" value="Mehdi"/></p>
    <p>last name: <input type="text" name="lastName" value="Afsari"/></p>
    <p>middle initial: <input type="text" name="middleInitial" value="" /></p>
    <p>email address: <input type="text" name="emailAddress" value="mehdi@mail.com"/></p>
    <p>phone number: <input type="text" name="phoneNumber" value="09062658383"/></p>
    <p>date of birth: <input type="date" name="dateOfBirth" value="1986-07-29"/></p>
    <p>person pic: <input type="file" name="personPicture"></p>
    <input type="submit" value="submit" />
</form>
</body>
</html>
