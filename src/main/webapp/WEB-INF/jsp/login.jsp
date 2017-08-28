<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp"/>

<div id="page">
	<div id="bg1">
		<div id="bg2">
			<div id="bg3">
				<div id="content">

				
<c:set var="name" value="Гость." />

	<c:choose>
		<c:when test="${access}" >
				
			<c:set var="name" value="Авторизованный пользователь" />
			<c:set var="form" value="false" />
				<br/>
					<form method='post'>
					<input type='hidden' name='logout'>
					<input type='submit' value='logout'>
					</form>
	
	</c:when>
	<c:otherwise>
	
			<c:set var="form" value="true" />
					
	</c:otherwise>	
	</c:choose>
	
	
	
	
	<c:choose>
	<c:when test="${form eq 'true'}">
	
	<form id="loginForm" action="" method="post">

	<div class="field">
		<label>Enter your login:</label>
		<div class="input"><input type="text" name="login" value="${param.login eq 'null'?'':param.login}" ></div>
	</div>

	<div class="field">
	<!--	<a href="#" id="forgot">Forgot your password?</a>-->
	<br/>
	<br/>
		<label>Enter your password:</label>
		<div class="input"><input type="password" name="password"></div>
	</div>

	<div class="submit">
		<br/>
		<br/>
		<button type="submit" name="submit" value="Sign In">Enter</button>
		<!--<label id="remember"><input name="" type="checkbox" value="" /> Remember me</label>-->
	</div>
		<br/>
		<br/>	
			
	</form>

		<form>
			<td> 
			
			<c:if test="${!(validator.loginMessage eq 'null')}">
				<c:forEach var="errorMessage" items="${validator.loginMessage}">	
					Ошибка!<c:out value="${errorMessage}"/>
					<br/>
				</c:forEach>
				</c:if>				

				<c:if test="${not empty validator.passwordMessage}">
				<c:forEach var="errorMessage" items="${validator.passwordMessage}">	
					Ошибка!<c:out value="${errorMessage}"/>
					<br/>
				</c:forEach>
				</c:if>	
			
				<c:if test="${not empty errorPassMessage}">
				<c:out value="${errorPassMessage}"/>
				</c:if>	
			
			</td> 
		</form>

		</c:when>
	</c:choose>

		
	

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

<jsp:include page="footer.jsp"/>




