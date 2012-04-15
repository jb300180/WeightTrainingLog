
<%@ page import="de.bayer.wtl.Training" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'training.label', default: 'Training')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
		
<g:javascript>
	function fadeOutOnDelete(deleteId) {
		console.info('fading out on success '+deleteId)
		$('#'+deleteId).parent().slideUp('slow')
	}
</g:javascript>
	</head>
	<body>
		
		<div id="show-training" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			
<%--			<g:if test="${flash.message}">--%>
				<div class="message" role="status">${flash.message}</div>
<%--			</g:if>--%>
			
<%--			<ul>--%>
			
				<g:if test="${trainingInstance?.date}">
					<span id="date-label" class="property-label"><g:message code="training.date.label" default="Date" /></span>
					<span class="property-value"><g:formatDate date="${trainingInstance?.date}" /></span>
				</g:if>
			
				<g:if test="${trainingInstance?.trainingType}">
					<span id="trainingType-label" class="property-label"><g:message code="training.trainingType.label" default="Training Type" /></span>
					<span class="property-value"><g:link controller="trainingType" action="show" id="${trainingInstance?.trainingType?.id}">${trainingInstance?.trainingType?.encodeAsHTML()}</g:link></span>
				</g:if>
			
				<g:if test="${trainingInstance?.gym}">
					<span id="gym-label" class="property-label"><g:message code="training.gym.label" default="Gym" /></span>
					<span class="property-value"><g:link controller="gym" action="show" id="${trainingInstance?.gym?.id}">${trainingInstance?.gym?.encodeAsHTML()}</g:link></span>
				</g:if>
			
				<g:if test="${trainingInstance?.rating}">
					<span id="rating-label" class="property-label"><g:message code="training.rating.label" default="Rating" /></span>
					<span class="property-value"><g:fieldValue bean="${trainingInstance}" field="rating"/></span>
				</g:if>
			
				<g:if test="${trainingInstance?.sets}">
					<table>
							<g:each in="${trainingInstance.sets}" var="s">
								<tr>
									<td>${s.order}</td>
									<td>${s.reps}</td>
									<td>${s.weight}</td>
									<td>${s.exercise?.name}</td>
										<td>
											<g:form controller="set">
												<g:hiddenField name="id" value="${s?.id}" />
												<g:actionSubmit action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}"/>
											</g:form>
										</td>
										<td> 
											<g:form controller="set">
												<g:hiddenField name="id" value="${s?.id}" />
												<g:actionSubmit action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" data-transition="pop"/>
											</g:form>
										</td>
								</tr>
							</g:each>
					</table>
				</g:if>
				
				<div class="add">
					<g:form controller="set" id="addSet">
						<g:hiddenField name="training.id" value="${trainingInstance?.id}" />
						<g:actionSubmit action="create" value="${message(code: 'default.button.add.label', default: 'Add')}"/>
					</g:form>
				</div>

		</div>
	</body>
</html>
