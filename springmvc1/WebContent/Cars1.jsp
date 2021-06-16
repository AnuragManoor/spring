<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    background-color: lightgreen;
    align: center;
}

</style>
</head>
<body>
<form action="show">
<label for="sedans">Choose a car type:</label>

<select name="sedans" id="sedans">
  <option value="Sedan">Sedan</option>
  <option value="XUV">XUV</option>
  
</select>
<input type="submit" value="submit">
</form>
</body>
</html>