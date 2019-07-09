<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 29.06.19
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
    <title>Add Teacher</title>
</head>
<body class="container">

<%@include file="../header.jsp"%>

<h1>Add Teacher</h1>
<div>

    <form:form method="post" modelAttribute="person">
        First Name: <form:input path="firstName"/><form:errors path="firstName"/> <br />
        Second Name: <form:input path="secondName"/><form:errors path="secondName"/> <br />
        Last Name: <form:input path="lastName"/><form:errors path="lastName"/> <br />
        Id Number: <form:input path="idNumber"/><form:errors path="idNumber"/> <br />
        PESEL: <form:input path="pesel"/><form:errors path="pesel"/> <br />
        E-mail: <form:input path="email"/><form:errors path="email"/> <br />
        Password: <form:input path="password"/><form:errors path="password"/> <br />
        <h3>Home Address</h3><br />
        Street: <input type="text" name="streetH"><br />
        Building number: <input type="text" name="buildingH"><br />
        Flat number: <input type="text" name="flatH"><br />
        Zip Code: <input type="text" name="zipH"><br />
        City: <input type="text" name="cityH"><br />
        Voievodyship: <input type="text" name="voievodyshipH"><br />
        <h3>Work Address</h3><br />
        Street: <input type="text" name="streetW"><br />
        Building number: <input type="text" name="buildingW"><br />
        Flat number: <input type="text" name="flatW"><br />
        Zip Code: <input type="text" name="zipW"><br />
        City: <input type="text" name="cityW"><br />
        Voievodyship: <input type="text" name="voievodyshipW"><br />

        <input type="submit" value="Save">
    </form:form>
</div>

<%@include file="../footer.jsp"%>

</body>
</html>