<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
<form:form method="post" modelAttribute="todo">
<h1>Enter New Todo Details</h1>
<fieldset class="mb-3">
<form:label path="description">Description</form:label>
<form:input type="text" path="description"/>
<form:errors path="description" cssClass="text-warning"/>
</fieldset>

<fieldset class="mb-3">
<form:label path="targetDate">Target Date</form:label>
<form:input type="datepicker" path="targetDate"/>
</fieldset>

<form:input type="hidden" path="id"/>
<form:input type="hidden" path="done"/>
<button class="btn btn-success">Add</button>
</form:form>
</div>
<%@ include file="common/footer.jspf" %>
<script type="text/javascript">
	$('#targetDate').datepicker({
	    format: 'yyyy-mm-dd'
	});
	</script>