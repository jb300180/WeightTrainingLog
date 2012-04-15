
<%@ page import="de.bayer.wtl.Training" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'training.label', default: 'Training')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-training" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<%--		<div class="nav" role="navigation">--%>
<%--			<ul>--%>
<%--				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>--%>
<%--				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>--%>
<%--			</ul>--%>
<%--		</div>--%>
		<div id="list-training" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="date" title="${message(code: 'training.date.label', default: 'Date')}" />
					
						<th><g:message code="training.trainingType.label" default="Training Type" /></th>
					
						<th><g:message code="training.gym.label" default="Gym" /></th>
					
						<g:sortableColumn property="rating" title="${message(code: 'training.rating.label', default: 'Rating')}" />
					
						<th><g:message code="training.user.label" default="User" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${trainingInstanceList}" status="i" var="trainingInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${trainingInstance.id}">${fieldValue(bean: trainingInstance, field: "date")}</g:link></td>
					
						<td>${fieldValue(bean: trainingInstance, field: "trainingType")}</td>
					
						<td>${fieldValue(bean: trainingInstance, field: "gym")}</td>
					
						<td>${fieldValue(bean: trainingInstance, field: "rating")}</td>
					
						<td>${fieldValue(bean: trainingInstance, field: "user")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${trainingInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
