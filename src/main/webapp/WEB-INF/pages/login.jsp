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

<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Welcome to SLU-Geeks Pet Services</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">

    </head>

    <body>
        <div class="top-content">

            <div class="inner-bg">
                <div class="container">

                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1>Welcome to SLU-Geeks Pet Services</h1>
                            <div class="description">
                                <img src="../../assets/img/paw.png" alt="Paw" class="avatar">
                            </div>
                        </div>
                    </div>

                    <div class="row">


                        <div class="col-sm-6 col-sm-offset-3">

                            <div class="form-box">
                                <div class="form-top">
                                    <div class="form-top-left">
                                        <h3>Greetings!</h3>
                                        <p>Please enter your username and password to log on:</p>
                                    </div>
                                    <div class="form-top-right">
                                        <i class="fa fa-key"></i>
                                    </div>
                                </div>
                                <c:if test="${not empty errors}">
                                    <c:forEach items="${errors}" var="error">
                                        <p style="color: red;">${error}</p>
                                    </c:forEach>
                                </c:if>
                                <div class="form-bottom">
                                    <form method="post" action="/login" role="form" class="login-form">
                                        <div class="form-group">
                                            <label class="sr-only" for="username">Username</label>
                                            <input type="text" name="username" placeholder="Username..." class="form-username form-control" id="form-username">
                                        </div>
                                        <div class="form-group">
                                            <label class="sr-only" for="password">Password</label>
                                            <input type="password" name="password" placeholder="Password..." class="form-password form-control" id="form-password">
                                        </div>
                                        <input type="submit" value="Log in"/>
                                    </form>
                                </div>
                            </div>

                        </div>
                        <div class="col-sm-1"></div>

                        <div class="col-sm-5">



                        </div>
                    </div>

                </div>
            </div>

        </div>

        <!-- Footer -->
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