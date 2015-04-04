<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1>Weather Underground Web Application</h1>
<h3>${message}</h3>
<c:if test="${!empty weather}">
    <h3>City: ${weather.city}</h3>
    <h3>State: ${weather.state}</h3>
    <h3>Temperature: ${weather.temperatureInFarenheit} F</h3>
</c:if>
<form method="post" action="">
    Zip Code
    <input type="text" name="zipCode" />
    <input type="submit" value="Submit" />
</form>
</body>
</html>