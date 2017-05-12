<%--
  Created by IntelliJ IDEA.
  User: mehdi
  Date: 4/24/17
  Time: 12:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<html>
<head>
    <title>Requested Services</title>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Welcome to SLU-Geeks Pet Services</title>

    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="../../assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../assets/css/form-elements.css">
    <link rel="stylesheet" href="../../assets/css/style.css">
</head>
<body>

<header>
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
                <a class="navbar-brand" href="signout">sign out</a>
            </div>
            <!-- nav-header -->

            <div class="collapse navbar-collapse navbar-ex1-collapse">

            </div>
            <!-- collapse -->
        </div>
    </div>
    <!-- navbar -->
</header>

All Requested Services

<div>

    <table class="table">
        <tr>
            <th>Picture</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Request Date</th>
            <th>Request Status</th>
            <th>Estimated Service Hour</th>
            <th>Provider Name</th>


        </tr>

        <c:forEach items="${allRequests}" var="service" >
            <tr>
                <td>${service.petService.servicePicture}</td>
                <td>${service.petService.serviceName}</td>
                <td>${service.petService.serviceDescription}</td>
                <td>${service.petService.servicePrice}</td>
                <td>${service.request.requestDate}</td>

                    <c:choose>
                        <c:when test="${service.request.requestStatus eq 1}">
                            <td>Waiting <img src="../../assets/img/waiting.png" alt="Not Checked By Service Provider" /></td>
                        </c:when>
                        <c:when test="${service.request.requestStatus eq 2}">
                            <td>Received <img src="../../assets/img/checked.png" alt="service has been received and checked by service provider" /></td>
                        </c:when>
                        <c:when test="${service.request.requestStatus eq 3}">
                            <td>Ongoing <img src="../../assets/img/ongoing.png" alt="servicing is ongoing" /></td>
                        </c:when>
                        <c:when test="${service.request.requestStatus eq 4}">
                            <td>Done <img src="../../assets/img/done.png" alt="servicing is already Finished" /></td>
                        </c:when>
                    </c:choose>

                <td>${service.petService.serviceHours}</td>
                <td>${service.serviceProvider.firstName}, ${service.serviceProvider.lastName}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>