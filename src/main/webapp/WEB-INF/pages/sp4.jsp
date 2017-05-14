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
            <h1>Your Service Provider</h1>
            <hr>
            <div class="row">

                <div class="col-md-8 col-sm-offset-2 personal-info">
                    <h3>Personal info</h3>

                    <%--<c:set var="activeUser" value="activeUser" scope="session" />--%>
                    <form action="sp1" method="post" class="form-horizontal" role="form">

                        <div class="form-group">
                            <label class="col-lg-3 control-label">Home address</label>
                            <div class="col-lg-8">
                                <input name="address" class="form-control" type="text" value="Baguio City">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-lg-3 control-label">First name:</label>
                            <div class="col-lg-8">
                                <input name="firstName" class="form-control" type="text" value="SerVere">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-lg-3 control-label">Last name</label>
                            <div class="col-lg-8">
                                <input name="lastName" class="form-control" type="text" value="Proder">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-lg-3 control-label">Middle Initial</label>
                            <div class="col-lg-8">
                                <input name="middleInitial" class="form-control" type="text" value="S">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-lg-3 control-label">Email address</label>
                            <div class="col-lg-8">
                                <input name="emailAddress" class="form-control" type="text" value="sp4@gmail.com">
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-lg-3 control-label">Phone number</label>
                            <div class="col-lg-8">
                                <input name="phoneNumber" class="form-control" type="text" value="09171234590">
                            </div>
                        </div>

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
