<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
    <title>Add General Info</title>
</head>
<body class="container">

<%@include file="../header.jsp" %>

<h3>Add General Info</h3>
<div>
    <form:form method="post" modelAttribute="generalInfo">
        <form:input path="message"/>
        <form:errors path="message"/>
        <input type="submit" value="Save">
    </form:form>
</div>

<div>
    <h3>General Messages</h3>
    <table>
        <c:forEach items="${allGeneralInfos}" var="info">
            <tr>
                <td>
                   Message: ${info.message}<br/>
                   Created: ${info.created}
                </td>
                <td>
                    <a href="deleteGeneralInfo/${info.id}">Delete General Info</a>
                </td>
            </tr>

        </c:forEach>

    </table>

</div>


<%@include file="../footer.jsp" %>

</body>
</html>
