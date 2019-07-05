<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 05.07.19
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change Mail or Password</title>
</head>
<body>
<%@include file="../header.jsp"%>

<form:form method="post" modelAttribute="person">
    <form:hidden path="id"/>
    <form:hidden path="pesel"/>
    <form:hidden path="idNumber"/>
    <form:hidden path="fullName"/>
    <form:hidden path="lastName"/>
    <form:hidden path="secondName"/>
    <form:hidden path="firstName"/>

    <form:hidden path="homeAddress.id"/>
    <form:hidden path="homeAddress.voievodyship"/>
    <form:hidden path="homeAddress.city"/>
    <form:hidden path="homeAddress.zipCode"/>
    <form:hidden path="homeAddress.numberFlat"/>
    <form:hidden path="homeAddress.numberBuilding"/>
    <form:hidden path="homeAddress.street"/>

    <form:hidden path="workAddress.id"/>
    <form:hidden path="workAddress.voievodyship"/>
    <form:hidden path="workAddress.city"/>
    <form:hidden path="workAddress.zipCode"/>
    <form:hidden path="workAddress.numberFlat"/>
    <form:hidden path="workAddress.numberBuilding"/>
    <form:hidden path="workAddress.street"/>

    E-mail: <form:input path="email"/><br />
    Password: <form:input path="password"/><br />
    <input type="submit" value="Save">
</form:form>

<%@include file="../footer.jsp"%>

</body>
</html>
