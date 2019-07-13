<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 26.06.19
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/main.css"/>">
    <title>Welcome Teacher</title>
</head>
<body class="container">

<%@include file="../header.jsp" %>
<div class="general">
    <div>
        <h4 class="backColor" style="width: 100px;">Manage...</h4>
        <a href="../group/addgroup" class="backColor">Add or Edit Group</a><br/>
        <a href="manageteachers" class="backColor">Manage Teachers</a><br/>
        <a href="manageparents" class="backColor">Manage Parents</a><br/>
        <a href="../child/managechildren" class="backColor">Manage Children</a><br/>
        <a href="addGeneralInfo" class="backColor">Add General Info</a><br/>

    </div>

    <div>
        <h4>Display related Groups</h4>
        <c:forEach items="${allGroups}" var="group">
            <a href="../group/displayGroup/${group.id}" class="backColor">Group: ${group.name}</a><br/>
        </c:forEach>
    </div>

    <h4 class="backColor" style="width: 290px">Informations for Teacher</h4>
    <table>
        <c:forEach items="${allInfoForTeacher}" var="infoForTeacher">
            <tr>
                <td>
                    Message: ${infoForTeacher.message}<br/>
                    Created: ${infoForTeacher.created}<br/>
                </td>
            </tr>

            <br/>
        </c:forEach>
    </table>

    <br/>
</div>
<%@include file="../footer.jsp" %>

</body>
</html>
