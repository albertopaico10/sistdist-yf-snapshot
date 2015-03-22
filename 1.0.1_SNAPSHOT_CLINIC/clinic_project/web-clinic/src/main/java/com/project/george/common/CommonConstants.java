package com.project.george.common;

public class CommonConstants {
	
	public static final String ERROR="errorPage";
	public static final String SUCCESS="success";
	public static final int STATUS_ACTIVE=1;
	public static final String classTable="tableStyle";
	public static final String classTableRed="tdDatatableColorRed";
	public static final String classTableBlue="tdDatatableColorBlue";
	
	public class Login{
		public static final String RESPONS_LOGIN_OPEN="login";
		public static final String RESPONSE_LOGIN_CORRECT="welcome";		
//		public static final String RESPONSE_LOGIN_INCORRECT="errorLogin";
//		public static final String RESPONSE_LOGIN_INCORRECT="redirect:/logueo.htm";
		public static final String RESPONSE_LOGIN_INCORRECT="login";
		public static final String MESSAGES_RESPONSE_INCORRECT="welcome";
		public static final String ALGORITHM_MD5="MD5";
	}
	
	public class MantenienceRoles{
		public static final String RESPONSE_MANTENIENCE_ROLE="maintenanceRoles";
		public static final String RESPONSE_MANTENIENCE_ROLE_NEW="redirect:/listMaintenanceRoles.htm";
	}
	
	public class MantenienceArea{
		public static final String RESPONSE_MANTENIENCE_AREA="maintenanceArea";
		public static final String RESPONSE_MANTENIENCE_AREA_NEW="redirect:/listArea.htm";
	}
	
	public class ManteniencePresentation{
		public static final String RESPONSE_MANTENIENCE_PRESENTENTION="maintenancePresentation";
		public static final String RESPONSE_MANTENIENCE_PRESENTATION_NEW="redirect:/listPresentation.htm";
	}

	public class MantenienceProduct{
		public static final String RESPONSE_MANTENIENCE_PRODUCT="maintenanceProduct";
		public static final String RESPONSE_MANTENIENCE_PRODUCT_NEW="redirect:/listProduct.htm";
	}
	
	public class ManteniencePatient{
		public static final String RESPONSE_MANTENIENCE_PATIENT="maintenancePatient";
		public static final String RESPONSE_MANTENIENCE_PATIENT_NEW="redirect:/listMaintenancePatient.htm";
	}
	public class MantenienceNewPatient{
		public static final String RESPONSE_MANTENIENCE_PATIENT="maintenancePatient";
		public static final String RESPONSE_MANTENIENCE_PATIENT_NEW="redirect:/listMaintenancePatient.htm";
	}
	public class ErrorPage{
		public static final String RESPONSE_ERROR_PAGE="errorPage";
		public static final String RESPONSE_MANTENIENCE_PATIENT_NEW="redirect:/listMaintenancePatient.htm";
	}
	public class FormatDate{
		public static final String YYYY_MM_DD_HHMMSS="YYYY-MM-DD HH:mm:ss";
		public static final String MM_DD_YYYY_HHMMSS="MM-dd-YYYY HH:mm:ss";
		public static final String MM_DD_YYYY="MM/dd/yyyy";
	}
	public class SystemParam{
		public static final String NAME_PARAM_HISTORY_CLINIC="COD_CLI";
		public static final String NAME_PARAM_LAST_CODE="LAST_CODE";
	}
	
	public class RegisterKardex{
		public static final String RESPONSES_REGISTER_KARDEX="registerKardex";
		public static final String REDIRECT_REGISTER_KARDEX="redirect:/registerKardex.htm";
		public static final String RESPONSES_SUCCESS="success";
		public static final String TYPE_OPERATION_ENTRY="1";
		public static final String TYPE_OPERATION_EGRESS="2";
	}
	
	public class OptionDataBase{
		public static final String OPTION_MALE_ID="1";
	}
	
	public class ReturnAJAX{
		public static final String IS_NULL="NULL";
		public static final String IS_EMPTY="EMPTY";
	}
	public class ResponseIdResult{
		public static final String RESULT_CORRECT="SUCCESS";
		public static final String RESULT_CORRECT_UPDATE="SUCCESS_UPDATE";
		public static final String RESULT_CORRECT_DELETE="SUCCESS_DELETE";
		public static final String RESULT_ERROR="ERROR";
		public static final String RESULT_NOTWORKING="NOTWORKING";
		public static final String RESULT_EXIST_PRODUCT="ProductoExiste";
	}
	
	public class Logger{
		public final static String LOGGER_START="********START********";
		public final static String LOGGER_END="********END********";
	}
	
}
