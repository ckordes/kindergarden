<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 25.06.19
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
    <title>Welcome in kindergarden</title>
</head>
<body class="container">
<div class="main">
    <h2>Kindergarden</h2>

    <form:form modelAttribute="loginMode" method="post">
        Email: <form:input path="email"/>
        <form:errors path="email"/><br/>
        Password: <form:input path="password"/>
        <form:errors path="password"/><br/>

        <input type="submit" value="Login">

    </form:form>
</div>

<div class="general">
    <h3>General Messages</h3>
    <table class="table">

        <c:forEach items="${generalInfo}" var="info">
            <tr>
                <td>
                    Message: ${info.message}<br/>
                    Created: ${info.created}<br/>
                    <br/>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>

<%@include file="footer.jsp" %>
</body>
</html>
