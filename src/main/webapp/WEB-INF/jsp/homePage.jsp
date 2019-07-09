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
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
    <title>Welcome in kindergarden</title>
</head>
<body class="container">
<%@include file="header.jsp"%>

<div class="general">
    <h3>General Messages</h3>
    <table class="table">
    <c:forEach items="${generalInfo}" var="info">
        <tr style="background: aquamarine">
            <td>
        Message: ${info.message}<br />
        Created: ${info.created}<br />
        <br />
            <br/>
            </td>
    </c:forEach>
    </table>
</div>

<%@include file="footer.jsp"%>

</body>
</html>
