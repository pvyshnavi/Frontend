<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head></head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/css/main.css" rel="stylesheet">
</head>
<body>

<section id="form">
		<!--form-->
		<div class="container">
			<div class="row">

</div>
				<div class="col-sm-4">
					<div class="signup-form">
						<!--sign up form-->
						<h2 style="text-align: center;">RegisterHere</h2>
						
						<form:form modelAttribute="userDetails">
							<form:input path="id" pattern=".{2,7}" title="id should contains 2 to 7 characters" 
								placeholder="ID" />
							
								<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('id')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach><br />
					<br>
							<form:input path="name"  placeholder="Name" 
								 />
								 
								 <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('name')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach><br />
					<br>
							
							<form:input path="password"  pattern=".{2,15}" title="password should contains 2 to 15 characters"
								placeholder="Password"
								 />
							
							<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('password')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach><br />
					<br>
					
					<form:input type="mail"  path="mail" placeholder="Mail" />
							
							<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('mail')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach><br />
					<br>
							
							<form:input type="tel"  path="contact" pattern="^\d{10}$" title="Please enter valid mobile number"
								placeholder="Contact" 
								 />
								 
								 <c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('mobile')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach><br />
					<br>
					
							
							<form:input path="address" placeholder="Address" />
							
							<c:forEach items="${flowRequestContext.messageContext.getMessagesBySource('address')}" var="err">
					  <div><span>${err.text}</span></div>
					</c:forEach><br />
					<br>
									
							<button name="_eventId_submit" type="submit" class="btn btn-default">Signin</button>
						</form:form>
					</div>
					<!--/sign up form-->
				</div>
			</div>
		
</section>

</body>
</html>