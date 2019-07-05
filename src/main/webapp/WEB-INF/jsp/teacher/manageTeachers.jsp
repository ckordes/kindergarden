<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 30.06.19
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage Teachers</title>
</head>
<body>

<%@include file="../header.jsp"%>

<div>
    <a href="addTeacher">Create Teacher</a><br />
</div>

<div>
    <h4>Teachers List</h4><br />
    <c:forEach items="${allTeachers}" var="teacher">
        <a href="editteacher/${teacher.id}">Edit teacher: ${teacher.person.fullName}</a>
        <a href="deleteTeacher/${teacher.id}">Delete teacher: ${teacher.person.fullName}</a><br />

    </c:forEach>
</div>

<%@include file="../footer.jsp"%>

</body>
</html>
