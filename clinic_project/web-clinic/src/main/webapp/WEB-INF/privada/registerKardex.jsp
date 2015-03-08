<%@ include file="/WEB-INF/common/taglib.jsp"%>
<div id="idDetailKardex" style="display: none" title="<spring:message code="show.detail.title.detail.kardex"/>">
	<div id='idTitleListDetail'>
		<label class="titlePage"><spring:message code="kardex.title" /></label>
	</div>
	<br/>
	<table>
		<tr>
			<td><div id="idNameProductDetail"></div></td>
			<td><div id="idCountProductTotal"></div></td>
		</tr>
		<tr>
			<td><div id="idSpanPriceTotalProduct"></div></td>
			<td><div id="idSpanPriceTotalSale"></div></td>
		</tr>
	</table>
	<div id="idDetailKardexData"></div>
</div>
<div id="frmRegisterKardex" style="display: none" title="<spring:message code="register.kardex.title"/>">
	<div id="typeMessagesFormKardex" class="lblmessagesred"></div>
	<form id="idRegisterKardexForm">
		<div id="divFormDiv" class="formDiv">
			<table>
				<tr>
					<td><label class="labelForm"><spring:message code="register.kardex.type.operation" /></label></td>
					<td>
						<select id="idTypeOperation">
							<option value="1"><spring:message code="register.kardex.type.operation.entry" />
							<option value="2"><spring:message code="register.kardex.type.operation.egress" />
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<div id="lblTypeOperation">
							<label class="labelForm"><spring:message code="register.kardex.type.operation" /></label>
						</div>
					</td>
					<td><input type="text" id="idCantidad" name="idCantidad"/></td>
				</tr>
				<tr>
					<td>
						<label class="labelForm"><spring:message code="register.kardex.comprobante.class" /></label>
					</td>
					<td>
						<div id="idSelectEntrada" style="display: none">
							<select id="idComprobanteClassEntrada">
								<option value="Boleta Venta">Boleta Venta</option>
								<option value="Factura">Factura</option>
							</select>
						</div>
						<div id="idSelectSalida" style="display: none">
							<select id="idComprobanteClassSalida">
								<option value="Boleta Venta">Boleta Venta</option>
								<option value="Informe">Informe</option>
							</select>
						</div>
<!-- 						<input type="text" id="idComprobanteClass" name="idComprobanteClass"/> -->
					</td>
				</tr>
				<tr>
					<td><label class="labelForm"><spring:message code="register.kardex.comprobante.number" /></label></td>
					<td><input type="text" id="idComprobanteNumber" name="idComprobanteNumber"/></td>
				</tr>
				<tr>
					<td>
						<input type="hidden" id="idProductKardex" /> 
						<input type="hidden" id="idDetailNameKardex" />
						<input type="hidden" id="idKardexMaster"/>
					</td>
				</tr>
			</table>


		</div>
		<div class="contenButtons">
			<button type="button" id="saveKardex">
				<spring:message code="maintenance.botton.new.form" />
			</button>
		</div>
	</form>
