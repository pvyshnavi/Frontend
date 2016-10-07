<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register/Sign in</title>
</head>
<body>

<h2>Please fill the details</h2>

<form action="Registration" method="post" name="registration" >
<table>

    <tr>
    <td>Id</td>
    <td>:<input type="text" name="id" value="" placeholder="Id"    
class="input_Id"></td>
</tr>

   <tr>
    <td>Name</td>
    <td>:<input type="text" name="name" value="" placeholder="Name"    
class="input_Name"></td>
</tr>
<tr>
    <td>Password</td>
    <td>:<input type="password" name="password" value="" placeholder="Password"    
class="input_Password"></td>
</tr>
<tr>
    <td>Mail</td>
    <td>:<input type="text" name="mail" value="" placeholder="Mail" 
  class="input_Mail"></td>
</tr>
<tr>
    <td>Contact</td>
    <td>:<input type="number" name="contact" value="" placeholder="Contact" 
 class="input_Contact"></td>
</tr>
<tr>
    <td>Address</td>
    <td>:<input type="text" name="address" value="" placeholder="Address" 
 class="input_Address"></td>
</tr>

<tr>
    <td></td>
    <td><input type="submit" value="submit" ></td>
</tr>
 </table>
 </form>	


</body>
</html>