<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 30.06.19
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
    <title>Manage Children</title>
</head>
<body class="container">

<%@include file="../header.jsp" %>
<br/>
<div>
    <h4>Create Child</h4>
    <a href="createChild">Create Child</a>
</div>

<div>
    <h4>List of All Children</h4>
    <table>
        <c:forEach items="${allChildren}" var="child">
            <tr>
                <td>
                    <a href="editchild/${child.id}">Edit ${child.fullName}</a>
                </td>
                <td>
                    <a href="deleteChild/${child.id}">Delete Child</a><br/>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<br/>

<%@include file="../footer.jsp" %>

</body>
</html>
