<%@ include file="/WEB-INF/common/taglib.jsp"%>
<div>
	<div id="idTitleList">
		<h2>
			<spring:message code="maintenance.type.product.title" />
		</h2>
	</div>
	
	<button type="button" id="new_presentation">
		<spring:message code="maintenance.type.product.botton.new" />
	</button>
<%-- 	<a href="#" id="new_area"><spring:message code="maintenance.area.botton.new.area" /></a> --%>
	<br>
	<div id="idTitleList"><label class="titlePage"><spring:message code="maintenance.type.product.title.list" /></label></div>

	<div id="divTableGet" class="cssTableGet">
	<html:form action="" method="GET">
	<table style="width: 100%;" >
		<tr>
			<td>
				<table class="tableStyle" id="idTableJson" border="1" cellpadding="8" >
					<thead>		
					<tr class="thStyle">
						<th ><spring:message code="maintenance.generic.table.id" /></th>
						<th ><spring:message code="maintenance.type.product.nombre.presentation" /></th>
						<th ><spring:message code="maintenance.presentation.nombre.presentation" /></th>
						<th ><spring:message code="maintenance.product.price.buy.title" /></th>
						<th ><spring:message code="maintenance.product.price.sale.title" /></th>
						<th ><spring:message code="maintenance.product.price.sale.title" /></th>
						<th width="34px" ><spring:message code="maintenance.generic.table.edit" /></th>
						<th width="34px" ><spring:message code="maintenance.generic.table.delete" /></th>
					</tr>
					</thead>
				</table>
	 		</td>
	 	</tr>
	</table>
	</html:form>
	</div>
	
	
</div>
<div id="frmMaintenance" style="display: none;width: 600px" title="<spring:message code="maintenance.type.product.title.add"/>">
	<html:form method="POST" commandName="maintenanceForm" action="registerProduct.htm" id="idMaintenanceForm" novalidate="novalidate">
		<div id="divFormDiv" class="formDiv">
			<table>
				<tr>
					<td>
						<label for="userName" class="labelForm"><spring:message code="maintenance.type.product.name" /></label>
					</td>
					<td>
						<html:input path="nameProduct" maxlength="60" id="nameProduct"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="userName" class="labelForm"><spring:message code="maintenance.product.presentation" /></label>
					</td>
					<td>						
						<html:select path="tbPresentation.id" id="tbPresentation.id">
							<html:option value="0">
								<spring:message code="maintenance.product.option.0"/>
							</html:option>
							<html:options items="${listAllPresentation}" itemLabel="namePresentation" itemValue="id" />
						</html:select> 
					</td>
				</tr>
				<tr>
					<td>
						<label for="userName" class="labelForm"><spring:message code="maintenance.product.price.unit" /></label>
					</td>
					<td>
						<html:input path="price_Product" maxlength="60" id="price"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="userName" class="labelForm"><spring:message code="maintenance.product.price.sale" /></label>
					</td>
					<td>
						<html:input path="price_sale" maxlength="60" id="priceSale"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="userName" class="labelForm"><spring:message code="register.kardex.expiration.date" /></label>
					</td>
					<td>
						<html:input path="expirationDate" id="expirationDate" class="dateStyle"/>
					</td>
				</tr>
			</table>
		</div>
		<div id="divIdValue"></div>
		<div class="contenButtons">
			<button type="submit" id="idSave">
				<spring:message code="maintenance.botton.new.form"/>
			</button>
		</div>
	</html:form>