</div>
<div>
	<div id="idTitleList">
		<h2>
			<spring:message code="register.kardex.title" />
		</h2>
	</div>
	<div id="idFindProduct">
		<label><spring:message code="register.kardex.producto" /></label>
		<input	type="text" maxlength="60" id="idNameProduct" />
		<button type="submit" id="idFindProduct">
			<spring:message code="maintenance.generic.button.find" />
		</button>
		<div id="idShowError" class="lblmessagesred"></div>
		<input type="hidden" maxlength="60" id="idValueNameProduct" value="${nameProduct}" /> 
		<input type="hidden" maxlength="60" id="idValueProduct" value="${productId}" />
	</div>
	<br />
	<div>
		<c:if test="${listProduct==null}">
			<spring:message code="maintenance.type.product.list.empty" />
		</c:if>
		<c:if test="${listProduct!=null}">
			<table class="tableStyle" border="1">
				<tr class="thStyle">
					<th><spring:message code="maintenance.generic.table.id" /></th>
					<th><spring:message	code="maintenance.type.product.nombre.presentation" /></th>
					<th><spring:message	code="maintenance.presentation.nombre.presentation" /></th>
					<th><spring:message	code="maintenance.product.price.sale.title" /></th>
					<th><spring:message	code="register.kardex.expiration.date.title" /></th>
					<th><spring:message	code="maintenance.generic.table.registration" /></th>
				</tr>
				<c:forEach items="${listProduct}" var="listProductData">
					<tr>
						<td class="tdDatatable">${listProductData.id}</td>
						<td class="tdDatatable">${listProductData.nameProduct}</td>
						<td class="tdDatatable">${listProductData.namePresentation}</td>
						<td class="tdDatatable">${listProductData.priceSale}</td>
						<td class="tdDatatable">${listProductData.expirationDate}</td>
						<td class="tdDatatable"><a id="linkID"
							href="javascript:listKardex('${listProductData.id}','${listProductData.nameProduct}')"><img
								src="${pageContext.request.contextPath}/resources/images/1418564230_process.png"
								alt="HTML tutorial" style="width: 20px; height: 20px; border: 0"></a></td>
						<%-- 				<td class="tdDatatable"><a id="linkID_delete" href="javascript:fnOpenNormalDialog('${listPresentationData.id}','2')"><img src="${pageContext.request.contextPath}/resources/images/delete_icon.png" alt="HTML tutorial" style="width:20px;height:20px;border:0"></a></td> --%>
					</tr>
				</c:forEach>

			</table>
		</c:if>
	</div>
	<br />
	<div>
		<c:if test="${listKardex==null && valueKardexList==1}">
			<script type="text/javascript">
				$("#typeMessagesFormKardex").html('<label><spring:message code="register.kardex.comment.header.form"/></label>');
				$("#idTypeOperation").prop("disabled", true);
				$("#frmRegisterKardex").dialog({
					width : 550,
					height : 248
				});
				$("#idProductKardex").val($("#idValueProduct").val());
				$("#idDetailNameKardex").val($("#idValueNameProduct").val());
			</script>
		</c:if>
		<c:if test="${listKardex!=null}">
			<div id='idTitleList'>
				<label class='titlePage'><spring:message code="register.kardex.master.sub.title" /></label>
			</div>
			<button type="button" id="idNewKardexDetail">
				<spring:message code="register.kardex.new.detail" />
			</button>
			<c:if test="${errorStockProduct=='error'}">
				<label class="labelForm"><spring:message code="error.exceed.limit.product" /></label>
			</c:if>
			<table class="tableStyle" border="1">
				<tr class="thStyle">
					<th><spring:message code="maintenance.generic.table.id" /></th>
					<th><spring:message code="maintenance.type.product.nombre.presentation" /></th>
					<th><spring:message	code="maintenance.presentation.nombre.presentation" /></th>
					<th><spring:message	code="maintenance.generic.table.total.entry" /></th>
					<th><spring:message	code="maintenance.generic.table.total.egress" /></th>
					<th><spring:message code="maintenance.generic.table.count.total" /></th>
					<th><spring:message code="maintenance.generic.table.detail" /></th>
				</tr>
				<c:forEach items="${listKardex}" var="listKardexData">
					<tr>
						<td class="tdDatatable">
							<div id="idKardexTable">
								${listKardexData.id}
							</div>
						</td>
						<td class="tdDatatable">${listKardexData.nameProduct}</td>
						<td class="tdDatatable">${listKardexData.namePresentation}</td>
						<td class="tdDatatable">${listKardexData.totalEntry}</td>
						<td class="tdDatatable">${listKardexData.totalEgress}</td>
						<td class="tdDatatable">${listKardexData.countProduct}</td>
						<td class="tdDatatable">
							<a id="linkID" href="javascript:listDetailKardex('${listKardexData.id}','${listKardexData.nameProduct}','${listKardexData.priceTotalProduct}','${listKardexData.priceTotalSale}','${listKardexData.countProduct}')"><img src="${pageContext.request.contextPath}/resources/images/1419181097_Search-128.png"	alt="HTML tutorial" style="width: 20px; height: 20px; border: 0"></a>
						</td>
					</tr>
				</c:forEach>

			</table>
		</c:if>
	</div>
	<div id="kardexDetail"></div>

