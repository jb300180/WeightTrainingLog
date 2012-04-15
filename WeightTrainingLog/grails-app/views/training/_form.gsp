<%@ page import="de.bayer.wtl.Training" %>

<div class="fieldcontain ${hasErrors(bean: trainingInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="training.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${trainingInstance?.date}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: trainingInstance, field: 'trainingType', 'error')} ">
	<label for="trainingType">
		<g:message code="training.trainingType.label" default="Training Type" />
		
	</label>
	<g:select id="trainingType" name="trainingType.id" from="${de.bayer.wtl.TrainingType.list()}" optionKey="id" value="${trainingInstance?.trainingType?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: trainingInstance, field: 'gym', 'error')} ">
	<label for="gym">
		<g:message code="training.gym.label" default="Gym" />
		
	</label>
	<g:select id="gym" name="gym.id" from="${de.bayer.wtl.Gym.list()}" optionKey="id" value="${trainingInstance?.gym?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

<div class="fieldcontain ${hasErrors(bean: trainingInstance, field: 'rating', 'error')} required">
	<label for="rating">
		<g:message code="training.rating.label" default="Rating" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="rating" from="${0..5}" class="range" required="" value="${fieldValue(bean: trainingInstance, field: 'rating')}"/>
</div>


