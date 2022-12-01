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

<c:set var="formAction" value="employee/add" />
<c:set var="buttonCaption" value="'add'" />

<c:if test="${employee.id!=0}">
    <c:set var="formAction" value="${pageContext.request.contextPath}/employee/update" />
    <c:set var="buttonCaption" value="'save'" />
</c:if>

<form:form action="${formAction}" modelAttribute="employee">
    first_name <form:input path="firstName"/>
    last_name <form:input path="lastName"/>
    <form:hidden path="id"/>
    <input type="submit" value=${buttonCaption}>
</form:form>


<h3>Employees List</h3>
<c:if test="${!empty employees}">
    <table class="tg">
        <tr>
            <th>ID</th>
            <th>first_name</th>
            <th>last_name</th>

        </tr>
        <c:forEach items="${employees}" var="person">
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
