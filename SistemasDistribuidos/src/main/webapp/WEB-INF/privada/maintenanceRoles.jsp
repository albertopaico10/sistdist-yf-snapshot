<%@ include file="/WEB-INF/common/taglib.jsp"%>
Esta es la ventana de roles
<div>
	<h2>
		<spring:message code="maintenance.roles.title" />
	</h2>
	
	<a href="#" id="new_role"><spring:message code="maintenance.roles.botton.new.role" /></a>
	<br>
	<spring:message code="maintenance.roles.title.list" />
	<table>
		<tr>
			<th><spring:message code="maintenance.generic.table.id" /></th>
			<th><spring:message code="maintenance.roles.table.name" /></th>
			<th><spring:message code="maintenance.generic.table.edit" /></th>
			<th><spring:message code="maintenance.generic.table.delete" /></th>
		</tr>
		<c:forEach items="${listRole}" var="listRoleData">
			<tr	>
				<td>${listRoleData.id}</td>
				<td>${listRoleData.nombreRole}</td>
				<td><a id="linkID" href="javascript:updateRole('${listRoleData.id}','${listRoleData.nombreRole}')">A</a></td>
				<td><a id="linkID_delete" href="javascript:fnOpenNormalDialog('${listRoleData.id}','2')">X</a></td>
			</tr>
		</c:forEach>

	</table>

</div>
<div id="frmMaintenanceRole" style="display: none;" title="<spring:message code="maintenance.roles.title.add"/>">
	<html:form method="POST" commandName="maintenanceRoleForm" action="registerRole.htm" id="maintenanceRoleForm">
		<div id="divFormDiv" class="formDiv">
			<label for="userName"><spring:message code="maintenance.roles.nombre.role" /></label>
			<html:input path="nombreRole" maxlength="60" id="nameRole"/>
		</div>
		<div id="divIdRole"></div>
		<div class="contenButtons">
			<button type="submit" id="saveRole">
				<spring:message code="maintenance.roles.botton.new.role.form"/>
			</button>
		</div>
	</html:form>
</div>
<div id="dialog-confirm"></div>
<script>
$().ready(function() {
	$("#maintenanceRoleForm").validate({
		rules: {
			nameRole: "required"
		},
		messages: {
			nameRole: "Please enter your nameRole",
		}
	});
});
$("#new_role" ).click(function( event ) {
	$( "#frmMaintenanceRole" ).dialog();
	$( "#nameRole" ).val("");
	$("#saveRole").html('<spring:message code="maintenance.roles.botton.new.role.form" />');
});

$("#saveRole").click(function(){
	var title = $( "#frmMaintenanceRole" ).dialog( "option", "title" );
	var titleUpdate='<spring:message code="maintenance.roles.title.update" />';
	if(title==titleUpdate){
		$('#maintenanceRoleForm').attr('action', 'updateRole.htm').submit();
	}
});

function updateRole(idRole,nombreRole){
	$( "#frmMaintenanceRole" ).dialog();
	$( "#nameRole" ).val(nombreRole+"");
	$( "#frmMaintenanceRole" ).dialog('option', 'title', '<spring:message code="maintenance.roles.title.update" />');
	$("#saveRole").html('<spring:message code="maintenance.roles.botton.update.role.form" />');
	$("#divFormDiv").append('<input id="idRole" name="id" type="hidden" value="'+idRole+'"/>');
}

function fnOpenNormalDialog(id,option) {
    $("#dialog-confirm").html('<spring:message code="confirm.option.messages.delete.role" />');

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
    	document.location="${pageContext.request.contextPath}/deleteMaintenanceRole.htm?idRole="+id;
    }
}


</script>