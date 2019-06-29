<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Add Teacher</title>
</head>
<body>
<h1>Add Teacher</h1>
<div>

    <form:form method="post" modelAttribute="teacher">
        First Name: <form:input path="${teacher.person.firstName}"/><br />
        Second Name: <form:input path="${teacher.person.secondName}"/><br />
        Last Name: <form:input path="${teacher.person.lastName}"/><br />
        Id Number: <form:input path="${teacher.person.idNumber}"/><br />
        PESEL: <form:input path="${teacher.person.pesel}"/><br />
        E-mail: <form:input path="${teacher.person.email}"/><br />
        Password: <form:input path="${teacher.person.password}"/><br />
<%--        <form:input path="${teacher.person.setAddress()}"/><br />--%>
        <input type="submit" value="Save">
    </form:form>
</div>
</body>
</html>
