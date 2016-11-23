<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

    <head>
        <title>Lyfjabox</title>

        <link rel="stylesheet" type="text/css" href="<spring:url value="css/lyfjabox.css"/>"/>
    </head>
    <body>
    <div id="outerbox">
    <h4>Lyfjabox</h4>
            <p>Here you can easily keep all your information on your medication history and usage in one place</p>
            <ul>
                <li><a href="/login">Click here to sign in</a></li>
            </ul>
            <ul>
                <li><a href="/register">Click here to register</a></li>
            </ul>
        </div>
    </body>
    <footer>Class HBV501G - Group 20, University of Iceland, Fall 2016</footer>
</html>
