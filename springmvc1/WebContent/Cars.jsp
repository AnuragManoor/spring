<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
label {
    position: relative;
    display: inline-block;
}
select {
    display: inline-block;
    padding: 4px 3px 5px 5px;
    width: 150px;
    outline: none;
    color: black;
    border: 1px solid #C8BFC4;
    border-radius: 4px;
    box-shadow: inset 1px 1px 2px #ddd8dc;
    background-color: lightblue;
}

</style>
</head>
<body>


<form action="Display">
<label for="cars">Choose a car:</label>

<select name="cars" id="cars">
  <option value="volvo">Volvo</option>
  <option value="xcent">Xcent</option>
  <option value="mercedes">Mercedes</option>
  <option value="audi">Audi</option>
</select>
<input type="submit" value="submit">
</form>
</body>
</html>