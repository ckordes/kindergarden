<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 26.06.19
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome Teacher</title>
</head>
<body>

<%@include file="../header.jsp"%>
    <h1>Kindergarden</h1>

<div>
    <h4>Create...</h4>
    <a href="../group/addgroup">Add or Edit Group</a><br />
    <a href="manageteachers">Manage Teachers</a><br />
    <a href="manageparents">Manage Parents</a><br />
    <a href="../child/managechildren">Manage Children</a><br />
    <a href="addGeneralInfo">Add General Info</a><br />

</div>

<div>
    <h4>Display related Groups</h4>
    <c:forEach items="${allGroups}" var="group">
        <a href="../group/displayGroup/${group.id}">Group: ${group.name}</a><br />
    </c:forEach>
</div>

<c:forEach items="${allInfoForTeacher}" var="infoForTeacher">
    ${infoForTeacher.message}<br />
    ${infoForTeacher.created}<br />
    <br />
</c:forEach>
<br />

<%@include file="../footer.jsp"%>

</body>
</html>
