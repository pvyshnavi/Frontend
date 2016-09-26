    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>

</head>
<body>


<h2>Please fill the details</h2>
	
	
   <form action="here/register" method="post" commandName="userDetails">
<table>

    <tr>
    <td>Id</td>
    <td>:<input type="text" name="id" placeholder="Id"    
class="input_Id"></td>
</tr>

   <tr>
    <td>Name</td>
    <td>:<input type="text" name="name" placeholder="Name"    
class="input_Name"></td>
</tr>
<tr>
    <td>Password</td>
    <td>:<input type="password" name="password" placeholder="Password"    
class="input_Password"></td>
</tr>
<tr>
    <td>Mail</td>
    <td>:<input type="text" name="mail" placeholder="Mail" 
  class="input_Mail"></td>
</tr>
<tr>
    <td>Contact</td>
    <td>:<input type="number" name="contact" placeholder="Contact" 
 class="input_Contact"></td>
</tr>
<tr>
    <td>Address</td>
    <td>:<input type="text" name="address" placeholder="Address" 
 class="input_Address"></td>
</tr>

<tr>
    <td></td>
    <td></td>
</tr>
 </table>
 <input type="submit" value="sumbit"/>
 
   

	

</body>

</html>