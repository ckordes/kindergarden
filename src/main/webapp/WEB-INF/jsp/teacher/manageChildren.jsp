<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 30.06.19
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage Children</title>
</head>
<body>
<div>
    <a href="createChild">Create Child</a>
</div>

<div>
    <h4>List of All Children</h4><br />
    <c:forEach items="${allChildren}" var="child">
        <a href="editchild/${child.id}">Edit ${child.fullName}</a>
        <a href="deleteChild/${child.id}">Delete ${child.fullName}</a><br />
    </c:forEach>
</div>
</body>
</html>
