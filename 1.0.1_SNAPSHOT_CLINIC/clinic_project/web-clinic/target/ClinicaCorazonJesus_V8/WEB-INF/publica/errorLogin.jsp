<%@ include file="/WEB-INF/common/taglib.jsp"%>
<div class="errorLogin">
	<h2>
		<spring:message code="error.loginFaild" />
	</h2>
	<html:form>
		<a href="closeSession.htm"><spring:message code="close.session" /></a>
	</html:form>
</div>
