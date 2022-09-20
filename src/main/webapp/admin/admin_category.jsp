<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>Cars</title>
		<meta charset="utf-8">
		<meta name = "format-detection" content = "telephone=no" />
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
		<link rel="icon" href="images/favicon.ico">
		<link rel="shortcut icon" href="images/favicon.ico" />
		<link rel="stylesheet" href="css/touchTouch.css">
		<link rel="stylesheet" href="css/style.css">
		<script src="js/jquery.js"></script>
		<script src="js/jquery-migrate-1.2.1.js"></script>
		<script src="js/script.js"></script>
		<script src="js/superfish.js"></script>
		<script src="js/jquery.ui.totop.js"></script>
		<script src="js/jquery.equalheights.js"></script>
		<script src="js/jquery.mobilemenu.js"></script>
		<script src="js/jquery.easing.1.3.js"></script>
		<script src="js/touchTouch.jquery.js"></script>
		<script>
			$(document).ready(function(){
				$().UItoTop({ easingType: 'easeOutQuart' });
				$('.gallery a.gal').touchTouch();
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
				<div class="menu_block ">
					<div class="container_12">
						<div class="grid_12">
							<nav class="horizontal-nav full-width horizontalNav-notprocessed">
								<ul class="sf-menu">
									<li><a href="admin_dashboard.jsp">Home</a></li>
									<li><a href="admin_drivers.jsp">Drivers</a></li>
									<li ><a href="admin_drivers.jsp">Vehicle</a></li>
									<li class="current"><a href="admin_vehicles.jsp">Category</a></li>
									<li><a href="admin_bookingHistory.jsp">Booking History</a></li>
								

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
			<div class="content"><div class="ic">More Website Templates @ TemplateMonster.com - April 07, 2014!</div>
				
				<!-- ------- -->
					
					
					<%-- <p style="color:red;">${deleteMessage}</p>
	<p style="color:red;">${message}</p> --%>
	<br/>
	<div class="container">
		<form class="d-flex" action="category">
			        <input class="form-control me-2" type="search" name="categoryId" placeholder="Category Code" aria-label="Search">
			        <button class="btn btn-outline-light" type="submit">Search</button>
			      </form>
			      
			      <br>
		<table class="table table-striped">
		  <thead>
		    <tr class="table-dark">
		      <th scope="col">Category Code</th>
		      <th scope="col">Category Name</th> 
		    </tr>
		  </thead>
		  <tbody>
		  	<tag:forEach var="category" items="${categorytList}">
			    <tr>
			      <td>${category.categoryId}</td>
			      <td>${category.categoryName}</td>			  
			      <td>
			      	<form action="category?type=delete" method="post">
			      		<button type="submit" class="btn btn-danger">Delete</button>
			      		<input type="hidden" name="categoryId" value="${category.categoryId}">
			      	</form>				  
			      </td>
			    </tr>
		    </tag:forEach>
		  </tbody>
		</table>
	</div>	
	<!-- ------------------- -->
				
				<div class="container_12">
					<div class="grid_12">
						<h3>Economy</h3>
					</div>
					<div class="clear"></div>
					<div class="gallery">
						<div class="grid_4"><a href="images/big1.jpg" class="gal"><img src="images/page3_img1.jpg" alt=""></a></div>
						<div class="grid_4"><a href="images/big2.jpg" class="gal"><img src="images/page3_img2.jpg" alt=""></a></div>
						<div class="grid_4"><a href="images/big3.jpg" class="gal"><img src="images/page3_img3.jpg" alt=""></a></div>
					</div>
					<div class="grid_12">
						<h3>Standard</h3>
					</div>
					<div class="clear"></div>
					<div class="gallery">
						<div class="grid_4"><a href="images/big4.jpg" class="gal"><img src="images/page3_img4.jpg" alt=""></a></div>
						<div class="grid_4"><a href="images/big5.jpg" class="gal"><img src="images/page3_img5.jpg" alt=""></a></div>
						<div class="grid_4"><a href="images/big6.jpg" class="gal"><img src="images/page3_img6.jpg" alt=""></a></div>
					</div>
					<div class="grid_12">
						<h3>Lux</h3>
					</div>
					<div class="clear"></div>
					<div class="gallery">
						<div class="grid_4"><a href="images/big7.jpg" class="gal"><img src="images/page3_img7.jpg" alt=""></a></div>
						<div class="grid_4"><a href="images/big8.jpg" class="gal"><img src="images/page3_img8.jpg" alt=""></a></div>
						<div class="grid_4"><a href="images/big9.jpg" class="gal"><img src="images/page3_img9.jpg" alt=""></a></div>
					</div>
					<div class="clear"></div>
					
					
					
				</div>
			</div>
		</div>
		 
	
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