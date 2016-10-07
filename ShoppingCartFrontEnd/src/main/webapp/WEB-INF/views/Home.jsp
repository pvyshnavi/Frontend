<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link href="lo.js" rel"stylesheet" type="text/js"></link>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


<style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
height:20em;
  }
  </style>
 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>

<h2>welcome to YouGoGirl</h2>

<div class="header-middle">
			<!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href=""><img
								src="resources/images/logo.jpg" alt="Bootsshop" /></a>
						</div>
											</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<!--  <ul class="nav navbar-nav">
							
								
								
								<li><a href="Cart"><i class="fa fa-shopping-cart"></i>
										Cart<span class="badge">${cartSize}</span></a></li>
										</ul> -->
										<div id = "myCart">
											<c:if test="${userClickedCartHere==true}">
											<%@ include file="Cart.jsp"%>	
    										</c:if>
    									</div> 
						</div>
					</div>
				</div>
			</div>
			
			<table width="100%">
				<tr>
				
				
				
					<c:choose>
						<c:when test="${empty loggedInUser}">
							<td align="left">Existing user<a href="loginHere"> Login
									here</a></td>
							<td align="center">New user<a href="member.obj">
									Register here</a></td>
						</c:when>
						<c:when test="${not empty loggedInUser}">
							<td>Welcome ${loggedInUser},</td>
							
		<li><a href="myCart">myCart<i class="fa fa-shopping-cart"></i></a></li>
										<!--  Cart<span class="badge">${cartSize}</span></a></li> -->
										
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
				
		<div id="saree">
		<c:if test="${isUserClickedSaree==true }">
			<%@ include file="saree.jsp"%>
		</c:if>
	</div>


		



<div class="container">
<br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
	  <li data-target="#myCarousel" data-slide-to="4"></li>
	  <li data-target="#myCarousel" data-slide-to="5"></li>
	  <li data-target="#myCarousel" data-slide-to="6"></li>
	  
    </ol>

    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="resources/images/1.jpg" alt="dresses" width="460" height="345">
      </div>

      <div class="item">
        <img src="resources/images/2.jpg" alt="dresses" width="460" height="345">
      </div>
    
      <div class="item">
        <img src="resources/images/3.jpg" alt="dresses" width="460" height="345">
      </div>

      <div class="item">
        <img src="resources/images/7.jpg" alt="dresses" width="460" height="345">
      </div>
	  
	  <div class="item">
        <img src="resources/images/5.jpg" alt="dresses" width="460" height="345">
      </div>
	  
	  <div class="item">
        <img src="resources/images/6.jpg" alt="dresses" width="460" height="345">
      </div>
	  
	  <div class="item">
        <img src="resources/images/4.jpg" alt="curtains" width="460" height="345">
      </div>
    </div>
	

    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<br>


				
				
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

				
			
	
				
<%@ include file="Footer.jsp"%>
</body>
</html>