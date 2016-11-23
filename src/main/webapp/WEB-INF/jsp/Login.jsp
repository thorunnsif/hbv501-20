<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
        <title>Lyfjabox - Login</title>

        <link rel="stylesheet" type="text/css" href="<spring:url value="css/lyfjabox.css"/>"/>
    </head>
    <body>
        <div id="outerbox">
            <h4>Lyfjabox</h4>
            <h1>Login</h1>

            <%--Note that the `commandName` given here HAS TO MATCH the name of the attribute--%>
            <%--that is added to the model that is passed to the view.--%>
            <%--See UserDataController, method UserDataViewGet(), and find where this attribute is added to the model.--%>

            <p style= "font-size: large; color: red">${message}</p>
            <div class="login">
            <sf:form method="POST" commandName="loginData" action="/login">
                <h3>Here you can log in using your credentials</h3>
                <sf:input id="username" name="username" path="" placeholder="Username" /><br>
                <sf:password id="password" name="password" path="" placeholder="Password"/><br>
                <p class="remember_me">
                    <label>
                        <input type="checkbox" name="remember_me" id="remember_me">
                        Remember me on this computer
                    </label>
                </p>
                <input class="loginbutton" type="submit" value="Login" href="Home.jsp"/>

                <a href="Index.jsp" class="cancelbutton">Cancel</a>

            </sf:form>
                </div>
        </div>
    </body>

    <footer>Class HBV501G - Group 20, University of Iceland, Fall 2016</footer>
</html>
