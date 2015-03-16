<%@ include file="/WEB-INF/common/taglib.jsp"%>
<div>
	<div id="titleFormPatient">
		<h2>
			<spring:message code="atention.patient.title" />
		</h2>
	</div>
	
	<button type="button" id="new_patient">
		<spring:message code="maintenance.patient.botton.new.patient" />
	</button>
	<br/><br/>
	<div id="divTableGet" class="cssTableGet">
	<html:form action="" method="GET">
	<table style="width: 100%;" >
		<tr>
			<td>
				<table class="tableStyle" id="idTableJson" border="1" cellpadding="8" >
					<thead>		
					<tr class="thStyle">
						<th ><spring:message code="maintenance.generic.table.id" /></th>
			
						<th ><spring:message code="maintenance.patient.table.name" /></th>
						<th ><spring:message code="maintenance.patient.table.dni" /></th>
						<th ><spring:message code="maintenance.patient.table.historyClinic" /></th>
						<th ><spring:message code="maintenance.patient.table.address" /></th>
						<th ><spring:message code="maintenance.patient.table.districtName" /></th>
						<th ><spring:message code="maintenance.patient.table.birthDay" /></th>
						<th ><spring:message code="maintenance.patient.table.age" /></th>
						<th ><spring:message code="maintenance.patient.table.sex" /></th>
						<th ><spring:message code="maintenance.patient.table.name.reference" /></th>
						<th ><spring:message code="maintenance.patient.table.phone.reference" /></th>
			
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
<div id="frmMaintenancePatient" style="display: none;" title="<spring:message code="maintenance.patient.title.add"/>">
	<html:form method="POST" commandName="maintenancePatientForm" action="registerPatient.htm" id="idMaintenancePatientForm" novalidate="novalidate">
		<div id="divFormDivPatient" class="formDiv">
			<table>
				<tr>
					<td>
						<label for="userName" class="labelForm"><spring:message code="maintenance.patient.name.form" /></label>
					</td>
					<td>
						<html:input path="namePatient" maxlength="60" id="namePatient" class="inputTextStye"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="userName" class="labelForm"><spring:message code="maintenance.patient.lastName.form" /></label>
					</td>
					<td>
						<html:input path="lastNamePatient" maxlength="60" id="lastNamePatient"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="userName" class="labelForm"><spring:message code="maintenance.patient.DNI.form" /></label>
					</td>
					<td>
						<html:input path="dni" maxlength="8" id="dni"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="userName" class="labelForm"><spring:message code="maintenance.patient.birthDate.form" /></label>
					</td>
					<td>
						<html:input path="birthDay" id="birthDay" class="dateStyle"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="userName" class="labelForm"><spring:message code="maintenance.patient.history.clinic.form" /></label>
					</td>
					<td>
						<html:input path="codeHistoryClinic" id="codeHistoryClinic" readonly="true"/>
					</td>
				</tr>
				
				<tr>
					<td>
						<label for="userName" class="labelForm"><spring:message code="maintenance.patient.adress.form" /></label>
					</td>
					<td>
						<html:input path="adress" maxlength="100" id="adress"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="userName" class="labelForm"><spring:message code="maintenance.patient.district.form" /></label>
					</td>
					<td>
						<html:input path="districtName" maxlength="100" id="districtName"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="userName" class="labelForm"><spring:message code="maintenance.patient.sex.form" /></label>
					</td>
					<td>
