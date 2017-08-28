<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@page import="inetShop.repository.*,inetShop.App.domain.*, java.io.*, java.sql.*, java.util.*, javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<jsp:include page="header.jsp"/>

<div id="page">
	<div id="bg1">
		<div id="bg2">
			<div id="bg3">
				<div id="content">


<br/>
<!--<form action="products.htm" method='post'>
<input type='submit' name='products' value='Показать все товары'/>-->


<c:forEach items="${products}" var="product" >

<c:set var="id" value="${product.id}"/>

<table border='1'>
<tr>
	<td>
		Код товара: <p class="artikul">${id}</p>
	</td>
	<td>
		<p class="product_name">${product.name}</p>
	</td>
</tr>
<tr>
	<td> 
		<a href="${product.image}"><img src="${product.image}" width="100" height="100"alt="" /></a>
	</td>
	<td>
		<p class="product_description">${product.description}</p>
	</td>
</tr>
<tr>
	<td>
		<p class="product_price">${product.price}</p>
	</td>
	<td>
<!--<div id=${id}></div>-->
<!--<form action="cart.htm" method='post' value='toCart'>-->
		<input type='button' class="addtocart" value='Купить'/>
<!--</form>-->
	</td>
</tr>

</table>

</c:forEach>


<br/>
<!--</form>-->

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


<script type="text/javascript">

$(function () {
  //  	$('.addtocart').on("click", sendProductToCart(getProductJson($(this))));

  $('.addtocart').each(function () {

$(this).click(
            function (e) {
                e.preventDefault();
                sendProductToCart(getProductJson($(this)));
            });  
	});
  
});		
		
		function sendProductToCart(productJson) {
					$.ajax({  
						url: '/InetShop/cart.htm',
                        type: "POST",
                        data: {product: productJson},
                        success: function (data) {
							alert("Product added to cart");
						}
					});
		}
		
					
		function getProductJson(element){
					
					
					    var product = new Object();
						//product.id = $("#id").find('.product').text();
						//product.id =$(this).parent().parent().children(".artikul").text(); 
						//product.id =$(element).find(".artikul").text();
						//product.id = $("input[name=artikul]");
						//product.name = $(element).find('.addtocart .product .productName').text();
						//product.name = $(this).attr("product_name");
						product.id = $(element).parent().parent().parent().find('.artikul').text();
						product.name = $(element).parent().parent().parent().find('.product_name').text();
						product.price = $(element).parent().parent().find('.product_price').text();
						//product.price = $(element).find('.product_price').text();
					console.log(JSON.stringify(product));
					return JSON.stringify(product);
										
				}
		

	



	
</script>


<jsp:include page="footer.jsp"/>
