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
    <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Request a Service</title>
        
<link href="http://fonts.googleapis.com/css?family=Montserrat:300,400,700" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Muli:300,400" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="assets/css/build.css"/>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css"/>   
</head>
<body>
<header class="lv-bg">
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
<div class="container">
    <h2>Service Form</h2>
    <c:choose>
        <c:when test="${not empty isRequestRegistered}">
            <c:choose>
                <c:when test="${isRequestRegistered}">
                    <div>
                    <h2 style="color:green;">your request registered successfully ~</h2>
                        <h3><a href="request-log" >Go back to requested Log page</a></h3>
                    </div>
                </c:when>

                <c:otherwise>
                    <div style="color: red;">
                    <h2>your request didn't registered because of some problems!</h2>
                    <h3>please contact us for further processing!</h3>
                    <a href="dashboard" >Go back to Dashboard</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </c:when>
        <c:otherwise>
            <div class="container-fluid inner">
                <form method="post" action="request-service">
                    <table class="table">
                        <tr>
                            <th>Picture</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Estimated Service Hour</th>
                            <th>Provider Name</th>
                            <th>About Provider</th>
                            <th>checking The Service</th>
                        </tr>


                        <c:forEach items="${serviceAvailable}" var="service">

                            <tr><div class="c"></div>  
                                <td>${service.petService.servicePicture}</td>
                                <td>${service.petService.serviceName}</td>
                                <td>${service.petService.serviceDescription}</td>
                                <td>${service.petService.servicePrice}</td>
                                <td>${service.petService.serviceHours}</td>
                                <td>${service.serviceProvider.firstName}, ${service.serviceProvider.lastName}</td>
                                <td><a href="" onclick="">More Information</a></td>
                                <td><input type="checkbox" name="service"
                                           value="${service.petService.serviceId}:${service.serviceProvider.accountId}"></td>
                            </tr>
                        </c:forEach>
                    </table>
                    <input type="submit" value="request"/>
                </form>
            </div>
        </c:otherwise>
    </c:choose>

</div>
</body>
</html>
