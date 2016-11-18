<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

    <head>
        <title>Lyfjabox</title>

        <link rel="stylesheet" type="text/css" href="<c:url value="../../../resources/static/css/postitnote.css"/>"/>
    </head>
    <body>

    <h1>Lyfjabox - My account</h1>
    <p>Here you can easily keep all your information on your medication history and usage in one place</p>

    <form>
        Search Google:
        <input type="search" name="drugsearch">
        <input type="submit" value="Search">
    </form>

    <p style="font-size: x-large; color: green">You are now logged in as ${loggedInUser}</p>

    </body>
    <footer>Class HBV501G - Group 20, University of Iceland, Fall 2016</footer>
</html>