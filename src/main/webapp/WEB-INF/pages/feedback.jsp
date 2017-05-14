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
    <title>Feedback Page</title>
    <link rel="stylesheet" type="text/css" href="assets/style/style.css">
    <link rel="stylesheet" type="text/css" href="assets/style/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="assets/style/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="assets/style/modern-business.css">

</head>
<body>
<div>
    <div class="navbar-inverse navbar-static-top" role="navigation">
        <div class="nav-header">
            <a class="navbar-brand" href="dashboard"
               title="Go to main page !">Dashboard</a>
            <a class="navbar-brand" href="request-service">Request a Service</a>
            <a class="navbar-brand" href="request-log">Requests Log</a>
            <a class="navbar-brand" href="feedback-log">Feedback Log</a>
            <a class="navbar-brand" href="give-feedback">Give Feedback</a>
            <a class="navbar-brand" href="profile">Profile</a>
            <a class="navbar-brand" href="signout">Sign out</a>
        </div>
        <!-- nav-header -->

        <div class="collapse navbar-collapse navbar-ex1-collapse">

        </div>
        <!-- collapse -->
    </div>
</div>
<!-- navbar -->

<div>
    <div id="contact-form">
        <div class="fb">
            <h1>Feedback</h1>

        </div>
        <c:if test="${not empty insertSuccessful}">
            <c:choose>
                <c:when test="${insertSuccessful == true}">
                    <h3 style="color:green;">your feedback successfully registered ~</h3>
                </c:when>

                <c:otherwise>
                    <div style="color: red;">
                        <h3>something went wront, contact your admin!</h3>
                    </div>
                </c:otherwise>
            </c:choose>
        </c:if>
        <form method="post" action="/give-feedback">
            <!--selectRequest-->
            <div>
                <span>Select Request: *</span>
                <select id="selectRequest" name="requestId">
                    <option selected="selected" value="Not checked">Not Checked</option>
                    <c:forEach items="${allUserRequests}" var="rsp">
                        <option value="${rsp.request.requestId}">${rsp.petService.serviceName} ${rsp.request.requestDate}</option>
                    </c:forEach>
                </select>
            </div>
            <!--Ranking-->
            <div>
                <span class="required">Ranking: *</span>
                <input type="number" min="0" max="10" name="feedback_ranking" placeholder="1-10" tabindex="2"
                       required="required"/>
            </div>
            <!--Message-->
            <div>
                <span class="required">Feedback Message: *</span>
                <textarea type="text" id="message" name="feedback_message" placeholder="Please write your message here."
                          tabindex="5" required="required"></textarea>
            </div>
            <!--Submit-->
            <div>
                <button name="submit" type="submit" id="submit" value="submit">SEND</button>
            </div>
        </form>

    </div>
</div>

</body>
</html>
