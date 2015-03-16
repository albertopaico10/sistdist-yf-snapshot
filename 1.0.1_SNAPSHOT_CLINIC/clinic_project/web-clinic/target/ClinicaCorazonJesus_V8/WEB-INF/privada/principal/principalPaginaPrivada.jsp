<%@ include file="/WEB-INF/common/taglib.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta content="text/html; charset=utf-8" http-equiv="Content-Type"> 
	<title><spring:message code="public.titulo" /></title>
	<link href="${pageContext.request.contextPath}/resources/css/style.css"	rel="stylesheet" type="text/css" media="screen" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery-ui.css">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.js"></script>	
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-ui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/1.13.0/jquery.validate.min.js"></script>
<%-- 	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.3.2.min.js"></script> --%>
<!-- 	<script src="http://trirand.com/blog/jqgrid/js/jquery.jqGrid.min.js" type="text/javascript"></script> -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.js"></script>
<%-- 	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery.dataTables.min.js"></script> --%>
<!-- 	<script type="text/javascript" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script> -->
	
</head>
<body>
	<div id="master">
		
		<div class="body">
			
			<div class="header">
				<tiles:insertAttribute name="cabecera" />
			</div>
			
			<div class="content">
				<tiles:insertAttribute name="contenidoIzq" />
				<tiles:insertAttribute name="contenidoCentro" />
				<tiles:insertAttribute name="contenidoDcho" />
			</div>

			<div>
				<tiles:insertAttribute name="pie" />
			</div>
		</div>

	</div>

</body>
</html>
