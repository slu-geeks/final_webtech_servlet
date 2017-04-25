<%--
  Created by IntelliJ IDEA.
  User: mehdi
  Date: 4/19/17
  Time: 11:30 AM
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
<a href="">available services</a>@nbsp;
<a href="">requested services</a>@nbsp;
<a href="">feedback</a>@nbsp;
<a href="">profile</a>@nbsp;

<div>


    <form method="post" action="/feedback" >
        <c:forEach items="${petServices}" var="service" >

        </c:forEach>
        <input type="submit" value="submit" />
    </form>

    <form method="post" action="/feedback">
        <select id="selectRequest" name="feedback">
            <option selected="selected" value="Not checked">Not checked</option>
            <option value="requestId1">Pet Sitting Date: 2017-1-11</option>
            <option value="requestId2">Pet Sitting Date: 2017-1-12</option>
            <option value="requestId3">Pet Cleaning Date: 2017-1-15</option>
            <option value="requestId4">Pet Cleaning Date: 2017-1-16</option>
        </select>

        <input type="number" min="0" max="10" name="feedback_ranking"/>
        <input type="text" name="feedback_message"/>

        <input type="submit" value="submit"/>

    </form>
</div>

</body>
</html>
