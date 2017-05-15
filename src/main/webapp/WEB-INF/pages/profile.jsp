<%--
  Created by IntelliJ IDEA.
  User: mehdi
  Date: 4/19/17
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<html>
<head>
    <title>Title</title>
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

<div class="container">
    <h1>Edit Profile</h1>
    <hr>
    <div class="row">
        <!-- left column -->
        <div class="col-md-3">
            <div class="text-center">
                <img src="//placehold.it/100" class="avatar img-circle" alt="avatar">
                <h6>Upload a different photo...</h6>

                <input type="file" class="form-control">
            </div>
        </div>

        <div class="col-md-9 personal-info">
            <div class="alert alert-info alert-dismissable">
                <a class="panel-close close" data-dismiss="alert">×</a>
                <i class="fa fa-coffee"></i>
                Hello There.
            </div>
            <h3>Personal info</h3>


            <%--<c:set var="activeUser" value="activeUser" scope="session" />--%>
            <c:if test="${not empty passwordDoesntMatch}">
                <c:choose>
                    <c:when test="${passwordDoesntMatch == true}">
                        <h3 style="color:red;">your password must match ~</h3>
                    </c:when>
                </c:choose>
            </c:if>

            <%--<c:set var="activeUser" value="activeUser" scope="session" />--%>
            <c:if test="${not empty updateSuccessful}">
                <c:choose>
                    <c:when test="${updateSuccessful == true}">
                        <h3 style="color:green;">your profile successfully updated ~</h3>
                    </c:when>

                    <c:otherwise>
                        <div style="color: red;">
                            <h3>something went wront, contact your admin!</h3>
                        </div>
                    </c:otherwise>
                </c:choose>
            </c:if>
            <form action="profile" method="post" class="form-horizontal" role="form">

                <div class="form-group">
                    <label class="col-lg-3 control-label">Home address</label>
                    <div class="col-lg-8">
                        <input name="address" class="form-control" type="text" value="${activeUser.address}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">First name:</label>
                    <div class="col-lg-8">
                        <input name="firstName" class="form-control" type="text" value="${activeUser.firstName}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">Last name</label>
                    <div class="col-lg-8">
                        <input name="lastName" class="form-control" type="text" value="${activeUser.lastName}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">Middle Initial</label>
                    <div class="col-lg-8">
                        <input name="middleInitial" class="form-control" type="text" value="${activeUser.middleInitial}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">Email address</label>
                    <div class="col-lg-8">
                        <input name="emailAddress" class="form-control" type="text" value="${activeUser.emailAddress}">
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-lg-3 control-label">Phone number</label>
                    <div class="col-lg-8">
                        <input name="phoneNumber" class="form-control" type="text" value="${activeUser.phoneNumber}">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-lg-3 control-label">Date of Birth</label>
                    <div class="col-lg-8">
                        <input name="dateOfBirth" class="form-control" type="text" value="${activeUser.dateOfBirth}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">Username</label>
                    <div class="col-lg-8">
                        <input name="username" class="form-control" type="text" value="${activeUser.username}">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">Password</label>
                    <div class="col-lg-8">
                        <input name="Password" class="form-control" type="text" value="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-3 control-label">Confirm Password</label>
                    <div class="col-lg-8">
                        <input name="rePassword" class="form-control" type="text" value="">
                    </div>
                </div>
            <input type="submit" class="btn btn-primary" value="Update">
            <span></span>
            <input type="reset" class="btn btn-default" value="Cancel">
            </form>
        </div>
    </div>
</div>
<hr>



<footer>
    <div class="container">
        <div class="row">

            <div class="col-sm-8 col-sm-offset-2">
                <div class="footer-border"></div>
                <p>WebTek Finals, Copyright &copy; 2017</p>
            </div>

        </div>
    </div>
</footer>
</body>
</html>
