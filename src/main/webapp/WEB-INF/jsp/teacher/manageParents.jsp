<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 30.06.19
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
    <title>Manage Parents</title>
</head>
<body class="container">

<%@include file="../header.jsp" %>

<div>
    <h4>Create...</h4>
    <a href="addParent">Add Parent</a><br/>
</div>
<div>
    <h4>List of all Parents</h4>
    <table>
        <c:forEach items="${allParents}" var="parent">
            <tr>
                <td><a href="editparent/${parent.id}">Edit ${parent.person.fullName}</a></td>
                <td><a href="deleteparent/${parent.id}">Delete ${parent.person.fullName}</a><br/></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
</div>

<%@include file="../footer.jsp" %>

</body>
</html>
