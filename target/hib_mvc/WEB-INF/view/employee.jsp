<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Employee Page</title>
</head>
<body>
<a href="<c:url value='/positions' />">  Positions  </a>
<a href="<c:url value='/employees' />">  Employees  </a>
<a href="<c:url value='/projects' />">  Projects  </a>
<a href="<c:url value='/customers' />">  Customers </a>
<br>
<form:form action="employee/add" modelAttribute="employee">
    Firstname <form:input path="firstName"/>
    Lastname <form:input path="lastName"/>

<%--    Position <form:select path="position">--%>
<%--    <form:options items="${listPositions}"/>--%>
<%--</form:select>--%>

    <input type="submit" value="add">


</form:form>
<h3>Employees List</h3>
<c:if test="${!empty listEmployees}">
    <table class="tg">
        <tr>
            <th>ID</th>
            <th>first_name</th>
            <th>last_name</th>

        </tr>
        <c:forEach items="${listEmployees}" var="person">
            <tr>
                <td>${person.id}</td>
                <td>${person.firstName}</td>
                <td>${person.lastName}</td>
                <td><a href="<c:url value='/employee/edit/${person.id}' />">Edit </a></td>
                <td><a href="<c:url value='/employee/remove/${person.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
