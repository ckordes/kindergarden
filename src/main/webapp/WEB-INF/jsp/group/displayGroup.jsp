<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 29.06.19
  Time: 12:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
    <title>Display Group</title>
</head>
<body class="container">
<%@include file="../header.jsp" %>
<div class="general">
    <h2>${group.name}</h2>
    <div>
        <h4>Manage Group</h4>
        <span class="backColor"> <a
                href="/kindergarden_war_exploded/group/deleteGroup/${group.id}">Delete Group</a></span>
    </div>

    <h4>Children in groups</h4>
    <table>
        <c:forEach items="${group.childList}" var="child">
            <tr class="backColor">
                <td>
                    Child full name: ${child.fullName}, childs PESEL: ${child.person.pesel}

                </td>
                <td>
                    <a href="../../child/displayChild/${child.id}">Display Child Info</a> <br/>
                </td>
            </tr>
        </c:forEach>

    </table>

    <div>
        <h4 class="backColor" style="width: 150px;">Group Messages</h4>
        <div>
            <span class="backColor"><a href="/kindergarden_war_exploded/teacher/addGroupInfo/${group.id}">Add Info For Whole Group</a></span>
        </div>
        <br/>
        <table>
            <c:forEach items="${group.groupInfoList}" var="info">
                <tr class="backColor">
                    <td>
                        Message: ${info.message}<br/>
                        Created: ${info.created}<br/>
                    </td>
                </tr>

            </c:forEach>
        </table>

    </div>
</div>
<%@include file="../footer.jsp" %>

</body>
</html>
