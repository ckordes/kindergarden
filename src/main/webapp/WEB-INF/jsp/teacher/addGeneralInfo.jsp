<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 05.07.19
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add General Info</title>
</head>
<body>

<%@include file="../header.jsp"%>

<h3>Add General Info</h3>

<form:form method="post" modelAttribute="generalInfo">
    <form:input path="message"/>
    <input type="submit" value="Save">
</form:form>

<%@include file="../footer.jsp"%>

</body>
</html>
