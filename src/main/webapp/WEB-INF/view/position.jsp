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
<form:form action="position/add" modelAttribute="entity">
     <form:hidden path="id"/>
    position name <form:input path="name"/>

    <%--    Position <form:select path="position">--%>
    <%--    <form:options items="${listPositions}"/>--%>
    <%--</form:select>--%>

    <input type="submit" value="add">


</form:form>
<h3>Positions List</h3>
<c:if test="${!empty entities}">
    <table class="tg">
        <tr>

            <th>name</th>

        </tr>
        <c:forEach items="${entities}" var="entity">
            <tr>
                <td>${entity.id}</td>
                <td>${entity.name}</td>
                <td><a href="<c:url value='/position/edit/${entity.id}' />">Edit </a></td>
                <td><a href="<c:url value='/position/remove/${entity.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
