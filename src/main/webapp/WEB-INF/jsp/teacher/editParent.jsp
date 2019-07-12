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
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
    <title>Edit Parent</title>
</head>
<body class="container">

<%@include file="../header.jsp"%>

<div>

    <form:form method="post" modelAttribute="parent">
        <h4>Edit Parent</h4>
        First Name: <form:input path="person.firstName"/><form:errors path="person.firstName"/> <br/>
        Second Name: <form:input path="person.secondName"/><form:errors path="person.secondName"/> <br/>
        Last Name: <form:input path="person.lastName"/><form:errors path="person.lastName"/> <br/>
        Id Number: <form:input path="person.idNumber"/><form:errors path="person.idNumber"/> <br/>
        PESEL: <form:input path="person.pesel"/><form:errors path="person.pesel"/> <br/>
<%--        <form:hidden path="person.email"/>--%>
<%--        <form:hidden path="person.password"/>--%>
        E-mail: <form:input path="person.email"/><form:errors path="person.email"/> <br/>
        Password: <form:hidden path="person.password"/><form:errors path="person.password"/> <br/>
        Children:
        <form:select path="childList" multiple="true">
            <c:forEach items="${allChildren}" var="child">
                <option value="${child.id}" ${parent.childList.contains(child) ? 'selected="selected"' : ''}>${child.fullName}</option>
            </c:forEach>
        </form:select><form:errors path="childList"/> <br />
        Allowed to pick up: <form:checkbox path="allowedToPickUp"/><br />
        Parent/Guardian: <form:checkbox path="guardian" checked="true"/><br />

        <h3>Home Address</h3><br/>
        Street: <form:input path="person.homeAddress.street"/><form:errors path="person.homeAddress.street"/> <br/>
        Building number: <form:input path="person.homeAddress.numberBuilding"/> <form:errors path="person.homeAddress.numberBuilding"/> <br/>
        Flat number: <form:input path="person.homeAddress.numberFlat"/> <form:errors path="person.homeAddress.numberFlat"/> <br/>
        Zip Code: <form:input path="person.homeAddress.zipCode"/><form:errors path="person.homeAddress.zipCode"/> <br/>
        City: <form:input path="person.homeAddress.city"/><form:errors path="person.homeAddress.city"/> <br/>
        Voievodyship: <form:input path="person.homeAddress.voievodyship"/><form:errors path="person.homeAddress.voievodyship"/> <br/>
        <h3>Work Address</h3><br/>
        Work Place Name: <form:input path="companyName"/><form:errors path="companyName"/> <br />
        Street: <form:input path="person.workAddress.street"/><form:errors path="person.workAddress.street"/> <br/>
        Building number: <form:input path="person.workAddress.numberBuilding"/><form:errors path="person.workAddress.numberBuilding"/> <br/>
        Flat number: <form:input path="person.workAddress.numberFlat"/><form:errors path="person.workAddress.numberFlat"/> <br/>
        Zip Code: <form:input path="person.workAddress.zipCode"/><form:errors path="person.workAddress.zipCode"/> <br/>
        City: <form:input path="person.workAddress.city"/><form:errors path="person.workAddress.city"/> <br/>
        Voievodyship: <form:input path="person.workAddress.voievodyship"/><form:errors path="person.workAddress.voievodyship"/> <br/>

        <input type="submit" value="Save">
    </form:form>
</div>

<%@include file="../footer.jsp"%>

</body>
</html>
