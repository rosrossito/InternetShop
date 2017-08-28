<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@page import="inetShop.repository.*,inetShop.validator.*,inetShop.controller.*,inetShop.App.domain.*, java.io.*, java.sql.*, java.util.*, javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="header.jsp"/>

<div id="page">
	<div id="bg1">
		<div id="bg2">
			<div id="bg3">
				<div id="content">


<br/>


<c:forEach items="${cart.products}" var="product" >
	
<table border='1'>
<tr>
	<td>
		Код товара: <p class="artikul">${product.id}</p> 
	</td>
	<td>
		<p class="product_name">${product.name}</p>
	</td>
</tr>
<tr>
	<td>
		<p class="product_price">${product.price}</p>
	</td>
	<td>
		<a href="cart.htm?product_id=${product.id}">Удалить</a>
	</td>
</tr>
</table>




</c:forEach>



<br/>


				</div>
				<div id="sidebar">
					<h2>Товары</h2>
					<ul>
					
						<li><a href="products.htm?category_id=1">Игрушки</a></li>
						<li><a href="products.htm?category_id=2">Книги</a></li>
						<li><a href="products.htm?category_id=3">Музыкальные игрушки</a></li>
						<li><a href="registration.htm">Регистрация</a></li>
						<li><a href="login.htm">Вход</a></li>
						<li><a href="cart.htm">Корзина</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>

<jsp:include page="footer.jsp"/>
