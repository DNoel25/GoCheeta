<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>About</title>
		<meta charset="utf-8">
		<meta name = "format-detection" content = "telephone=no" />
		<link rel="icon" href="images/favicon.ico">
		<link rel="shortcut icon" href="images/favicon.ico" />
		<link rel="stylesheet" href="css/style.css">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
		<script src="js/jquery.js"></script>
		<script src="js/jquery-migrate-1.2.1.js"></script>
		<script src="js/script.js"></script>
		<script src="js/superfish.js"></script>
		<script src="js/jquery.ui.totop.js"></script>
		<script src="js/jquery.equalheights.js"></script>
		<script src="js/jquery.mobilemenu.js"></script>
		<script src="js/jquery.easing.1.3.js"></script>
		<script>
			$(document).ready(function(){
				$().UItoTop({ easingType: 'easeOutQuart' });
			});
		</script>
		<!--[if lt IE 8]>
			<div style=' clear: both; text-align:center; position: relative;'>
				<a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
					<img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
				</a>
			</div>
		<![endif]-->
		<!--[if lt IE 9]>
			<script src="js/html5shiv.js"></script>
			<link rel="stylesheet" media="screen" href="css/ie.css">
		<![endif]-->
	</head>
	<body class="" id="top">
		<div class="main">
<!--==============================header=================================-->
			<header>
				<div class="menu_block">
					<div class="container_12">
						<div class="grid_12">
							<nav class="horizontal-nav full-width horizontalNav-notprocessed">
								<ul class="sf-menu">
									<li><a href="customer_dashboard.jsp">Home</a></li>
									<li ><a href="customer_about.jsp">About</a></li>
									<li><a href="customer_cars.jsp">Cars</a></li>
									<li class="current"> <a href="customer_booking">My Bookings</a>
									<li><a href="customer_services.jsp">Services</a></li>
									<li><a href="customer_services.jsp">Contacts</a></li>
								</ul>
							</nav>
							<div class="clear"></div>
						</div>
						<div class="clear"></div>
					</div>
				</div>
				<div class="container_12">
					<div class="grid_12">
						<h1>
							<a href="index.html">
								<img src="images/logo.png" alt="Your Happy Family">
							</a>
						</h1>
					</div>
				</div>
				<div class="clear"></div>
			</header>
<!--==============================Content=================================-->
			
			<%-- <p style="color:red;">${deleteMessage}</p>
	<p style="color:red;">${message}</p> --%>
	<br/>
	<div class="container">
		<form class="d-flex" action="booking">
			        <input class="form-control me-2" type="search" name="bookingId" placeholder="Booking Code" aria-label="Search">
			        <button class="btn btn-outline-light" type="submit">Search</button>
			      </form>
			      
			      <br>
		<table class="table table-striped">
		  <thead>
		    <tr class="table-dark">
		     
		      <th scope="col">Booking Code </th>
		      <th scope="col">Vehicle</th> 
		      <th scope="col">Source</th>
		      <th scope="col">Destination</th>
		      <th scope="col">Status</th>
		      <th scope="col">Driver Name</th> 
		    </tr>
		  </thead>
		  <tbody>
		  	<tag:forEach var="booking" items="${categorytList}">
			    <tr>
			     
			      <td>${booking.bookingId}</td>
			      <td>${booking.vehicleCategory}</td>	
			      <td>${booking.streetAddress}</td>	
			      <td>${booking.cost}</td>	
			      <td>${booking.bookingStatus}</td>	
			      <td>${booking.driverCNo}</td>	
			      <td>${booking.driverName}</td>			  
			      <td>
			      	<form action="booking?type=feedback method="post">
			      		<button type="submit" class="btn btn-danger">Feedback</button>
			      		<input type="hidden" name="bookingId" value="${booking.bookingId}">
			      	</form>				  
			      </td>
			    </tr>
		    </tag:forEach>
		  </tbody>
		</table>
	</div>
	
			
			</div>
		</div>
		
		<br><br><br><br><br>
<!--==============================footer=================================-->
		<footer>
			<div class="container_12">
				<div class="grid_12">
					<div class="f_phone"><span>Call Us:</span> +94 *** *** ***</div>
					<div class="socials">
						<a href="#" class="fa fa-twitter"></a>
						<a href="#" class="fa fa-facebook"></a>
						<a href="#" class="fa fa-google-plus"></a>
					</div>
					<div class="copy">
						<div class="st1">
						<div class="brand">Go<span class="color1">c</span>eeta </div>
				<!-- <a href="#">Privacy Policy</a> </div> Website designed by <a href="#">Domain Name</a> -->
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</footer>
	</body>
</html>