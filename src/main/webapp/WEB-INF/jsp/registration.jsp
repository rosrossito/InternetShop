<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="inetShop.repository.*,inetShop.validator.*,inetShop.controller.*,inetShop.App.domain.*, java.io.*, java.sql.*, java.util.*, javax.servlet.*" %>

<jsp:include page="header.jsp"/>

<div id="page">
	<div id="bg1">
		<div id="bg2">
			<div id="bg3">
				<div id="content">


	
  <div id="main">


	
	<table border='0'>
		
	<form method='post' formAction='authorization'>
		<tr>
		</tr>
		<tr>
			<td> 
				Логин (e-mail)
			</td> 
			<td> 
				<c:choose>
					<c:when test="${!(user.login eq null)}">
						<input type='text' name='login' value="${user.login}"/>
					</c:when>
					<c:otherwise>
						<input type='text' name='login' value=''/>
					</c:otherwise>
				</c:choose>
			</td> 
			<td> 
				
				<c:if test="${!(validator.loginMessage eq 'null')}">
				<c:forEach var="errorMessage" items="${validator.loginMessage}">	
					Ошибка!<c:out value="${errorMessage}"/>
				</c:forEach>
				</c:if>		
			</td> 
		</tr>
		
		
		<tr>
			<td> 
				Пароль
			</td>
			<td> 
				<c:choose>
					<c:when test="${not empty password}">
						<input type='password' name='password' value="${password}"/>
					</c:when>
					<c:otherwise>
						<input type='password' name='password' value=''/>
					</c:otherwise>
				</c:choose>
			</td>
			<td> 
				<c:if test="${not empty validator.passwordMessage}">
				<c:forEach var="errorMessage" items="${validator.passwordMessage}">	
					Ошибка!<c:out value="${errorMessage}"/>
				</c:forEach>
				</c:if>		
			</td>
			
		</tr>
		
		
		<tr>
			<td> 
				Повторите пароль
			</td>
			<td>
				<input type='password' name='retypepsw'/>
			</td>
			<td> 
				<c:if test="${not empty validator.retypepswMessage}">
				<c:forEach var="errorMessage" items="${validator.retypepswMessage}">	
					Ошибка!<c:out value="${errorMessage}"/>
				</c:forEach>
				</c:if>		
			</td>
		</tr>
		
		
		<tr>
			<td width='200' height='30'> 
				Имя
			</td> 
			<td> 
				<c:choose>
					<c:when test="${!(user.name eq null)}">
						<input type='text' name='name' value="${user.name}"/>
					</c:when>
					<c:otherwise>
						<input type='text' name='name' value=''/>
					</c:otherwise>
				</c:choose>
			</td>	
			<td> 
				<c:if test="${not empty validator.nameMessage}">
				<c:forEach var="errorMessage" items="${validator.nameMessage}">	
					Ошибка!<c:out value="${errorMessage}"/>
				</c:forEach>
				</c:if>		
			</td>
		</tr>
		
		
		<tr>
			<td width='200' height='30'> 
				Страна
			</td>
			<td> 			
				<select name='region'>
					<option selected value="Ukraine">Ukraine</option>
					<option value="Germany">Germany</option>
					<option value="Germany">Other country</option>
					<value=${(user.region eq null)?'':user.region}/>
				</select>
			</td>
		</tr>
		
		
		
		<tr>
			<td width='200' height='30'> 
				Обратная связь
			</td>
			<td>
				<textarea cols='20' rows='10' name='feedback'> 
						${feedback}
				</textarea>
			</td>	
			<td> 
				<c:if test="${not empty validator.feedbackMessage}">
				<c:forEach var="errorMessage" items="${validator.feedbackMessage}">	
					Ошибка!<c:out value="${errorMessage}"/>
				</c:forEach>
				</c:if>		
			</td>
		</tr>
		
				
		<tr>
			<td width='200' height='30'> 
				Пол
			</td>
			<td>
				<c:choose>
					<c:when test="${!(gender eq 'null')}">
								<input type='radio' name='gender' value='mail' ${(param.gender eq 'mail')?'checked':'_'}/> mail
								<input type='radio' name='gender' value='femail' ${(param.gender eq 'femail')?'checked':'_'}/> femail				
					</c:when>
					<c:otherwise>
						<input type='radio' name='gender' value='mail' 'checked'/> mail
						<input type='radio' name='gender' value='femail' /> femail				
				
					</c:otherwise>
				</c:choose>
			</td>
			<td> 
				<c:if test="${!(validator.genderMessage eq 'null')}">
				<c:forEach var="errorMessage" items="${validator.genderMessage}">	
					Ошибка!<c:out value="${errorMessage}"/>
				</c:forEach>
				</c:if>		
			</td>
		</tr>
		
		
		
		<tr>
			<td width='200' height='30'> 
				Я согласен с условиями
			</td>
			<td>
				<input type='checkbox' name='agree' ${param.agree eq 'on'?'checked':'_'} />
			</td>
			
			<td> 
				<c:if test="${not empty validator.agreeMessage}">
				<c:forEach var="errorMessage" items="${validator.agreeMessage}">	
					Ошибка!<c:out value="${errorMessage}"/>
				</c:forEach>
				</c:if>		
			</td>
		
		</tr>
				
		
		<tr>
			<td width='200' height='30' align="center">
			<input type='submit' value='Reset' />		
			</td>
			<td width='200' height='30' align="center">
			<input type='submit' name="submit" value='Register' />		
			</td>
		
		</tr>
	</form>
	</table>
	
	
		</div>





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
















