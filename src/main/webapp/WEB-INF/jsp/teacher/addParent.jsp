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
    <title>Add Parent</title>
</head>
<body>
<h1>Add Teacher</h1>
<div>

    <form:form method="post" modelAttribute="parent">
        First Name: <form:input path="person.firstName"/><br/>
        Second Name: <form:input path="person.secondName"/><br/>
        Last Name: <form:input path="person.lastName"/><br/>
        Id Number: <form:input path="person.idNumber"/><br/>
        PESEL: <form:input path="person.pesel"/><br/>
        E-mail: <form:input path="person.email"/><br/>
        Password: <form:input path="person.password"/><br/>
        Children:
        <form:select path="childList" multiple="true">
            <c:forEach items="${allChildren}" var="child">
                <option value="${child.id}" ${parent.childList.contains(child) ? 'selected="selected"' : ''}>${child.fullName}</option>
            </c:forEach>
        </form:select><br />
        Allowed to pick up: <form:checkbox path="allowedToPickUp"/><br />
        Parent/Guardian: <form:checkbox path="guardian" checked="true"/><br />

        <h3>Home Address</h3><br/>
        Street: <form:input path="person.homeAddress.street"/><br/>
        Building number: <form:input path="person.homeAddress.numberBuilding"/> <br/>
        Flat number: <form:input path="person.homeAddress.numberFlat"/> <br/>
        Zip Code: <form:input path="person.homeAddress.zipCode"/> <br/>
        City: <form:input path="person.homeAddress.city"/> <br/>
        Voievodyship: <form:input path="person.homeAddress.voievodyship"/> <br/>
        <h3>Work Address</h3><br/>
        Work Place Name: <form:input path="companyName"/><br />
        Street: <form:input path="person.workAddress.street"/><br/>
        Building number: <form:input path="person.workAddress.numberBuilding"/><br/>
        Flat number: <form:input path="person.workAddress.numberFlat"/><br/>
        Zip Code: <form:input path="person.workAddress.zipCode"/><br/>
        City: <form:input path="person.workAddress.city"/><br/>
        Voievodyship: <form:input path="person.workAddress.voievodyship"/><br/>

        <input type="submit" value="Save">
    </form:form>
</div>
</body>
</html>


<%--Street: <form:input path="person.homeAddress.street"/> <input type="text" name="streetH"><br />--%>
<%--Building number: <input type="text" name="buildingH"><br />--%>
<%--Flat number: <input type="text" name="flatH"><br />--%>
<%--Zip Code: <input type="text" name="zipH"><br />--%>
<%--City: <input type="text" name="cityH"><br />--%>
<%--Voievodyship: <input type="text" name="voievodyshipH"><br />--%>
<%--<h3>Work Address</h3><br />--%>
<%--Street: <input type="text" name="streetW"><br />--%>
<%--Building number: <input type="text" name="buildingW"><br />--%>
<%--Flat number: <input type="text" name="flatW"><br />--%>
<%--Zip Code: <input type="text" name="zipW"><br />--%>
<%--City: <input type="text" name="cityW"><br />--%>
<%--Voievodyship: <input type="text" name="voievodyshipW"><br />--%>