<%-- 						<html:radiobutton value="1" id="sex"/><spring:message code="male.option" /> --%>
<%-- 						<html:radiobutton value="2" id="sex"/><spring:message code="female.option" /> --%>
						<input type="radio" value="1" id="idRbMale"><spring:message code="male.option" />
						<input type="radio" value="2" id="idRbFemale"><spring:message code="female.option" />
						<html:hidden path="sex" maxlength="100" id="finalsex"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="userName" class="labelForm"><spring:message code="maintenance.patient.nameperson.reference.form" /></label>
					</td>
					<td>
						<html:input path="nameReference" maxlength="100" id="idNameReference"/>
					</td>
				</tr>
				<tr>
					<td>
						<label for="userName" class="labelForm"><spring:message code="maintenance.patient.phone.reference.form" /></label>
					</td>
					<td>
						<html:input path="phoneReference" maxlength="9" id="idPhoneReference"/>
					</td>
				</tr>
			</table>			
		</div>
		<div id="divIdPatient"></div>
		<div class="contenButtons">
			<button type="submit" id="savePatient">
				<spring:message code="maintenance.botton.new.form"/>
			</button>
		</div>
	</html:form>
</div>
<div id="dialog-confirm"></div>
<script>
$(document).ready(function() {
	
	$('#idTableJson').dataTable( {
		"bProcessing": false,
        "bServerSide": false,
        "sort": "position",
        "sAjaxSource": "listAllPatientJson.htm",
        "sAjaxDataProp" : "patientData",
        "aoColumns": [
            { "mData": "id",
            	"sClass":"tdDatatable"
            },
            { "mData": "completeName",
            	"sClass":"tdDatatable" },
            { "mData": "dni",
                "sClass":"tdDatatable" },
            { "mData": "codeHistoryClinic",
                "sClass":"tdDatatable" },
            { "mData": "address",
                 "sClass":"tdDatatable" },
            { "mData": "districtName",
                 "sClass":"tdDatatable" },
            { "mData": "birthDayFormat" ,
                 "sClass":"tdDatatable"},
            { "mData": null ,
                 "sClass":"tdDatatable",
                 "mRender":function(data,type,full){
                	 return data.edad+' '+'<spring:message code="maintenance.generic.age" />';
                 }
            },
            { "mData": null ,
                "sClass":"tdDatatable",
                "mRender":function(data,type,full){
	               	if(data.idSexo==1){
	               		return '<spring:message code="male.option" />';	
	               	}
	               	else{
	               		return '<spring:message code="female.option" />';
	               	}
	               	return "";
                }
           	},
            { "mData": "nameReference" ,
                "sClass":"tdDatatable"},
            { "mData": "phoneReference" ,
                "sClass":"tdDatatable"},
            { "mData": null,
            	"sClass":"tdDatatable",
            	"mRender":function(data,type,full){
					return '<a href="javascript:updatePatient('+"'"+data.id+"'"+",'"+data.namePatient+"'"+",'"+data.lastNamePatient+"'"+",'"+data.dni+"'"+",'"+data.codeHistoryClinic+"'"+",'"+data.address+"'"+",'"+data.districtName+"'"+",'"+data.idSexo+"'"+",'"+data.nameReference+"'"+",'"+data.phoneReference+"'"+",'"+data.birthDayFormat+"'"+');"><img src="${pageContext.request.contextPath}/resources/images/edit_icon.png" alt="HTML tutorial" style="width:20px;height:20px;border:0"></a>';
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
	
	
	$( "#birthDay").datepicker({maxDate: +0});
	
	$.validator.addMethod("dateFormat",
		    function(value, element) {
		        return value.match(/^\d\d?\/\d\d?\/\d\d\d\d$/);
		    },
	"Please enter a date in the format dd/mm/yyyy.");
	
	$("#idMaintenancePatientForm").validate({
		rules: {
			namePatient: "required",
			lastNamePatient: "required",
			dni:{
				required:true,
				number:true,
				minlength: 8
			},
			adress: "required",
			districtName: "required",
			birthDay: {
				required:true,
				dateFormat: true
			},
			'tbArea.id':{min:1},
			sex: "required",
			phoneReference:{
				maxlength: 9,
				number:true,
			}
		},
		messages: {
			namePatient: '<spring:message code="login.error.namePatient" />',
			lastNamePatient: '<spring:message code="login.error.lastNamePatient" />',
			dni: {
				required:'<spring:message code="login.error.dni" />',
				number:'<spring:message code="login.error.number" />',
				minlength:'<spring:message code="login.error.dni.count" />'
			},
			adress: '<spring:message code="login.error.adress" />',
			districtName: '<spring:message code="login.error.districtName" />',
			birthDay:{
				required:'<spring:message code="login.error.birthDay" />'
			} ,
			'tbArea.id': '<spring:message code="login.error.tbArea" />',
			sex: '<spring:message code="requerid.sex" />',
			phoneReference: {
				number:'<spring:message code="login.error.number" />',
				minlength:'<spring:message code="requerid.error.phone.max" />'
			}
		},
		submitHandler: function(form) {
            form.submit();
        }
	});
}); 
$("#new_patient" ).click(function( event ) {
	$( "#frmMaintenancePatient" ).dialog({
		width:569,
		height:408
	});
	$( "#namePatient" ).val("");
	$( "#lastNamePatient" ).val("");
	$( "#dni" ).val("");
	$( "#codeHistoryClinic" ).val("");
// 	$( "#historyClinic" ).hide();
	$( "#birthDay" ).val("");
	$( "#adress" ).val("");
	$( "#districtName" ).val("");
	$( "#idNameReference" ).val("");
	$( "#idPhoneReference" ).val("");
// 	$( 'select' ).val("0");
	$("#savePatient").html('<spring:message code="maintenance.botton.new.form" />');
});

$("#savePatient").click(function(){
	var title = $( "#frmMaintenancePatient" ).dialog( "option", "title" );
	var titleUpdate='<spring:message code="maintenance.roles.title.update" />';
	if(title==titleUpdate){
		$('#maintenanceRoleForm').attr('action', 'updateArea.htm').submit();
	}
});

$("#idRbMale").change(function () {
	if($('#idRbMale').is(':checked')){
		$( "#finalsex" ).val("1");
		$( "#idRbFemale" ).attr('checked',false);
		$( "#idRbMale" ).attr('checked',true);
	}
	
});

$("#idRbFemale").change(function () {
	if($('#idRbFemale').is(':checked')){
		$( "#finalsex" ).val("2");
		$( "#idRbMale" ).attr('checked',false);
		$( "#idRbFemale" ).attr('checked',true);
	}	
});

function updatePatient(idPatient,namePatient,lastNamePatient,dni,historyClinic,address,district,sexo,namereference,phonereference,birthDay){
	$("#divIdPatient").empty();
	$( "#frmMaintenancePatient" ).dialog({
		width:569,
		height:408
	});
	$( "#namePatient" ).val(namePatient+"");
	$( "#lastNamePatient" ).val(lastNamePatient+"");
	$( "#dni" ).val(dni+"");
	historyClinic=historyClinic.split("_");
	$( "#codeHistoryClinic" ).val(historyClinic[1]+"");
	$( "#birthDay" ).val(birthDay+"");
	$( "#adress" ).val(address+"");
	$( "#districtName" ).val(district+"");
// 	$( 'select' ).val(idArea+"");
	if(sexo=="1"){
		$( "#idRbFemale" ).attr('checked',false);
		$( "#idRbMale" ).attr('checked',true);
		$( "#finalsex" ).val("1");
	}else{
		$( "#idRbMale" ).attr('checked',false);
		$( "#idRbFemale" ).attr('checked',true);
		$( "#finalsex" ).val("2");
	}
	$( "#idNameReference" ).val(namereference+"");
	$( "#idPhoneReference" ).val(phonereference+"");
	$( "#frmMaintenancePatient" ).dialog('option', 'title', '<spring:message code="maintenance.patient.title.update" />');
	$("#savePatient").html('<spring:message code="maintenance.roles.botton.update.role.form" />');
	$("#divIdPatient").append('<input id="idPatient" name="id" type="hidden" value="'+idPatient+'"/>');
}

function fnOpenNormalDialog(id,option) {
    $("#dialog-confirm").html('<spring:message code="confirm.option.messages.delete.patient" />');

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
    	document.location="${pageContext.request.contextPath}/deleteMaintenancePatient.htm?idPatient="+id;
    }
}


</script>