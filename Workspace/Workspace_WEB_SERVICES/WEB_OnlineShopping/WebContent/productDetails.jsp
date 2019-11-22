<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Book Store Template, Free CSS Template, TemplateMo.com</title>
<meta name="keywords"
	content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML, TemplateMo.com" />
<meta name="description"
	content="Book Store Template, Free CSS Template, Download CSS Website from TemplateMo.com" />
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<!--  Free CSS Templates from www.templatemo.com -->
	<div id="templatemo_container">
		<jsp:include page="menu.jsp" />
		<!-- end of menu -->

		<jsp:include page="header.jsp" />
		<!-- end of header -->

		<div id="templatemo_content">

			<div id="templatemo_content_left">
				<div class="templatemo_content_left_section">
					<h1>Categories</h1>
					<ul>
						<c:forEach items="${categories}" var="category">
							<li><a
								href="ProductController?action=getAllProductsOfCategory&category_id=${category.id}">${category.code}</a></li>
						</c:forEach>
					</ul>
				</div>
				<div class="templatemo_content_left_section">
					<h1>Bestsellers</h1>
					<ul>
						<li><a href="#">Vestibulum ullamcorper</a></li>
						<li><a href="#">Maece nas metus</a></li>
						<li><a href="#">In sed risus ac feli</a></li>
						<li><a href="#">Praesent mattis varius</a></li>
						<li><a href="#">Maece nas metus</a></li>
						<li><a href="#">In sed risus ac feli</a></li>
						<li><a href="http://www.flashmo.com" target="_parent">Flash
								Templates</a></li>
						<li><a href="http://www.templatemo.com" target="_parent">CSS
								Templates</a></li>
						<li><a href="http://www.webdesignmo.com" target="_parent">Web
								Design</a></li>
						<li><a href="http://www.photovaco.com" target="_parent">Free
								Photos</a></li>
					</ul>
				</div>

				<div class="templatemo_content_left_section">
					<a href="http://validator.w3.org/check?uri=referer"><img
						style="border: 0; width: 88px; height: 31px"
						src="http://www.w3.org/Icons/valid-xhtml10"
						alt="Valid XHTML 1.0 Transitional" width="88" height="31"
						vspace="8" border="0" /></a> <a
						href="http://jigsaw.w3.org/css-validator/check/referer"><img
						style="border: 0; width: 88px; height: 31px"
						src="http://jigsaw.w3.org/css-validator/images/vcss-blue"
						alt="Valid CSS!" vspace="8" border="0" /></a>
				</div>
			</div>
			<!-- end of content left -->

			<div id="templatemo_content_right">

				<h1>
					${product.name } <span>(by author name)</span>
				</h1>
				<div class="image_panel">
					<img src="images/templatemo_image_02.jpg" alt="CSS Template"
						width="100" height="150" />
				</div>
				<h2>$${product.price}</h2>
				<ul>
					<li>Categories: (<c:forEach items="${product.categories}" var="category" varStatus="loop"><a href="ProductController?action=getAllProductsOfCategory&category_id=${category.id}">${category.code}</a>${!loop.last ? ', ' : ''}</c:forEach>)</li>
					<li>Manufactured on: <b><fmt:formatDate value="${product.manufactureDate}" pattern="dd MMM yyyy" /></b></li>
				</ul>

				<p>${product.description }</p>

				<div class="cleaner_with_height">&nbsp;</div>

				<a href="index.html"><img src="images/templatemo_ads.jpg"
					alt="css template ad" /></a>

			</div>
			<!-- end of content right -->

			<div class="cleaner_with_height">&nbsp;</div>
		</div>
		<!-- end of content -->

		<div id="templatemo_footer">
			<a href="index.html">Home</a> | <a href="index.html">Search</a> | <a
				href="index.html">Books</a> | <a href="#">New Releases</a> | <a
				href="#">FAQs</a> | <a href="#">Contact Us</a><br /> Copyright ©
			2048 <a href="#"><strong>Your Company Name</strong></a> | <a
				href="http://www.iwebsitetemplate.com" target="_parent">Website
				Templates</a> by <a href="http://www.templatemo.com" target="_parent">Free
				CSS Templates</a>
		</div>
		<!-- end of footer -->
		<!--  Free CSS Template www.templatemo.com -->
	</div>
	<!-- end of container -->
	<div align=center>
		This template downloaded form <a
			href='http://all-free-download.com/free-website-templates/'>free
			website templates</a>
	</div>
</body>
</html>