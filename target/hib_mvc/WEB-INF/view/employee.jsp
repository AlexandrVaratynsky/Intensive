<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Employee Page</title>
</head>
<body>
<form:form action="employee/add" modelAttribute="employee">
    Firstname <form:input path="firstName"/>
    Lastname <form:input path="lastName"/>
    <input type="submit" value="OK">


</form:form>
</body>
</html>
