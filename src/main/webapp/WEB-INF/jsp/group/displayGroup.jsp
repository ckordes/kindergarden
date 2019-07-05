<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 29.06.19
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display Group</title>
</head>
<body>
<%@include file="../header.jsp"%>
<div>
    <h5>Children in groups</h5>
<c:forEach items="${group.childList}" var="child">
   Child full name: ${child.fullName}, childs PESEL: ${child.person.pesel} <a href="../../parent/displayChild/${child.id}">Display Child Info</a> <br/>
</c:forEach>
</div>
<div>
    <a href="/kindergarden_war_exploded/group/deleteGroup/${group.id}">Delete Group</a>
</div>
<div>
<a href="/kindergarden_war_exploded/teacher/addGroupInfo/${group.id}">Add Info For Whole Group</a>
</div>
<div>
    <h5>Group Messages</h5>
    <c:forEach items="${group.groupInfoList}" var="info">
        Message: ${info.message}<br/>
        Created: ${info.created}<br/>
    </c:forEach>
</div>

<%@include file="../footer.jsp"%>

</body>
</html>
