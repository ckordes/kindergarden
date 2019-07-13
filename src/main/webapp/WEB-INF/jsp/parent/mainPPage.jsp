<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 30.06.19
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
    <title>Parent Page</title>
</head>
<body class="container">

<%@include file="../header.jsp" %>

<h4>List of children</h4>
<c:forEach items="${childList}" var="child">
    <a href="../child/displayChild/${child.id}">${child.fullName}</a><br/>
</c:forEach>

<h4>List of Groups</h4>
<c:forEach items="${groupList}" var="group">
    <a href="groupInfo/${group.id}">${group.name}</a><br/>
</c:forEach><br/>

<%@include file="../footer.jsp" %>

</body>
</html>
