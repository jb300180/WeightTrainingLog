<%@ page import="de.bayer.wtl.User" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.login.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="edit-user" class="content scaffold-edit" role="main">
			<h1><g:message code="default.login.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${userInstance}">
				<ul class="errors" role="alert">
					<g:eachError bean="${userInstance}" var="error">
					<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
					</g:eachError>
				</ul>
			</g:hasErrors>
			<g:form method="post" >
				<fieldset class="form">
					<g:textField name="userName"/><br/>
					<g:passwordField name="password"/>
				</fieldset>
				<fieldset class="buttons">
					<g:actionSubmit class="login" action="login" value="${message(code: 'default.button.login.label', default: 'Login')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
