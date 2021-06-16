<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="<c:url value="/resources/js/myjs.js"/>"></script>
</head>
<body>
<form action="Display">
<label for="cars">Choose a car:</label>

<select name="cars" id="cars">
  <option value="Innova">Innova</option>
  <option value="Jeep">Jeep</option>
 
</select>
<input type="submit" value="submit">
</form>
</body>
</html>