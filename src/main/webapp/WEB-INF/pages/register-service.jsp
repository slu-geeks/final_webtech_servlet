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
    <link rel="stylesheet" href="../../assets/css/bootstrap.css"/>
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
    <form role="form">
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
    <input type="submit" value="Request The Service" class="btn"/>
    
</form>
 </div>   
</body>
</html>