</div>
<script type="text/javascript">
	$(document).ready(function() {

	});

	function displayValues() {
		var valueSelect = $("#idTypeOperation").val();
		if (valueSelect == "1") {
			$("#lblTypeOperation").html('<label class="labelForm"><spring:message code="register.kardex.count.entry"/></label>');
			$("#idSelectEntrada").show();
			$("#idSelectSalida").hide();
		} else {
			$("#lblTypeOperation").html('<label class="labelForm"><spring:message code="register.kardex.count.egress"/></label>');
			$("#idSelectSalida").show();
			$("#idSelectEntrada").hide();
		}
	}

	$("select").change(displayValues);
	displayValues();

	$("#saveKardex").click(function(event) {
		var valueSelectForm = $("#idTypeOperation").val();
		var valueComprobanteNumber=$("#idComprobanteNumber").val();
		var valueComprobanteClase;
		var valueCantidad = $("#idCantidad").val();
		var idProduct = $("#idProductKardex").val();
		var typeKardexOperation = "newKardex";

		if(valueSelectForm=="1"){
			valueComprobanteClase = $("#idComprobanteClassEntrada").val();
		}else{
			valueComprobanteClase = $("#idComprobanteClassSalida").val();
		}
		
		if(valueCantidad==""){
			$("#typeMessagesFormKardex").html('<label class="labelForm"><spring:message code="validation.count.requerid"/></label>');
		}else if(!$.isNumeric(valueCantidad)){
			$("#typeMessagesFormKardex").html('<label class="labelForm"><spring:message code="validation.count.incorrect"/></label>');
		}else if(valueComprobanteNumber==""){
			$("#typeMessagesFormKardex").html('<label class="labelForm"><spring:message code="validation.comprobanteNumber.requerid"/></label>');	
		}else if(!$.isNumeric(valueComprobanteNumber)){
			$("#typeMessagesFormKardex").html('<label class="labelForm"><spring:message code="validation.comprobanteNumber.incorrect"/></label>');
		}else if(valueComprobanteClase==""){
			$("#typeMessagesFormKardex").html('<label class="labelForm"><spring:message code="validation.comprobanteclase.requerid"/></label>');
		}else{
			saveKardexByIdProduct(valueSelectForm, valueComprobanteNumber,
					valueComprobanteClase, valueCantidad, idProduct,
					typeKardexOperation);
		}
		
	});

	function saveKardexByIdProduct(valueSelectForm, valueComprobanteNumber,
			valueComprobanteClase, valueCantidad, idProduct,
			typeKardexOperation) {	
		var nameProduct = $("#idValueNameProduct").val();
		var idKardex = $("#idKardexMaster").val();
		document.location = "${pageContext.request.contextPath}/saveKardexByProduct.htm?nameProduct="+nameProduct+"&productId="+ idProduct+ "&cantidad="+ valueCantidad+ "&comprobanteClase="+ valueComprobanteClase+"&comprobanteNumber=" + valueComprobanteNumber+"&idKardex="+idKardex+"&typeOperation="+valueSelectForm;
	}

	$("#idFindProduct").click(function(event) {
		$("#idShowError").empty();
		var nameProduct = $("#idNameProduct").val();
		if(nameProduct==""){
			$("#idShowError").html('<label class="labelForm"><spring:message code="validation.insert.one.criteria"/></label>');
		}else{
			document.location = "${pageContext.request.contextPath}/findProduct.htm?nameProduct="+ nameProduct;	
		}
		
	});
	
	function listKardex(idProduct, nameProduct) {
		// 	alert("ID PRODUCT : "+idProduct);
		var nameProduct = $("#idValueNameProduct").val();
		document.location = "${pageContext.request.contextPath}/listKardexByProduct.htm?nameProduct="
				+ nameProduct + "&productId=" + idProduct;
	}

	function listDetailKardex(idKardex, nameProduct,priceTotalProduct,priceTotalSale,countTotalProduct) {
		$.ajax({
			url : '${pageContext.request.contextPath}/listDetailKardex.htm',
			type : 'GET',
			data : 'kardexId=' + idKardex,
			success : function(response) {
				loadDetailKardex(response,nameProduct,priceTotalProduct,priceTotalSale,countTotalProduct);
			},
			error : function() {
				alert('Error in AJAX');
			}
		});
	}
	
	function loadDetailKardex(response,nameProduct,priceTotalProduct,priceTotalSale,countTotalProduct) {
		$("#idDetailKardexData").html(response);
		$("#idNameProductDetail").html('<label class="labelFormDetail"><spring:message code="maintenance.type.product.name"/></label><label class="labelForm">'+nameProduct+'</label>');
		$("#idSpanPriceTotalProduct").html('<label class="labelFormDetail"><spring:message code="price.total.product"/></label><label class="labelForm">'+priceTotalProduct+'</label>');
		$("#idSpanPriceTotalSale").html('<label class="labelFormDetail"><spring:message code="price.total.sale"/></label><label class="labelForm"> '+priceTotalSale+'</label>');
		$("#idCountProductTotal").html('<label class="labelFormDetail"><spring:message code="register.kardex.count.total"/></label><label class="labelForm"> '+countTotalProduct+'</label>');
		$("#idDetailKardex").dialog({
			width : 978,
			height : 321
		});
	
	}

	function loadNewKardex(idProduct, nameProduct,idKardex) {
		$("#typeMessagesFormKardex").html('<label><spring:message code="register.kardex.comment.header.form.new"/></label>');
		$("#idTypeOperation").prop("disabled", false);
		$("#frmRegisterKardex").dialog({
			width : 550,
			height : 248
		});
		$("#idProductKardex").val(idProduct);
		$("#idDetailNameKardex").val(nameProduct);
		$("#idKardexMaster").val(idKardex);
	}
	
	$("#idNewKardexDetail").click(function(event) {
		var nameProduct = $("#idValueNameProduct").val();
		var idKardex=$("#idKardexTable").text();
		var idProduct = $("#idValueProduct").val();
		clearForm();
		loadNewKardex(idProduct,nameProduct,idKardex.trim());
	});
	
	function clearForm(){
		$("#idTypeOperation").val("1");
		$("#idCantidad").val("");
		$("#idComprobanteNumber").val("");
		displayValues();
	}
</script>