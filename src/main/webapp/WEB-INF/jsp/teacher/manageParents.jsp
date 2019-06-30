<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 30.06.19
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage Parents</title>
</head>
<body>
<div>
    <h4>Create...</h4>
    <a href="addParent">Add Parent</a><br />
</div>
<div>
    <h4>List of all Parents</h4>
    <c:forEach items="${allParents}" var="parent">
        <a href="editparent/${parent.id}">Edit ${parent.person.fullName}</a>
        <a href="deleteparent/${parent.id}">Delete ${parent.person.fullName}</a><br />
    </c:forEach>
</div>
</body>
</html>