</div>
<div id="dialog-confirm"></div>
<script>
$(document).ready(function() {
	$( "#expirationDate").datepicker();
	
	$('#idTableJson').dataTable( {
		"bProcessing": false,
        "bServerSide": false,
        "sort": "position",
        "sAjaxSource": "listAllProductJson.htm",
        "sAjaxDataProp" : "productData",
        "aoColumns": [
            { "mData": "id",
            	"sClass":"tdDatatable"},
            { "mData": "nameProduct",
            	"sClass":"tdDatatable" },
            { "mData": "namePresentation",
                "sClass":"tdDatatable" },
            { "mData": null ,
                    "sClass":"tdDatatable",
                    "mRender":function(data,type,full){
                   	 return '<spring:message code="maintenance.generic.tipo.nuevos.soles" />'+' '+data.price;
                    } },
            { "mData": null ,
                    "sClass":"tdDatatable",
                    "mRender":function(data,type,full){
                  	 return '<spring:message code="maintenance.generic.tipo.nuevos.soles" />'+' '+data.priceSale;
                    } },
            { "mData": "expirationDate" ,
                    "sClass":"tdDatatable"},
            { "mData": null,
            	"sClass":"tdDatatable",
            	"mRender":function(data,type,full){
					return '<a href="javascript:updateField('+"'"+data.id+"'"+",'"+data.nameProduct+"'"+",'"+data.idPresentation+"'"+",'"+data.price+"'"+",'"+data.priceSale+"'"+",'"+data.expirationDate+"'"+');"><img src="${pageContext.request.contextPath}/resources/images/edit_icon.png" alt="HTML tutorial" style="width:20px;height:20px;border:0"></a>';
            	}
            }, 
            { "mData": null,
            	"sClass":"tdDatatable",
            	"mRender":function(data,type,full){
            		return '<a id="linkID_delete" href="javascript:fnOpenNormalDialog('+full.id+',2)"><img src="${pageContext.request.contextPath}/resources/images/delete_icon.png" alt="HTML tutorial" style="width:20px;height:20px;border:0"></a>';
            	}
            }, 
        ]
    } );	
		
	$("#idMaintenanceForm").validate({
		rules: {
			nameProduct: "required",
			price_Product:{
				required:true,
				number:true
			},
			'tbPresentation.id':{min:1},
			price_sale:{
				required:true,
				number:true,
// 				greaterThan:"#price"
			},
			expirationDate:"required"
		},
		messages: {
			nameProduct: '<spring:message code="maintenance.generic.field.required" />',
			price_Product:{
					required:'<spring:message code="maintenance.generic.field.required" />',
					number:'<spring:message code="login.error.number" />',
				},
			'tbPresentation.id': '<spring:message code="maintenance.generic.select.required" />',
			price_sale:{
				required:'<spring:message code="maintenance.generic.field.required" />',
				number:'<spring:message code="login.error.number" />',
// 				greaterThan:'<spring:message code="login.error.number" />'
			},
			expirationDate: '<spring:message code="maintenance.generic.field.required" />'
		},
        submitHandler: function(form) {
            form.submit();
        }
	});
});
$("#new_presentation" ).click(function( event ) {
	$( "#frmMaintenance" ).dialog({
		width:584,
		height:249
	});
	$( "#nameProduct" ).val("");
	$( "#price_Product" ).val("");
	$("#idSave").html('<spring:message code="maintenance.roles.botton.new.role.form" />');
});

$("#idSave").click(function(){
	var title = $( "#frmMaintenance" ).dialog( "option", "title" );
	var titleUpdate='<spring:message code="maintenance.roles.title.update" />';
	if(title==titleUpdate){
		$('#maintenanceRoleForm').attr('action', 'updateTypeProduct.htm').submit();
	}
});

function updateField(idValue,nameProduct,idPresentation,price,priceSale,expirationDate){
	$("#divIdValue").empty();
	$( "#frmMaintenance" ).dialog({
		width:584,
		height:249
	});
	$( "#nameProduct" ).val(nameProduct+"");
	$( 'select' ).val(idPresentation+"");
	$( "#price" ).val(price+"");
	$( "#priceSale" ).val(priceSale+"");
	$( "#expirationDate" ).val(expirationDate+"");
	$( "#frmMaintenance" ).dialog('option', 'title', '<spring:message code="maintenance.areas.title.update" />');
	$("#idSave").html('<spring:message code="maintenance.roles.botton.update.role.form" />');
	$("#divIdValue").append('<input id="idValue" name="id" type="hidden" value="'+idValue+'"/>');
}

function fnOpenNormalDialog(id,option) {
    $("#dialog-confirm").html('<spring:message code="confirm.option.messages.delete.presentation" />');

    // Define the Dialog and its properties.
    $("#dialog-confirm").dialog({
        resizable: false,
        modal: true,
        title: '<spring:message code="confirm.option.title" />',
        height: 150,
        width: 300,
        buttons: {
            "Yes": function () {
                $(this).dialog('close');
                callback(id,option);
            },
                "No": function () {
                $(this).dialog('close');
            }
        }
    });
}

$('#btnOpenDialog').click(fnOpenNormalDialog);

function callback(id,option) {
    if(option==2){
    	document.location="${pageContext.request.contextPath}/deleteMaintenanceProduct.htm?idProduct="+id;
    }
}
</script>