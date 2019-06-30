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
    <title>Welcome in kindergarden</title>
</head>
<body>
<header>
    <h1>Kindergarden</h1>
</header>



<aside>
    <form:form modelAttribute="loginMode" method="post">
        Email: <form:input path="email"/>
        Password: <form:input path="password"/>
        <input type="submit" value="Login">
    </form:form>
</aside>

<section>
    <h3>General Messages</h3>
    <c:forEach items="${generalInfo}" var="info">
        ${info.message}<br />
        ${info.created}<br />
        <br />
    </c:forEach>
</section>
<footer>
    Public Kindergarden number 4<br />
    Street<br />
    Postal Code<br />
    City<br />
    Telephone number<br />
    <a href="/kindergarden_war_exploded/">Home Page</a>
</footer>
</body>
</html>
