<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 05.07.19
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome in kindergarden</title>
</head>
<body>
<%@include file="header.jsp"%>


<section>
    <h3>General Messages</h3>
    <c:forEach items="${generalInfo}" var="info">
        ${info.message}<br />
        ${info.created}<br />
        <br />
    </c:forEach>
</section>
</body>
</html>
