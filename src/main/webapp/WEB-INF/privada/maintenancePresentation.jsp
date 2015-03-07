<%@ include file="/WEB-INF/common/taglib.jsp"%>
<div>
	<div id="idTitleList">
		<h2>
			<spring:message code="maintenance.presentation.title" />
		</h2>
	</div>
	
	<button type="button" id="new_presentation">
		<spring:message code="maintenance.presentation.botton.new.presention" />
	</button>
<%-- 	<a href="#" id="new_area"><spring:message code="maintenance.area.botton.new.area" /></a> --%>
	<br>
	<div id="idTitleList"><label class="titlePage"><spring:message code="maintenance.presentation.title.list" /></label></div>
	<c:if test="${listPresentation==null}"><spring:message code="maintenance.presentation.list.empty" /></c:if>
	<c:if test="${listPresentation!=null}">
	<table class="tableStyle" border="1">
		<tr class="thStyle">
			<th ><spring:message code="maintenance.generic.table.id" /></th>
			<th ><spring:message code="maintenance.presentation.nombre.presentation" /></th>
			<th ><spring:message code="maintenance.generic.table.edit" /></th>
			<th ><spring:message code="maintenance.generic.table.delete" /></th>
		</tr>
		<c:forEach items="${listPresentation}" var="listPresentationData">
			<tr	>
				<td class="tdDatatable">${listPresentationData.id}</td>
				<td class="tdDatatable">${listPresentationData.namePresentation}</td>
				<td class="tdDatatable"><a id="linkID" href="javascript:updateArea('${listPresentationData.id}','${listPresentationData.namePresentation}')"><img src="${pageContext.request.contextPath}/resources/images/edit_icon.png" alt="HTML tutorial" style="width:20px;height:20px;border:0"></a></td>
				<td class="tdDatatable"><a id="linkID_delete" href="javascript:fnOpenNormalDialog('${listPresentationData.id}','2')"><img src="${pageContext.request.contextPath}/resources/images/delete_icon.png" alt="HTML tutorial" style="width:20px;height:20px;border:0"></a></td>
			</tr>
		</c:forEach>

	</table>
	</c:if>
</div>
<div id="frmMaintenancePresentation" style="display: none;" title="<spring:message code="maintenance.presentation.title.add"/>">
	<html:form method="POST" commandName="maintenancePresentationForm" action="registerPresentation.htm" id="idMaintenancePresentationForm" novalidate="novalidate">
		<div id="divFormDiv" class="formDiv">
			<label><spring:message code="maintenance.presentation.nombre.presentation" /></label>
			<html:input path="namePresentation" maxlength="60" id="namePresentation"/>
		</div>
		<div id="divIdPresentation"></div>
		<div class="contenButtons">
			<button type="submit" id="savePresentation">
				<spring:message code="maintenance.botton.new.form"/>
			</button>
		</div>
	</html:form>
</div>
<div id="dialog-confirm"></div>
<script>
$(document).ready(function() {
	$("#idMaintenancePresentationForm").validate({
		rules: {
			namePresentation: "required"
		},
		messages: {
			namePresentation: "Please enter a Presentation"
		},
        submitHandler: function(form) {
            form.submit();
        }
	});
});
$("#new_presentation" ).click(function( event ) {
	$( "#frmMaintenancePresentation" ).dialog({
		width:331,
		height:170
	});
	$( "#namePresentation" ).val("");
	$("#savePresentation").html('<spring:message code="maintenance.roles.botton.new.role.form" />');
});

$("#savePresentation").click(function(){
	var title = $( "#frmMaintenancePresentation" ).dialog( "option", "title" );
	var titleUpdate='<spring:message code="maintenance.roles.title.update" />';
	if(title==titleUpdate){
		$('#maintenanceRoleForm').attr('action', 'updatePresentation.htm').submit();
	}
});

function updateArea(idArea,namePresentation){
	$("#divIdPresentation").empty();
	$( "#frmMaintenancePresentation" ).dialog();
	$( "#namePresentation" ).val(namePresentation+"");
	$( "#frmMaintenancePresentation" ).dialog('option', 'title', '<spring:message code="maintenance.areas.title.update" />');
	$("#savePresentation").html('<spring:message code="maintenance.roles.botton.update.role.form" />');
	$("#divIdPresentation").append('<input id="idArea" name="id" type="hidden" value="'+idArea+'"/>');
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
    	document.location="${pageContext.request.contextPath}/deleteMaintenancePresentation.htm?idPresentation="+id;
    }
}
</script>