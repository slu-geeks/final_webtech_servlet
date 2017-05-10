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

<!doctype html>

<html>
<head>
    <title>Add New Account</title>

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
                            <img src="assets/img/paw.png" alt="Paw" class="avatar">
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-5">

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
                                    <button type="submit" class="btn">Sign in!</button>
                                </form>
                            </div>
                        </div>

                    </div>

                    <div class="col-sm-1 middle-border"></div>
                    <div class="col-sm-1"></div>

                    <div class="col-sm-5">

                        <div class="form-box">
                            <div class="form-top">
                                <div class="form-top-left">
                                    <h3>Sign up now</h3>
                                    <p>Fill in the form below:</p>
                                </div>
                                <div class="form-top-right">
                                    <i class="fa fa-pencil"></i>
                                </div>
                            </div>
                            
                            <c:if test="${not empty errors}">
                                <c:forEach items="${errors}" var="error">
                                    <p style="color: red;">${error}</p>
                                </c:forEach>
                            </c:if>
                            <c:if test="${not empty registerSuccess}">
                                <p style="color: green;">Register successfull !</p>
                            </c:if>   
                            <div class="form-bottom">
                                <form method="post" action="/signup" enctype="multipart/form-data" class="registration-form">
                                    <div class="form-group">
                                        <label class="sr-only" for="username">Username</label>                      
                                        <input type="text" name="username" placeholder="Username..." class="form-first-name form-control" id="form-first-name">
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="password">Password</label>
                                        <input type="password" name="password" placeholder="Password..." class="form-password form-control" id="form-password">
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="sr-only" for="address">Home address</label>
                                        <input type="text" name="address" placeholder="Home address..." class="form-first-name form-control" id="form-first-name">
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="sr-only" for="firstName">First name</label>
                                        <input type="text" name="firstName" placeholder="First name..." class="form-first-name form-control" id="form-first-name">
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="lastName">Last name</label>
                                        <input type="text" name="lastName" placeholder="Last name..." class="form-last-name form-control" id="form-last-name">
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="sr-only" for="middleInitial">Middle Initial</label>
                                        <input type="text" name="middleInitial" placeholder="Middle initial..." class="form-last-name form-control" id="form-last-name">
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="sr-only" for="emailAddress">Email address</label>
                                        <input type="text" name="emailAddress" placeholder="Email address..." class="form-email form-control" id="form-email">
                                    </div>

                                    <div class="form-group">
                                        <label class="sr-only" for="phoneNumber">Phone number</label>
                                        <input type="text" name="phoneNumber" placeholder="Phone number..." class="form-first-name form-control" id="form-first-name">
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="dateOfBirth">Date of birth</label>
                                        <input type="date" name="dateOfBirth" placeholder="Birthday... yyyy-mm-dd" class="form-first-name form-control" id="form-first-name">
                                    </div>
                                    
                                    
                                    <div class="form-group">
                                        <label class="sr-only" for="personPicture">Date of birth</label>
                                        <input type="file" name="personPicture" placeholder="Picture ..." class="form-first-name form-control" id="form-first-name">
                                    </div>
                                    <input type="submit" value="input" class="btn" />
                                </form>
                            </div>
                        </div>

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
