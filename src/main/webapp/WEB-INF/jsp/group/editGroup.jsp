<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 29.06.19
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Group</title>
</head>
<body>
<div>
    <form:form method="post" modelAttribute="group">
        Name: <form:input path="name"/><br />
        Description: <form:input path="description"/><br />
        Child List: <form:select path="childList" multiple="true">
            <c:forEach items="${allChildren}" var="child">
                <option value="${child.id}" ${group.childList.contains(child) ? 'selected="selected"' : ''}>${child.fullName}</option>
            </c:forEach>
        </form:select><br />
        Teacher List: <form:select path="teacherList" multiple="true">
            <c:forEach items="${allTeachers}" var="teacher">
                <option value="${teacher.id}" ${group.teacherList.contains(teacher) ? 'selected="selected"' : ''}>${teacher.fullName}</option>
            </c:forEach>
        </form:select><br />
        <input type="submit" value="Save">
    </form:form>
</div>
</body>
</html>
