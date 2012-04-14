
<%@ page import="de.bayer.wtl.Training" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'training.label', default: 'Training')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-training" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-training" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list training">
			
				<g:if test="${trainingInstance?.date}">
				<li class="fieldcontain">
					<span id="date-label" class="property-label"><g:message code="training.date.label" default="Date" /></span>
					
						<span class="property-value" aria-labelledby="date-label"><g:formatDate date="${trainingInstance?.date}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${trainingInstance?.trainingType}">
				<li class="fieldcontain">
					<span id="trainingType-label" class="property-label"><g:message code="training.trainingType.label" default="Training Type" /></span>
					
						<span class="property-value" aria-labelledby="trainingType-label"><g:link controller="trainingType" action="show" id="${trainingInstance?.trainingType?.id}">${trainingInstance?.trainingType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${trainingInstance?.gym}">
				<li class="fieldcontain">
					<span id="gym-label" class="property-label"><g:message code="training.gym.label" default="Gym" /></span>
					
						<span class="property-value" aria-labelledby="gym-label"><g:link controller="gym" action="show" id="${trainingInstance?.gym?.id}">${trainingInstance?.gym?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${trainingInstance?.rating}">
				<li class="fieldcontain">
					<span id="rating-label" class="property-label"><g:message code="training.rating.label" default="Rating" /></span>
					
						<span class="property-value" aria-labelledby="rating-label"><g:fieldValue bean="${trainingInstance}" field="rating"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${trainingInstance?.sets}">
					<div class="fieldcontain">
						<span id="sets-label" class="property-label"><g:message code="training.sets.label" default="Sets" /></span>
							<g:each in="${trainingInstance.sets}" var="s">
								<div class="property-value" aria-labelledby="sets-label">
									<g:link controller="set" action="show" id="${s.id}">${s?.exercise?.name}</g:link>
									<g:link controller="set" action="delete" id="${s.id}">${message(code: 'default.delete.label', args: [message(code: 'set.label', default: 'Set')])}</g:link>
								</div>
							</g:each>
					</div>
				</g:if>
				<div class="add">
					<g:link controller="set" action="create" params="['training.id': trainingInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'set.label', default: 'Set')])}</g:link>
				</div>
				
			
<%--				<g:if test="${trainingInstance?.user}">--%>
<%--				<li class="fieldcontain">--%>
<%--					<span id="user-label" class="property-label"><g:message code="training.user.label" default="User" /></span>--%>
<%--					--%>
<%--						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${trainingInstance?.user?.id}">${trainingInstance?.user?.encodeAsHTML()}</g:link></span>--%>
<%--					--%>
<%--				</li>--%>
<%--				</g:if>--%>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${trainingInstance?.id}" />
					<g:link class="edit" action="edit" id="${trainingInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
