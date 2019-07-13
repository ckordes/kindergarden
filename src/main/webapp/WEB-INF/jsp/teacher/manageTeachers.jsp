<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 30.06.19
  Time: 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
    <title>Manage Teachers</title>
</head>
<body class="container">

<%@include file="../header.jsp" %>
<div class="general">
    <div>
        <h4>Create a Teacher</h4>
        <a href="addTeacher">Create Teacher</a><br/>
    </div>

    <div>
        <h4>Teachers List</h4><br/>
        <table>
            <c:forEach items="${allTeachers}" var="teacher">
                <tr class="backColor">
                    <td>
                        <a href="editteacher/${teacher.id}">Edit teacher: ${teacher.person.fullName}</a>
                    </td>
                    <td>
                        <a href="deleteTeacher/${teacher.id}">Delete teacher</a><br/>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="../footer.jsp" %>

</body>
</html>
