<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 30.06.19
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Parent</title>
</head>
<body>

<%@include file="../header.jsp"%>

<div>

    <form:form method="post" modelAttribute="parent">
        First Name: <form:input path="person.firstName"/><br/>
        Second Name: <form:input path="person.secondName"/><br/>
        Last Name: <form:input path="person.lastName"/><br/>
        Id Number: <form:input path="person.idNumber"/><br/>
        PESEL: <form:input path="person.pesel"/><br/>
        E-mail: <form:input path="person.email"/><br/>
        Password: <form:hidden path="person.password"/><br/>
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

<%@include file="../footer.jsp"%>

</body>
</html>
