<%@ include file="/WEB-INF/common/taglib.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">  
<head>  

<title><spring:message code="public.titulo"/></title> 
	<link href="${pageContext.request.contextPath}/resources/css/publicStyle.css" rel="stylesheet" type="text/css" media="screen" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.js"></script>	
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/1.13.0/jquery.validate.min.js"></script>
</head>  
<body>

	<div id="master">
		<div class="bodyPublico">
			<div class="header">
				<tiles:insertAttribute name="cabecera" />
			</div>

			<div class="contentpsb">
				<tiles:insertAttribute name="contenidoIzq" />
				<tiles:insertAttribute name="contenidoCentro" />
				<tiles:insertAttribute name="contenidoDcho" />
			</div>

			<div class="footer">
				<tiles:insertAttribute name="pie" />
			</div>
		</div>
	</div>

</body>  
</html>  