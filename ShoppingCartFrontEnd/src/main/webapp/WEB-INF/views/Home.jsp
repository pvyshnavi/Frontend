<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>

<h2>welcome to shopping cart</h2>




<table width="100%">
				<tr>
					<c:choose>
						<c:when test="${empty loggedInUser}">
							<td align="left">Existing user<a href="loginHere"> Login
									here</a></td>
							<td align="center">New user<a href="registerHere">
									Register here</a></td>
						</c:when>
						<c:when test="${not empty loggedInUser}">
							<td>Welcome ${loggedInUser},</td>
							<td align="right"><a href="logout"> logout</a></td>
						</c:when>

					</c:choose>
				</tr>
				<tr>
					<c:if test="${loggedOut==true}">
						<td>${logoutMessage}</td>
					</c:if>
				</tr>
				</table>
				
				<div id="RegisterHere">
				<c:if test="${isUserClickedRegisterHere==true}">
					<%@ include file="/WEB-INF/views/Registration.jsp"%>
					
				</c:if>
			</div>

			<div id="LoginHere">
				<c:if test="${isUserClickedLoginHere==true || invalidCredentials==true}">
				  <div id = "error">  ${errorMessage} </div>
					<%@ include file="/WEB-INF/views/Login.jsp"%>

				</c:if>
				
				<div id="AdminHome">

				<c:if test="${isAdmin==true}">

					<%@ include file="/WEB-INF/views/AdminHome.jsp"%>

				</c:if>
					<div id="categories">
			
			<c:if test="${isAdminClickedCategories==true}">
				
				<%@ include file="/WEB-INF/views/AdminHome.jsp"%>
				<%@ include file="/WEB-INF/views/Category.jsp"%>
			
			</c:if>
		</div>
		
		<div id="product">
					<c:if test="${isAdminClickedProducts==true}">
						<%@ include file="/WEB-INF/views/AdminHome.jsp"%>
						<%@ include file="/WEB-INF/views/Product.jsp"%>
					</c:if>
				</div>

				<div id="supplier">
					<c:if test="${isAdminClickedSuppliers==true}">
						<%@ include file="/WEB-INF/views/AdminHome.jsp"%>
						<%@ include file="/WEB-INF/views/Supplier.jsp"%>
					</c:if>
				</div>

			</div>

				
				
				
					
			
				<div id="welcomemsg">
				<c:if test="${welcometrue==true}">
					${welcome}
					
				</c:if>
			</div>
				

</body>
</html>