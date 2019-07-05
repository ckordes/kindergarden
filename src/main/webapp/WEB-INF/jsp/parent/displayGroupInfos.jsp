<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 02.07.19
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display Group Infos</title>
</head>
<body>

<%@include file="../header.jsp"%>

<h4>Group Info List</h4>
<c:forEach items="${group.groupInfoList}" var="info">
    ${info.created}, ${info.message}<br />
    <br />
</c:forEach>

<%@include file="../footer.jsp"%>

</body>
</html>
