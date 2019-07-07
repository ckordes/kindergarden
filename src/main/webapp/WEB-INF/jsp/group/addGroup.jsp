<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 29.06.19
  Time: 09:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Group</title>
</head>
<body>
<%@include file="../header.jsp"%>
<form:form method="post" modelAttribute="group">
    Group name: <form:input path="name"/>
    <form:errors path="name"/><br/>
    Description: <form:input path="description"/>
    <form:errors path="description"/><br/>
    <input type="submit" value="Save">
</form:form>

<c:forEach items="${allGroups}" var="group">
    ${group.name} <a href="editgroup/${group.id}">Edit Group</a><br />
</c:forEach>
<%@include file="../footer.jsp"%>
</body>
</html>
