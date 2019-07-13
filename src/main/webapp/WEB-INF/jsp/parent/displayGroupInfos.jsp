<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 02.07.19
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
    <title>Display Group Infos</title>
</head>
<body class="container">

<%@include file="../header.jsp" %>
<div>
    <h4>Group Info List</h4>
    <table>
        <c:forEach items="${group.groupInfoList}" var="info">
            <tr>
                <td>
                    Message: ${info.message}<br/>
                    Created: ${info.created}
                </td>
            </tr>
        </c:forEach>

    </table>
    <br/>
</div>

<%@include file="../footer.jsp" %>

</body>
</html>
