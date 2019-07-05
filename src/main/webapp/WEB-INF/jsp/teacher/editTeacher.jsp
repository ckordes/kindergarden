<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 30.06.19
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Teacher</title>
</head>
<body>

<%@include file="../header.jsp"%>

<form:form modelAttribute="teacher" method="post">
    First Name: <form:input path="person.firstName"/><br />
    Second Name: <form:input path="person.secondName"/><br />
    Last Name: <form:input path="person.lastName"/><br />
    Id Number: <form:input path="person.idNumber"/><br />
    PESEL: <form:input path="person.pesel"/><br />
    E-mail: <form:input path="person.email"/><br />
    Password: <form:input path="person.password"/><br />
<%--    <form:hidden path="person.homeAddress"/>--%>
<%--    <form:hidden path="person.workAddress"/>--%>

    <h4>Home Address</h4>

        Street: <form:input path="person.homeAddress.street"/><br />
        Building number: <form:input path="person.homeAddress.numberBuilding"/><br />
        Flat number:  <form:input path="person.homeAddress.numberFlat"/><br />
        Zip Code:  <form:input path="person.homeAddress.zipCode"/><br />
        City: <form:input path="person.homeAddress.city"/><br />
        Voievodyship: <form:input path="person.homeAddress.voievodyship"/><br />

    <h4>Work Address</h4>
    Street: <form:input path="person.workAddress.street"/><br />
    Building number: <form:input path="person.workAddress.numberBuilding"/><br />
    Flat number:  <form:input path="person.workAddress.numberFlat"/><br />
    Zip Code:  <form:input path="person.workAddress.zipCode"/><br />
    City: <form:input path="person.workAddress.city"/><br />
    Voievodyship: <form:input path="person.workAddress.voievodyship"/><br />


<%--        Street: <input type="text" name="streetH" value="${address.street}"><br />--%>
<%--        Building number: <input type="text" name="buildingH" value="${address.numberBuilding}"><br />--%>
<%--        Flat number: <input type="text" name="flatH" value="${address.numberFlat}"><br />--%>
<%--        Zip Code: <input type="text" name="zipH" value="${address.zipCode}"><br />--%>
<%--        City: <input type="text" name="cityH" value="${address.city}"><br />--%>
<%--        Voievodyship: <input type="text" name="voievodyshipH" value="${address.voievodyship}"><br />--%>

<%--    <h4>Work Address</h4>--%>
<%--        Street: <input type="text" name="streetW"><br />--%>
<%--        Building number: <input type="text" name="buildingW"><br />--%>
<%--        Flat number: <input type="text" name="flatW"><br />--%>
<%--        Zip Code: <input type="text" name="zipW"><br />--%>
<%--        City: <input type="text" name="cityW"><br />--%>
<%--        Voievodyship: <input type="text" name="voievodyshipW"><br />--%>

    <input type="submit" value="Save">
</form:form>

<%@include file="../footer.jsp"%>

</body>
</html>
