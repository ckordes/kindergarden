<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: baltazar
  Date: 30.06.19
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Child</title>
</head>
<body>

<div>
    <form:form method="post" modelAttribute="child">
        First Name: <form:input path="person.firstName"/><br/>
        Second Name: <form:input path="person.secondName"/><br/>
        Last Name: <form:input path="person.lastName"/><br/>
        PESEL: <form:input path="person.pesel"/><br/>
        ID Number: <form:input path="person.idNumber"/><br/>
        Start hour: <form:input path="startHour"/><br />
        End hour: <form:input path="endHour"/><br />

            Street: <form:input path="person.homeAddress.street"/><br/>
            Building Number: <form:input path="person.homeAddress.numberBuilding"/><br/>
            Flat Number: <form:input path="person.homeAddress.numberFlat"/><br/>
            Zip Code: <form:input path="person.homeAddress.zipCode"/><br/>
            City: <form:input path="person.homeAddress.city"/><br/>
            Voievodyship: <form:input path="person.homeAddress.voievodyship"/><br/>
        Group:
        <form:select path="groupList" multiple="true" items="${allGroups}" itemValue="id" itemLabel="name"/><br />

        Parents:
<%--        <form:select path="parentList" multiple="true" items="${allParents}" itemLabel="parent.fullName" itemValue="id"/>--%>

                <form:select path="parentList" multiple="true">
                    <c:forEach items="${allParents}" var="parent">
                        <option value="${parent.id}" ${child.parentList.contains(parent) ? 'selected="selected"' : ''}>${parent.person.fullName}</option>
                    </c:forEach>
                </form:select><br />


            Allergies:
            <form:select path="allergieList" items="${allAllergies}" itemLabel="typeOfAllergie" itemValue="id"/><br />

<%--            <form:select path="allergieList" multiple="true">--%>
<%--                <c:forEach items="${allAllergies}" var="allergie">--%>
<%--                    <option value="${allergie.id}" ${child.allergieList.contains(allergie) ? 'selected="selected"' : ''}>${allergie.typeOfAllergie}</option>--%>
<%--                </c:forEach>--%>
<%--            </form:select><br/>--%>


        <input type="submit" value="Save">
    </form:form>
</div>
</body>
</html>
