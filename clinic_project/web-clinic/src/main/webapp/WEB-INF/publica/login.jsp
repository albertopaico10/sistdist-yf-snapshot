<%@ include file="/WEB-INF/common/taglib.jsp"%>

<div class="login">
	<br/>
	<div class="titleLogin">
		<h2>
			<spring:message code="login.titulo" />
		</h2>
	</div>
	
	<div class="obligatory">
		<spring:message code="login.campos.marcados" />
		<span>*</span>
		<spring:message code="login.campos.marcadosobligatorios" />
	</div>	
	<html:form method="POST" commandName="loginUsuForm" action="validateUser.htm" id="idLoginUsuForm" novalidate="novalidate">
		<div class="formDiv">
			<label> <spring:message code="login.userName" /> <span class="resaltadoInfo">*</span></label>
			<html:input path="userName" maxlength="60" cssClass="form" id="userName" />
		</div>
		<br/>
		<div class="formDiv">
			<label for="password">
				<spring:message	code="login.password" />
				<span>*</span>
			</label>
			<html:password path="password" maxlength="24" cssClass="form" id="password"/>
		</div>
		<c:if test="${messages == 'incorrect'}">
			<label class="error"><spring:message code="login.password.incorrect" /></label>
		</c:if>
		<div class="contenButtons">
			<button type="submit" id="idLogin">
				<spring:message code="login.ingresar"/>
			</button>
		</div>
	</html:form>
</div>
<script>
$(document).ready(function() {
	$("#idLoginUsuForm").validate({
		rules: {
			userName: "required",
			password: "required"
		},
		messages: {
			userName: '<spring:message code="login.error.user" />',
			password: '<spring:message code="login.error.password" />'
		},
		submitHandler: function(form) {
            form.submit();
        }
	});
});
</script>