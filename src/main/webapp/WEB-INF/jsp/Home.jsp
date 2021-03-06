<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
        <title>Lyfjabox</title>

        <link rel="stylesheet" type="text/css" href="<spring:url value="css/lyfjabox.css"/>"/>
    </head>

    <body>
        <div id="outerbox" >
            <a href="#" class="myButton1" style="float: right">Log out</a>
            <h4>Lyfjabox</h4>
            <h1>Lyfjabox - My account</h1>
            <h3><p>You are now logged in as ${loggedInUser.getUsername()}</p></h3>
            <p>Here you can easily keep all your information on your medication history and usage in one place</p>



            <sf:form method="POST" commandName="drug" action="/login">
                <table>
                    <tr>
                        <td> Search for drug:</td>
                            <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
                        <td><sf:input path="name" type="text" placeholder="Search for..." autofocus="autofocus"/></td>
                    </tr>
                </table>

                <input class="myButton2" type="submit" VALUE="Search"/>
            <br>
            <br>

            </sf:form>

            <%--Choose what code to generate based on tests that we implement--%>
            <c:choose>
                <%--If the model has an attribute with the name `postitNotes`--%>
                <c:when test="${not empty drugs}">
                    <%--Create a table for the Postit Notes--%>
                    <table class="searchResults">
                        <tr>
                            <th>Name of drug</th>
                            <th>Dosage</th>
                            <th>Frequency</th>
                            <th>First intake</th>
                            <%--For each postit note, that is in the list that was passed in the model--%>
                            <%--generate a row in the table--%>
                            <%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
                        <c:forEach var="drug" items="${drugs}">
                            <tr>
                                    <%--We can reference attributes of the Entity by just entering the name we gave--%>
                                    <%--it in the singular item var, and then just a dot followed by the attribute name--%>

                                    <%--Create a link based on the name attribute value--%>
                                <td>${drug.name}</td>
                                <td><input type="text" value="" placeholder="mg per intake"></td>
                                <td><input type="text" value="" placeholder="times per day"></td>
                                <td><input type="text" value="" placeholder="DD/MM/YYYY"></td>
                                <td id="tablebuttons"><input class="myButton2" type="button" value="Register"></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:when>

                <%--If all tests are false, then do this--%>
                <c:otherwise>
                    <%--<p>No drugs found</p>--%>
                </c:otherwise>
            </c:choose>

            <h3>You are currently taking:</h3>

            <%--Choose what code to generate based on tests that we implement--%>
            <c:choose>
                <%--If the model has an attribute with the name `postitNotes`--%>
                <c:when test="${not empty drugs}">
                    <%--Create a table for the Postit Notes--%>
                    <table class="currentDrugs">
                        <tr>
                            <th>Name of drug</th>
                            <th>Dosage</th>
                            <th>Frequency</th>
                            <th>First intake</th>
                                <%--For each postit note, that is in the list that was passed in the model--%>
                                <%--generate a row in the table--%>
                                <%--Here we set `postit` as a singular item out of the list `postitNotes`--%>
                        <c:forEach var="drug" items="${drugs}">
                        <tr>
                                <%--We can reference attributes of the Entity by just entering the name we gave--%>
                                <%--it in the singular item var, and then just a dot followed by the attribute name--%>

                                <%--Create a link based on the name attribute value--%>
                            <td>${drug.name}</td>
                            <td><label type="text" value=""/></td>
                            <td><label type="text" value=""/></td>
                            <td><label type="text" value=""/></td>
                            <td id="tablebuttons"><input class="myButton2" type="button" value="Update"></td>
                            <td id="tablebuttons"><input class="myButton2" type="button" value="Delete"></td>
                        </tr>
                        </c:forEach>
                    </table>
                </c:when>

                <%--If all tests are false, then do this--%>
                <c:otherwise>
                    <%--<p>No drugs found</p>--%>
                </c:otherwise>
            </c:choose>


        </div>
    </body>
    <footer>Class HBV501G - Group 20, University of Iceland, Fall 2016</footer>
</html>
