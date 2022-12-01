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


<c:set var="formAction" value="position/add" />
<c:set var="buttonCaption" value="'add'" />
id = ${entity.id}
<c:if test="${entity.id!=0}">
    id!=0
    <c:set var="formAction" value="${pageContext.request.contextPath}/position/update" />
    <c:set var="buttonCaption" value="'save'" />
</c:if>



    <form:form action="${formAction}" modelAttribute="entity">
        position name <form:input path="name"/>
        <form:hidden path="id"/>
        <input type="submit" value=${buttonCaption}>
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
