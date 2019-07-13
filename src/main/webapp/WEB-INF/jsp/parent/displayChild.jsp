<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 03.07.19
  Time: 22:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
    <title>Display Child</title>
</head>
<body class="container">

<%@include file="../header.jsp" %>
<h2>${child.fullName}</h2>
First Name: ${child.person.firstName}<br/>
Second Name: ${child.person.secondName}<br/>
Last Name: ${child.person.lastName}<br/>
<h5>Parents</h5>
<table>
    <tr>
        <td>First Name</td>
        <td>Last Name</td>
        <td>ID number</td>
        <td>Allowed to pick up</td>
    </tr>
    <c:forEach items="${child.parentList}" var="parent">
        <tr>
            <td>${parent.person.firstName}</td>
            <td>${parent.person.lastName}</td>
            <td>${parent.person.idNumber}</td>
            <td>${parent.allowedToPickUp}</td>
        </tr>
    </c:forEach>
</table>
<br/>
<h4>Add Child Info</h4>
<form:form modelAttribute="childRelatedMessages" method="post">
    Message: <form:input path="message"/>
    <input type="submit" value="Save">
</form:form>

<h4>Display Child Informations</h4>
<table>
    <c:forEach items="${child.childRelatedMessagesList}" var="message">
        <tr>
            <td>
                Message: ${message.message}<br/>
                Created: ${message.created}
            </td>
        </tr>
    </c:forEach>
</table>
<br/>


<%@include file="../footer.jsp" %>

</body>
</html>
