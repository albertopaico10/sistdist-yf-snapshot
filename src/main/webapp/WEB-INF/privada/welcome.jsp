<%@ include file="/WEB-INF/common/taglib.jsp"%>

<b><spring:message code="welcome.titulo" /></b>&nbsp${userObject.nombreUsuario}&nbsp${userObject.apellidoUsuario}
<br/>
<br/>
<b><spring:message code="welcome.lastLogin" /></b>&nbsp${userObject.lastLoginFormat}
