<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body background="<c:url value="/resources/images/bg.jpg/" />"> 

<div class="login">
		<div class="main-agileits">
				<div class="form-w3agile form1">
						
						
						
						<form:form  method="post" modelAttribute="userDetails">
						<table align="center">
			<tr>
			
				<td>
						
							${user.id}
					</td></tr>		
								<br />
								<tr>
			
				<td>
							${user.name}
						</td></tr>	
							<br/><tr>
			
				<td>
							${user.password}	
							</td></tr>
							<br /><tr>
			
				<td>
							${user.mail}
							</td></tr>	 
						    <br /><tr>
			
				<td>
						    ${user.contact}		
							</td></tr>
							<br /><tr>
			
				<td>
							${user.address}
							</td></tr>
							<br />
							<tr>
			
				<td>
							<button name="_eventId_edit" type="submit" class="btn btn-default">Edit</button><br/>
							<button name="_eventId_submit" type="submit" class="btn btn-default">Confirm Details</button>
							</td></tr></table>
						</form:form>
					</div>
					</div>
				
			</div>
		</div>


</body>
</html>