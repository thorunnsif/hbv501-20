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

    <h3>Login</h3>

    <%--Note that the `commandName` given here HAS TO MATCH the name of the attribute--%>
    <%--that is added to the model that is passed to the view.--%>
    <%--See UserDataController, method UserDataViewGet(), and find where this attribute is added to the model.--%>
    <body>
    <p style= "font-size: large; color: red">${message}</p>

    <sf:form method="POST" commandName="loginData" action="/login">

        <sf:label path="username">Enter your username</sf:label>
        <sf:input id="username" name="username" path="" /><br>
        <sf:label path="username">Please enter your password</sf:label>
        <sf:password id="password" name="password" path="" /><br>

        <input type="submit" value="Login" href="Home.jsp"/>

    </sf:form>

    </body>

    <footer>Class HBV501G - Group 20, University of Iceland, Fall 2016</footer>
</html>
