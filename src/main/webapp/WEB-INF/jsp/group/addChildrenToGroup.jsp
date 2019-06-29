<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 29.06.19
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Children to Group</title>
</head>
<body>

<form:form method="post" modelAttribute="group">
    <form:checkboxes path="childList" items="${group.childList}" itemLabel="fullName" itemValue="id"
                     checked="true"/><br/>
    <input type="submit" value="Save">
</form:form>

</body>
</html>
