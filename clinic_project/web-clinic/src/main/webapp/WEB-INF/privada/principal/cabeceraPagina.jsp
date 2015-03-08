<%@ include file="/WEB-INF/common/taglib.jsp"%>
<img alt="NexWm"
	src="${pageContext.request.contextPath}/resources/images/logoFinal.jpg"
	class="logoMain">

<div class="session">
	<a id="sessText"
		href="${pageContext.request.contextPath}/closeSession.htm" title='<spring:message code="close.session" />'>
		<img src="${pageContext.request.contextPath}/resources/images/close_session_icon.png" alt="HTML tutorial" style="width:40px;height:40px;border:0">
	</a>
	<br/>
	<label class="error"><b><spring:message code="close.session" /></b></label>
</div>

<div class="menu">
	<ul>
		<li class="nivel1">
			<a href="#"><spring:message code="menu.maintenance" /></a>
			<ul>
<!-- 				<li> -->
<%-- 					<a href="listMaintenanceRoles.htm" title="<spring:message code="menu.maintenance.roles" />"> --%>
<%-- 						<spring:message code="menu.maintenance.roles" /> --%>
<!-- 					</a> -->
<!-- 				</li> -->
<!-- 				<li> -->
<%-- 					<a href="listArea.htm" title="<spring:message	code="menu.maintenance.areas" />"> --%>
<%-- 						<spring:message	code="menu.maintenance.areas" /> --%>
<!-- 					</a> -->
<!-- 				</li> -->
				<li>
					<a href="listPresentation.htm" title="<spring:message	code="menu.maintenance.presentation" />">
						<spring:message	code="menu.maintenance.presentation" />
					</a>
				</li>
				<li>
					<a href="listProduct.htm" title="<spring:message	code="menu.maintenance.type.product" />">
						<spring:message	code="menu.maintenance.type.product" />
					</a>
				</li>
<!-- 				<li> -->
<%-- 					<a href="#" title="<spring:message	code="menu.maintenance.users" />"> --%>
<%-- 						<spring:message	code="menu.maintenance.users" /> --%>
<!-- 					</a> -->
<!-- 				</li> -->
			</ul>
		</li>
	</ul>
	<ul>
		<li class="nivel1">
			<a href="#"><spring:message code="menu.register" /></a>
			<ul>
				<li>
					<a href="listMaintenancePatient.htm" title="<spring:message code="menu.register.patient" />">
						<spring:message code="menu.register.patient" />
					</a>
				</li>
				<li>
					<a href="registerKardex.htm" title="<spring:message code="menu.register.kardex" />">
						<spring:message code="menu.register.kardex" />
					</a>
				</li>
			</ul>
		</li>
	</ul>

</div>
