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
<head lang="en">
    <meta charset="UTF-8">
    <title>Service Request</title>
    <link rel="stylesheet" href="../../assets/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" href="../../assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../../assets/css/build.css"/>
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
<div class="container">
    <h2>Service Form</h2>
    <%--<form role="form">
        <div class="row">
            <div class="col-md-4">
                <fieldset>
                    <legend>
                        Pet Health Care
                    </legend>
                    <div class="checkbox checkbox-success">
                        <input id="checkbox3" class="styled" type="checkbox">
                        <label for="checkbox3">
                            Check-up/Consultation
                        </label>
                    </div>
                    <div class="checkbox checkbox-success">
                        <input id="checkbox3" class="styled" type="checkbox">
                        <label for="checkbox3">
                            Dental
                        </label>
                    </div>
                    <div class="checkbox checkbox-success">
                        <input id="checkbox3" class="styled" type="checkbox">
                        <label for="checkbox3">
                            Vaccination
                        </label>
                    </div>
                    <div class="checkbox checkbox-success">
                        <input id="checkbox3" class="styled" type="checkbox">
                        <label for="checkbox3">
                            Deworming
                        </label>
                    </div>
                    <div class="checkbox checkbox-success">
                        <input id="checkbox3" class="styled" type="checkbox">
                        <label for="checkbox3">
                            Blood Testing
                        </label>
                    </div>
                    <legend>
                        Training
                    </legend>
                    <div class="checkbox checkbox-success">
                        <input id="checkbox3" class="styled" type="checkbox">
                        <label for="checkbox3">
                            Swimming
                        </label>
                    </div>
                    <div class="checkbox checkbox-success">
                        <input id="checkbox3" class="styled" type="checkbox">
                        <label for="checkbox1">
                            Tricks
                        </label>
                    </div>
                    <legend>
                        Grooming
                    </legend>
                    <div class="checkbox checkbox-success">
                        <input id="checkbox3" class="styled" type="checkbox">
                        <label for="checkbox3">
                            Massage
                        </label>
                    </div>
                    <div class="checkbox checkbox-success">
                        <input id="checkbox3" class="styled" type="checkbox">
                        <label for="checkbox3">
                            Haircut
                        </label>
                    </div>
                    <div class="checkbox checkbox-success">
                        <input id="checkbox3" class="styled" type="checkbox">
                        <label for="checkbox3">
                            Pedicure
                        </label>
                    </div>
                </fieldset>
            </div>
        </div>
    </form>
    --%>
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
            <div>
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

                            <tr>
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
