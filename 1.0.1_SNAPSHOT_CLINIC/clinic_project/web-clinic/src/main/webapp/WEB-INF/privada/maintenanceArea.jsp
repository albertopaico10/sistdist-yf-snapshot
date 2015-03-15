<%@ include file="/WEB-INF/common/taglib.jsp"%>
<div>
	<div id="idTitleList">
		<h2>
			<spring:message code="maintenance.area.title" />
		</h2>
	</div>
	
	<button type="button" id="new_area">
		<spring:message code="maintenance.area.botton.new.area" />
	</button>
<%-- 	<a href="#" id="new_area"><spring:message code="maintenance.area.botton.new.area" /></a> --%>
	<br>
	<div id="idTitleList"><label class="titlePage"><spring:message code="maintenance.area.title.list" /></label></div>
	<table class="tableStyle" border="1">
		<tr class="thStyle">
			<th ><spring:message code="maintenance.generic.table.id" /></th>
			<th ><spring:message code="maintenance.areas.nombre.areas" /></th>
			<th ><spring:message code="maintenance.generic.table.edit" /></th>
			<th ><spring:message code="maintenance.generic.table.delete" /></th>
		</tr>
		<c:forEach items="${listArea}" var="listAreaData">
			<tr	>
				<td class="tdDatatable">${listAreaData.id}</td>
				<td class="tdDatatable">${listAreaData.nameArea}</td>
				<td class="tdDatatable"><a id="linkID" href="javascript:updateArea('${listAreaData.id}','${listAreaData.nameArea}')"><img src="${pageContext.request.contextPath}/resources/images/edit_icon.png" alt="HTML tutorial" style="width:20px;height:20px;border:0"></a></td>
				<td class="tdDatatable"><a id="linkID_delete" href="javascript:fnOpenNormalDialog('${listAreaData.id}','2')"><img src="${pageContext.request.contextPath}/resources/images/delete_icon.png" alt="HTML tutorial" style="width:20px;height:20px;border:0"></a></td>
			</tr>
		</c:forEach>

	</table>

</div>
<div id="frmMaintenanceArea" style="display: none;" title="<spring:message code="maintenance.areas.title.add"/>">
	<html:form method="POST" commandName="maintenanceAreaForm" action="registerArea.htm" id="idMaintenanceAreaForm" novalidate="novalidate">
		<div id="divFormDiv" class="formDiv">
			<label><spring:message code="maintenance.areas.nombre.areas" /></label>
			<html:input path="nameArea" maxlength="60" id="nameArea"/>
		</div>
		<div id="divIdArea"></div>
		<div class="contenButtons">
			<button type="submit" id="saveArea">
				<spring:message code="maintenance.botton.new.form"/>
			</button>
		</div>
	</html:form>
</div>
<div id="dialog-confirm"></div>
<script>
$(document).ready(function() {
	$("#idMaintenanceAreaForm").validate({
		rules: {
			nameArea: "required"
		},
		messages: {
			nameArea: "Please enter a Area"
		},
        submitHandler: function(form) {
            form.submit();
        }
	});
});
$("#new_area" ).click(function( event ) {
	$( "#frmMaintenanceArea" ).dialog();
	$( "#nameArea" ).val("");
	$("#saveArea").html('<spring:message code="maintenance.roles.botton.new.role.form" />');
});

$("#saveArea").click(function(){
	var title = $( "#frmMaintenanceRole" ).dialog( "option", "title" );
	var titleUpdate='<spring:message code="maintenance.roles.title.update" />';
	if(title==titleUpdate){
		$('#maintenanceRoleForm').attr('action', 'updateArea.htm').submit();
	}
});

function updateArea(idArea,nameArea){
	$("#divIdArea").empty();
	$( "#frmMaintenanceArea" ).dialog();
	$( "#nameArea" ).val(nameArea+"");
	$( "#frmMaintenanceArea" ).dialog('option', 'title', '<spring:message code="maintenance.areas.title.update" />');
	$("#saveArea").html('<spring:message code="maintenance.roles.botton.update.role.form" />');
	$("#divIdArea").append('<input id="idArea" name="id" type="hidden" value="'+idArea+'"/>');
}

function fnOpenNormalDialog(id,option) {
    $("#dialog-confirm").html('<spring:message code="confirm.option.messages.delete.area" />');

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
    	document.location="${pageContext.request.contextPath}/deleteMaintenanceArea.htm?idArea="+id;
    }
}
</script>