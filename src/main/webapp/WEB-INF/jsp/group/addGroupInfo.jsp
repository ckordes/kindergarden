<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 02.07.19
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Group Info</title>
</head>
<body>
<%@include file="../header.jsp"%>
<h4>Add Info for Whole Group</h4>
<form:form method="post" modelAttribute="groupInfo">
<%--    <form:hidden path="created"/>--%>
    Message for Group: <form:input path="message"/>
    <form:errors path="message"/>
    <input type="submit" value="Save">
</form:form>
<%@include file="../footer.jsp"%>
</body>
</html>
