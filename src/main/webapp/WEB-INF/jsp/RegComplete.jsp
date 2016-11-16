<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

    <head>
        <title>Lyfjabox</title>
    </head>
    <body>

    <h1>Lyfjabox</h1>
    <p>You have successfully registered as a user for the Lyfjabox</p>
    <form action="/login">
        <%-- Add login path when finished --%>
        <input type="submit" value="Go to login" />
    </form>
    <input type="button" VALUE="Login"/>
    </body>
    <footer>Class HBV501G - Group 20, University of Iceland, Fall 2016</footer>
</html>
