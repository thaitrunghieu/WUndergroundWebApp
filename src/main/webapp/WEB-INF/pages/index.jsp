<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
</head>
<body>
<h1>Local Weather Viewer</h1>
<h3>${message}</h3>
<form:form action="" modelAttribute="weather">
    <label for="zipCode">Zip Code:</label>
    <form:input path="zipCode" id="zipCode" />
    <input type="submit" value="Submit" />
</form:form>
</body>
</html>