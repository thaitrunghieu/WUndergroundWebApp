<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>
<h1>Weather Underground Web Application</h1>
<h3>${message}</h3>
<c:if test="${!empty weather && weather.isValidPlace}">
    <h3>${weather.city}, ${weather.state}: ${weather.temperatureInFarenheit} F</h3>
</c:if>
<form:form action="" modelAttribute="weather">
    <label for="zipCode">Zip Code:</label>
    <form:input path="zipCode" id ="zipCode" />
    <form:errors path="zipCode" />

    <input type="submit" value="Submit" />
</form:form>
</body>
</html>