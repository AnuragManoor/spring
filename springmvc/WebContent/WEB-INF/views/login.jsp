<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>   
body {  
  font-family: Calibri, Helvetica, sans-serif;  
  
}  
button {   
       background-color: #4CAF50;   
       width: 100%;  
          
        padding: 15px;   
        margin: 10px 0px;   
        border: none;   
        cursor: pointer;   
         }   
 form {   
        border: 3px solid #f1f1f1;   
    }   
 input[type=text], input[type=password] {   
        width: 100%;   
        margin: 8px 0;  
        padding: 12px 20px;   
        display: inline-block;   
        border: 2px solid green;   
        box-sizing: border-box;   
    }  
 button:hover {   
        opacity: 0.7;   
    }   
  .cancelbtn {   
        width: auto;   
        padding: 10px 18px;  
        margin: 10px 5px;  
    }   
        
     
 .container {   
        padding: 25px;   
        
    }
     
</style> 
  <script type="text/javascript">
  function validate()
  {
	  var p = document.getElementById('newPassword').value,
      errors = [];
  if (p.length < 8) {
      errors.push("Your password must be at least 8 characters"); 
  }
  if (p.search(/[a-z]/i) < 0) {
      errors.push("Your password must contain at least one letter.");
  }
  if (p.search(/[0-9]/) < 0) {
      errors.push("Your password must contain at least one digit."); 
  }
  if (errors.length > 0) {
      alert(errors.join("\n"));
      return false;
  }
  return true;
  }
  </script>
</head>    
<body bgcolor="blue">
 
    <center> <h1>Login </h1> </center>   
    <form action="Cars" method="post" onSubmit=" return validate()"> 
        <div class="container">   
            <label>Username : </label>   
            <input type="text" placeholder="Enter Username" id="u" name="username" required>  
            <label>Password : </label>   
            <input type="password" placeholder="Enter Password" id="newPassword" name="password" required> 
<input type="submit" value="login">
</div>
</form>

</body>
</html>