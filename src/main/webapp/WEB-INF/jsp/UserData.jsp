<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
        <title>User registration page</title>

        <%--<link rel="stylesheet" type="text/css" href="<c:url value="../../../resources/static/css/postitnote.css"/>"/>--%>
    </head>
    <body>

    <h1>User Registration</h1>

    <%--Note that the `commandName` given here HAS TO MATCH the name of the attribute--%>
    <%--that is added to the model that is passed to the view.--%>
    <%--See UserDataController, method UserDataViewGet(), and find where this attribute is added to the model.--%>
    <sf:form method="POST" commandName="userData" action="/register">

        <table>
            <tr>
                <td> First Name:</td>
                    <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="firstName" type="text" placeholder="Enter first name"/></td>
            </tr>
            <tr>
                <td>Last name:</td>
                    <%--the `path` attribute matches the `note` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="lastName" type="text" placeholder="Enter last name"/></td>
            </tr>
            <tr>
                <td>Email address:</td>
                    <%--the `path` attribute matches the `note` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="email" type="text" placeholder="Enter your email address"/></td>
            </tr>
            <tr>
                <td>Social security number:</td>
                    <%--the `path` attribute matches the `note` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="social" type="number" placeholder="Enter your SSN"/></td>
            </tr>
            <tr>
                <td>Address:</td>
                    <%--the `path` attribute matches the `note` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="address" type="text" placeholder="Enter your street address"/></td>
            </tr>
            <tr>
                <td>City:</td>
                    <%--the `path` attribute matches the `note` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="city" type="text" placeholder="Enter your city"/></td>
            </tr>
            <tr>
                <td>Zip number:</td>
                    <%--the `path` attribute matches the `note` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="zip" type="number" placeholder="Enter your zip code"/></td>
            </tr>
            <tr>
                <td>Phone number:</td>
                    <%--the `path` attribute matches the `note` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="phoneNo" type="number" placeholder="Enter your phone number"/></td>
            </tr>
            <tr>
                <td>Username:</td>
                    <%--the `path` attribute matches the `note` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="username" type="text" placeholder="Choose your username"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                    <%--the `path` attribute matches the `note` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="password" type="text" placeholder="Choose your password"/></td>
            </tr>
        </table>

        <input type="submit" VALUE="Register"/>
        <input type="reset" VALUE="Reset form"/>

    </sf:form>

    <%--Choose what code to generate based on tests that we implement--%>
    <c:choose>
        <%--If the model has an attribute with the name `postitNotes`--%>
        <c:when test="${not empty userDataList}">
            <%--Create a table for the Postit Notes--%>
            <table class="users">

                <%--For each postit note, that is in the list that was passed in the model--%>
                <%--generate a row in the table--%>
                <%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
                <c:forEach var="register" items="${userDataList}">
                    <tr>
                        <%--We can reference attributes of the Entity by just entering the name we gave--%>
                        <%--it in the singular item var, and then just a dot followed by the attribute name--%>

                        <%--Create a link based on the name attribute value--%>
                        <td>${user_data.firstName}</td>
                        <td>${user_data.lastName}</td>
                        <td>${user_data.phoneNo}</td>
                        <td>${user_data.email}</td>
                        <td><a href="/register/${user_data.username}">${user_data.username}</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>

        <%--If all tests are false, then do this--%>
        <c:otherwise>
            <h3>No users!</h3>
        </c:otherwise>
    </c:choose>

    </body>
    <footer>Class HBV501G - Group 20, University of Iceland, Fall 2016</footer>
</html>
