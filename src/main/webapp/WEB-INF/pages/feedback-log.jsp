<%-- 
    Document   : feedback-log
    Created on : 05 12, 17, 10:49:23 PM
    Author     : Buhnahnah
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<html>
    <head>
        <title>Feedback log</title>

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

        Feedback history

        <div>

            <table class="table">
                <tr>
                    <th>Type of Service</th>
                    <th>Date</th>
                    <th>Comment</th>
                    <th>Service Provider</th>
                    <th>Ratings</th>
                </tr>

                <c:forEach items="${feedBackLog}" var="feedBack" >
                    <tr>
                        <td>${feedBack.feedbackId.feedback}</td>
                        <td>${service.request.requestDate}</td>
                        <td>${feedBack.feedbackMessage.feedback_message}</td>
                        <td>${service.serviceProvider.firstName}, ${service.serviceProvider.lastName}</td>
                        <td>${feedBack.feedbackRanking.feedback_ranking}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>